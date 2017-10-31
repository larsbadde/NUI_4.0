# To support both python 2 and python 3
from __future__ import division, print_function, unicode_literals, absolute_import

from SimpleWebSocketServer import SimpleWebSocketServer, WebSocket
import json
import tensorflow as tf
# Common imports
import tensorflow as tf
import os
import pandas as pd
import numpy as np
import xlsxwriter
import time
import uuid
#from utils import sparse_tuple_from as sparse_tuple_from

"""
     Created by Lars Badde

"""


MAIN_DIR = os.getcwd()

mod_uuid = input('Model UUID eingeben...')
print('Start Running Model: ',mod_uuid)

n_steps = 1
n_inputs = 41
n_layers = 3
n_neurons = 150
n_outputs = 12
n_epochs = 200
batch_size = 1

preprocess_collapse_repeated=True
ctc_merge_repeated=False
applying_dropout = True
keep_prob = 0.5

global_step = tf.Variable(0, trainable=False)
learning_rate = 0.0001

momentum=0.95  # for Momentum_Optimizer

# PLEASE UPDATE THESE META-INFO WHEN UPDATING THE MODEL
META_INF_NAME = '3DRNN_LSTM_CTC'
META_INF_LAYERS = 'all LSTM'
META_INF_OUTPUT = 'Connectionist Temporal Classification'
META_INF_DROPOUT = ''.join((str(applying_dropout),'with keep_prob=',str(keep_prob)))
META_INF_NORMALIZATION = 'false'
META_INF_INFO = ''.join(('Momentum-Optimizer (momentum=',str(momentum),') . CTC_Loss. Including Peepholes. only last frame labeled valid with 10 as ngc. preprocess_collapse_repeated=',str(preprocess_collapse_repeated),', ctc_merge_repeated=',str(ctc_merge_repeated)))



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

X = tf.placeholder(tf.float32, [None, n_steps, n_inputs], name="input_x")
y = tf.sparse_placeholder(tf.int32)
seq_len = tf.placeholder(tf.int32, [None])

shape = tf.shape(X)
batch_s, max_timesteps = shape[0], shape[1]

training = False
lstm_cells = [tf.contrib.rnn.LSTMCell(num_units=n_neurons, use_peepholes=True)
              for layer in range(n_layers)]
lstm_cells_dropout = [tf.contrib.rnn.DropoutWrapper(cell, input_keep_prob=keep_prob)
                      for cell in lstm_cells]

if training and applying_dropout:
    multi_cell = tf.contrib.rnn.MultiRNNCell(lstm_cells_dropout)
else:
    multi_cell = tf.contrib.rnn.MultiRNNCell(lstm_cells)

# basic_cell = tf.contrib.rnn.OutputProjectionWrapper(tf.contrib.rnn.BasicLSTMCell(num_units=n_neurons),output_size=n_outputs)
outputs, states = tf.nn.dynamic_rnn(multi_cell, X, seq_len, dtype=tf.float32)

outputs = tf.reshape(outputs, [-1, n_neurons])

top_layer_h_state = states[-1][1]
W = tf.Variable(tf.truncated_normal([n_neurons,
                                     n_outputs],
                                    stddev=0.1))
# Zero initialization
# Tip: Is tf.zeros_initializer the same?
b = tf.Variable(tf.constant(0., shape=[n_outputs]))

# Doing the affine projection
logits = tf.matmul(outputs, W) + b

# Reshaping back to the original shape
logits = tf.reshape(logits, [batch_s, -1, n_outputs])

# Time major
logits = tf.transpose(logits, (1, 0, 2))


#logits = tf.layers.dense(top_layer_h_state, n_outputs, name="softmax")


loss = tf.nn.ctc_loss(y, logits, seq_len, preprocess_collapse_repeated=preprocess_collapse_repeated, ctc_merge_repeated=ctc_merge_repeated)
cost = tf.reduce_mean(loss)
optimizer = tf.train.MomentumOptimizer(learning_rate,
                                       momentum).minimize(cost)

# Option 2: tf.nn.ctc_beam_search_decoder
# (it's slower but you'll get better results)
decoded, log_prob = tf.nn.ctc_greedy_decoder(logits, seq_len)
# decoded, log_prob = tf.nn.ctc_beam_search_decoder(logits, seq_len, merge_repeated=False)

# Accuracy: label error rate
#acc = tf.reduce_mean(tf.edit_distance(tf.cast(decoded[0], tf.int32), y))

# Inaccuracy: label error rate
ler = tf.reduce_mean(tf.edit_distance(tf.cast(decoded[0], tf.int32),y))

#xentropy = tf.nn.sparse_softmax_cross_entropy_with_logits(labels=y, logits=logits)

#loss = tf.reduce_mean(xentropy)
#optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate)
#training_op = optimizer.minimize(loss)
#correct = tf.nn.in_top_k(logits, y, 1, name="correct")
pred = tf.argmax(logits, 2, name="prediction")
#accuracy = tf.reduce_mean(tf.cast(correct, tf.float32))

init = tf.global_variables_initializer()



#saver = tf.train.import_meta_graph("D:/NUI4.0/NUI4.0_Server/Export/TrainingData/ALL/Model/trained_model.ckpt.meta")
saver = tf.train.Saver()

with tf.Session() as sess:
    init.run()
    saver.restore(sess, ''.join((MODEL_EXPORT_DIR,"trained_model.ckpt")))
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
