# To support both python 2 and python 3
from __future__ import division, print_function, unicode_literals, absolute_import
# Common imports
from SimpleWebSocketServer import SimpleWebSocketServer, WebSocket
import json
import tensorflow as tf
import os
import uuid

import numpy as np

#Unique imports
import readPrefs as prefs


"""
     Created by Lars Badde

"""

os.environ['TF_CPP_MIN_LOG_LEVEL']='2'
MAIN_DIR = os.getcwd()

f = open('banner_server.txt', 'r')
file_content = f.read()
print(file_content)
f.close()


# GET THE PREFERENCES FROM EXTERNAL XML-FILE:
NR_OF_EPOCHS,NR_OF_STEPS,NR_OF_LAYERS,NR_OF_NEURONS,NR_OF_OUTPUTS,NR_OF_INPUTS,BATCH_SIZE,PREPROCESS_COLLAPSE_REPEATED,CTC_MERGE_REPEATED,APPLY_DROPOUT,KEEP_PROB,ACTIVATION,LEARNING_RATE,OPTIMIZER,MOMENTUM,EPSILON,DECAY_1,DECAY_2,USE_LOCKING,CENTERED, MIN_ACC, MAX_FKP, MAX_EPOCHS_SICNE_LAST_MAX, MAX_TIMES_MAX_REACHED = prefs.import_prefs()

global_step = tf.Variable(0, trainable=False)


funnel = False
funnelInfo = '200, 150, 100 '

# PLEASE UPDATE THESE META-INFO WHEN UPDATING THE MODEL
META_INF_NAME = '3DRNN_LSTM_FINAL'
META_INF_LAYERS = 'all LSTM'
META_INF_OUTPUT = 'Connectionist Temporal Classification'
META_INF_DROPOUT = ''.join((str(APPLY_DROPOUT),'with keep_prob=',str(KEEP_PROB)))
META_INF_NORMALIZATION = 'false'

mod_uuid =str(uuid.uuid4())
training=False

MODEL_EXPORT_DIR = ''.join((MAIN_DIR,"/Model_Export/", META_INF_NAME,'_',mod_uuid ,'/'))
DATA_IMPORT_PATH = ''.join((MAIN_DIR,"/Import_Data/"))



def sparse_tuple_from(sequences, dtype=np.int32):
    """Create a sparse representention of x.
    Args:
        sequences: a list of lists of type dtype where each element is a sequence
    Returns:
        A tuple with (indices, values, shape)
    """
    indices = []
    values = []

    for n, seq in enumerate(sequences):
        indices.extend(zip([n]*len(seq), range(len(seq))))
        values.extend(seq)

    indices = np.asarray(indices, dtype=np.int64)
    values = np.asarray(values, dtype=dtype)
    shape = np.asarray([len(sequences), np.asarray(indices).max(0)[1]+1], dtype=np.int64)

    return indices, values, shape

class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'


sess = tf.InteractiveSession()

X = tf.placeholder(tf.float32, [None, NR_OF_STEPS, NR_OF_INPUTS], name="input_x")
y = tf.sparse_placeholder(tf.int32)
seq_len = tf.placeholder(tf.int32, [None])

shape = tf.shape(X)
batch_s, max_timesteps = shape[0], shape[1]

if (funnel==False):
    lstm_cells = [tf.contrib.rnn.LSTMCell(num_units=NR_OF_NEURONS, use_peepholes=True, activation=ACTIVATION)
                  for layer in range(NR_OF_LAYERS)]
if (funnel==True):
    lstm_cell_1= tf.contrib.rnn.LSTMCell(num_units=200, use_peepholes=True, activation=ACTIVATION)
    lstm_cell_2= tf.contrib.rnn.LSTMCell(num_units=150, use_peepholes=True, activation=ACTIVATION)
    lstm_cell_3= tf.contrib.rnn.LSTMCell(num_units=100, use_peepholes=True, activation=ACTIVATION)
    lstm_cells=[lstm_cell_1, lstm_cell_2,lstm_cell_3]

if (APPLY_DROPOUT==True):
    lstm_cells_dropout = [tf.contrib.rnn.DropoutWrapper(cell, input_keep_prob=KEEP_PROB)
                          for cell in lstm_cells]
else:
    lstm_cells_dropout = lstm_cells


multi_cell_train = tf.contrib.rnn.MultiRNNCell(lstm_cells_dropout)
multi_cell = tf.contrib.rnn.MultiRNNCell(lstm_cells)

# basic_cell = tf.contrib.rnn.OutputProjectionWrapper(tf.contrib.rnn.BasicLSTMCell(num_units=NR_OF_NEURONS),output_size=NR_OF_OUTPUTS)
outputs, states = tf.nn.dynamic_rnn(multi_cell, X, seq_len, dtype=tf.float32)
outputs_train, states_train = tf.nn.dynamic_rnn(multi_cell, X, seq_len, dtype=tf.float32)

outputs = tf.reshape(outputs, [-1, NR_OF_NEURONS])
outputs_train = tf.reshape(outputs_train, [-1, NR_OF_NEURONS])

top_layer_h_state = states[-1][1]
top_layer_h_state_train = states_train[-1][1]
W = tf.Variable(tf.truncated_normal([NR_OF_NEURONS,
                                     NR_OF_OUTPUTS],
                                    stddev=0.1))
# Zero initialization
# Tip: Is tf.zeros_initializer the same?
b = tf.Variable(tf.constant(0., shape=[NR_OF_OUTPUTS]))

# Doing the affine projection
logits = tf.matmul(outputs, W) + b
logits_train = tf.matmul(outputs_train, W) + b
# Reshaping back to the original shape
logits = tf.reshape(logits, [batch_s, -1, NR_OF_OUTPUTS])
logits_train = tf.reshape(logits_train, [batch_s, -1, NR_OF_OUTPUTS])
# Time major
logits = tf.transpose(logits, (1, 0, 2))
logits_train = tf.transpose(logits_train, (1, 0, 2))

#logits = tf.layers.dense(top_layer_h_state, NR_OF_OUTPUTS, name="softmax")


loss = tf.nn.ctc_loss(y, logits, seq_len, preprocess_collapse_repeated=PREPROCESS_COLLAPSE_REPEATED, ctc_merge_repeated=CTC_MERGE_REPEATED)
loss_train = tf.nn.ctc_loss(y, logits_train, seq_len, preprocess_collapse_repeated=PREPROCESS_COLLAPSE_REPEATED, ctc_merge_repeated=CTC_MERGE_REPEATED)
cost = tf.reduce_mean(loss)
cost_train = tf.reduce_mean(loss_train)

#[Gradient Descent; Momentum; RMSProp, AdaGrad, Adam]
if (OPTIMIZER==1):
    optimizer=tf.train.GradientDescentOptimizer(learning_rate=LEARNING_RATE, use_locking=USE_LOCKINGg).minimize(cost)
    optimizer_train=tf.train.GradientDescentOptimizer(learning_rate=LEARNING_RATE, use_locking=USE_LOCKING).minimize(cost_train)
if (OPTIMIZER==2):
    optimizer = tf.train.MomentumOptimizer(LEARNING_RATE,MOMENTUM).minimize(cost)
    optimizer_train = tf.train.MomentumOptimizer(LEARNING_RATE,MOMENTUM).minimize(cost_train)
if (OPTIMIZER==3):
    optimizer = tf.train.RMSPropOptimizer(learning_rate=LEARNING_RATE, decay=DECAY_1, momentum=MOMENTUM, epsilon=EPSILON, use_locking=USE_LOCKING, centered=CENTERED).minimize(cost)
    optimizer_train = tf.train.RMSPropOptimizer(learning_rate=LEARNING_RATE, decay=DECAY_1, momentum=MOMENTUM, epsilon=EPSILON, use_locking=USE_LOCKING, centered=CENTERED).minimize(cost_train)
if (OPTIMIZER==4):
    optimizer = tf.train.AdagradOptimizer(learning_rate=LEARNING_RATE, initial_accumulator_value=0.1, use_locking=USE_LOCKING).minimize(cost)
    optimizer_train = tf.train.AdagradOptimizer(learning_rate=LEARNING_RATE, initial_accumulator_value=0.1, use_locking=USE_LOCKING).minimize(cost_train)
if (OPTIMIZER==5):
    optimizer=tf.train.AdamOptimizer(learning_rate=LEARNING_RATE, beta1=DECAY_1, beta2=DECAY_2, epsilon=EPSILON, use_locking=USE_LOCKING).minimize(cost)
    optimizer_train=tf.train.AdamOptimizer(learning_rate=LEARNING_RATE, beta1=DECAY_1, beta2=DECAY_2, epsilon=EPSILON, use_locking=USE_LOCKING).minimize(cost_train)


# Option 2: tf.nn.ctc_beam_search_decoder
# (it's slower but you'll get better results)
decoded, log_prob = tf.nn.ctc_greedy_decoder(logits, seq_len)
decoded_train, log_prob_train = tf.nn.ctc_greedy_decoder(logits_train, seq_len)
# decoded, log_prob = tf.nn.ctc_beam_search_decoder(logits, seq_len, merge_repeated=False)

# Accuracy: label error rate
#acc = tf.reduce_mean(tf.edit_distance(tf.cast(decoded[0], tf.int32), y))
# Inaccuracy: label error rate
ler = tf.reduce_mean(tf.edit_distance(tf.cast(decoded[0], tf.int32),y))
ler_train = tf.reduce_mean(tf.edit_distance(tf.cast(decoded_train[0], tf.int32),y))
#xentropy = tf.nn.sparse_softmax_cross_entropy_with_logits(labels=y, logits=logits)

#loss = tf.reduce_mean(xentropy)
#optimizer = tf.train.AdamOptimizer(learning_rate=LEARNING_RATE)
#training_op = optimizer.minimize(loss)
#correct = tf.nn.in_top_k(logits, y, 1, name="correct")
pred = tf.argmax(logits, 2, name="prediction")
pred_train = tf.argmax(logits_train, 2, name="prediction")
#accuracy = tf.reduce_mean(tf.cast(correct, tf.float32))

init = tf.global_variables_initializer()



#saver = tf.train.import_meta_graph("D:/NUI4.0/NUI4.0_Server/Export/TrainingData/ALL/Model/trained_model.ckpt.meta")
saver = tf.train.Saver()


def restoreModel(saver):
    mod_uuid = input('Model Namen eingeben...')
    MODEL_IMPORT_DIR = ''.join((MAIN_DIR,"/Model_Export/",mod_uuid ,'/'))
    path=''.join((MODEL_IMPORT_DIR,"trained_model.ckpt"))
    print("trying to reload ",path)
    saver.restore(sess, path)


with tf.Session() as sess:
    init.run()
    restoreModel(saver);
    #tf.saved_model.loader.load(sess, [tf.saved_model.tag_constants.SERVING],"D:/NUI4.0/NUI4.0_Server/Export/TrainingData/ALL/Model/")

    def make_prediction(t):
        prediction = sess.run(pred, feed_dict={X: t, seq_len: [X.shape[1]]})
        return prediction.item(0)

    def buildHandVector(hand):
        X_new = [[[hand['HandPosition_X'],
                   hand['HandPosition_Y'],
                   hand['HandPosition_Z'],
                   hand['PalmNormal_pitch'],
                   hand['PalmNormal_yaw'],
                   hand['PalmNormal_roll'],
                   hand['Direction_pitch'],
                   hand['Direction_yaw'],
                   hand['Direction_roll'],
                   hand['grabAngle'],
                   hand['pinchDistance'],
                   hand['THUMB_Direction_pitch'],
                   hand['THUMB_Direction_yaw'],
                   hand['THUMB_Direction_roll'],
                   hand['THUMB_Center_X'],
                   hand['THUMB_Center_Y'],
                   hand['THUMB_Center_Z'],
                   hand['INDEX_Direction_pitch'],
                   hand['INDEX_Direction_yaw'],
                   hand['INDEX_Direction_roll'],
                   hand['INDEX_Center_X'],
                   hand['INDEX_Center_Y'],
                   hand['INDEX_Center_Z'],
                   hand['MIDDLE_Direction_pitch'],
                   hand['MIDDLE_Direction_yaw'],
                   hand['MIDDLE_Direction_roll'],
                   hand['MIDDLE_Center_X'],
                   hand['MIDDLE_Center_Y'],
                   hand['MIDDLE_Center_Z'],
                   hand['RING_Direction_pitch'],
                   hand['RING_Direction_yaw'],
                   hand['RING_Direction_roll'],
                   hand['RING_Center_X'],
                   hand['RING_Center_Y'],
                   hand['RING_Center_Z'],
                   hand['PINKY_Direction_pitch'],
                   hand['PINKY_Direction_yaw'],
                   hand['PINKY_Direction_roll'],
                   hand['PINKY_Center_X'],
                   hand['PINKY_Center_Y'],
                   hand['PINKY_Center_Z'],
                   ]]]
        return X_new;

    def messageToJson(msg):
        JsonMessage = json.loads(msg)
        message_type = JsonMessage['type']
        message_user = JsonMessage['userID']
        # print("received: "+message_type)
        if (message_type == "HandFrame"):
            hand = JsonMessage['hand']
            X_new = buildHandVector(hand)
            gesture = make_prediction(X_new)
            return gesture
    print("Model loaded and ready to predict .... ")

    class SimpleEcho(WebSocket):
        def handleMessage(self):
            # echo message back to client
            # self.sendMessage(self.data)
            # print(self.data)
            answer = messageToJson(self.data)
            if (answer!=10):
                ans = str(answer)
                self.sendMessage(ans)

        def handleConnected(self):
            print(self.address, 'connected')
            for client in clients:
                client.sendMessage(self.address[0] + u' - connected')
            clients.append(self)

        def handleClose(self):
            clients.remove(self)
            print(self.address, 'closed')
            for client in clients:
                client.sendMessage(self.address[0] + u' - disconnected')


    clients = []
    server = SimpleWebSocketServer('', 8000, SimpleEcho)
    print("WebSocket running")
    server.serveforever()
