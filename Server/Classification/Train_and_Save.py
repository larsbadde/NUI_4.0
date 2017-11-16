# To support both python 2 and python 3
from __future__ import division, print_function, unicode_literals, absolute_import
# Common imports
import tensorflow as tf
import os
import sys
import pandas as pd
import numpy as np
import xlsxwriter
import time
import uuid
from sys import argv
#from utils import sparse_tuple_from as sparse_tuple_from

#Unique imports
import readPrefs as prefs
import print_progress as progress


"""
     Created by Lars Badde

"""


os.environ['TF_CPP_MIN_LOG_LEVEL']='2'
MAIN_DIR = os.getcwd()

f = open('banner.txt', 'r')
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

if (OPTIMIZER==1):
    META_INF_ADDITIONAL_OPTIMIZER = ''.join(('Simple Gradient Descent ()'))
if (OPTIMIZER==2):
    META_INF_ADDITIONAL_OPTIMIZER = ''.join(('Momentum-Optimizer(momentum=',str(MOMENTUM),')'))
if (OPTIMIZER==3):
    META_INF_ADDITIONAL_OPTIMIZER = ''.join(('RMSProp-Optimizer(momentum=',str(MOMENTUM),',decay=',str(DECAY_1),',epsilon=',str(EPSILON),',use_locking=',str(USE_LOCKING),',centered=', str(CENTERED),')'))
if (OPTIMIZER==4):
    META_INF_ADDITIONAL_OPTIMIZER = ''.join(('AdaGrad-Optimizer(epsilon=',str(EPSILON),',decay=',str(DECAY_1),'use_locking=',str(USE_LOCKING),')'))
if (OPTIMIZER==5):
    META_INF_ADDITIONAL_OPTIMIZER = ''.join(('Adam-Optimizer(beta1=',str(DECAY_1),', beta2=',str(DECAY_2),',epsilon=',str(EPSILON),', use_locking=',str(USE_LOCKING),')'))

META_INF_INFO = ''.join((META_INF_ADDITIONAL_OPTIMIZER,'CTC_Loss. activation function: ',str(ACTIVATION),' Including Peepholes. only last frame labeled valid with 10 as ngc. preprocess_collapse_repeated=',str(PREPROCESS_COLLAPSE_REPEATED),', ctc_merge_repeated=',str(CTC_MERGE_REPEATED)))

mod_uuid =str(uuid.uuid4())


MODEL_EXPORT_DIR = ''.join((MAIN_DIR,"/Model_Export/", META_INF_NAME,'_',mod_uuid ,'/'))
DATA_IMPORT_PATH = ''.join((MAIN_DIR,"/Import_Data/"))
EXCEL_DIR = ''.join((MAIN_DIR,'/Results/Result_',META_INF_NAME,'_',mod_uuid ,'.xlsx'))



# CREATING AN EXCEL FILE WITH THE MODELS META-DATA AND TRAINING RESULTS:

# Create an new Excel file and add a worksheet.
workbook = xlsxwriter.Workbook(EXCEL_DIR)
# workbook = xlrd.open_workbook(EXCEL_DIR)    # ONLY WORKS IF FILE EXISTS ALREADY
worksheet = workbook.add_worksheet(META_INF_NAME)
# Widen the first column to make the text clearer.
worksheet.set_column('A:A', 20)
# Add a bold format to use to highlight cells.
bold = workbook.add_format({'bold': True})

# Write some META-INF to Excel-Sheet:
worksheet.write(1, 0, 'ModelName', bold)
worksheet.write(1, 1, META_INF_NAME)
worksheet.write(2, 0, 'Anzahl Layer', bold)
worksheet.write(2, 1, NR_OF_LAYERS)
worksheet.write(3, 0, 'Anzahl Neuronen', bold)
if (funnel==False):
    worksheet.write(3, 1, NR_OF_NEURONS)
if (funnel==True):
    worksheet.write(3, 1, ''.join(('funnel:',funnelInfo)))
worksheet.write(4, 0, 'Anzahl Inputs', bold)
worksheet.write(4, 1, NR_OF_INPUTS)
worksheet.write(5, 0, 'Anzahl Outputs', bold)
worksheet.write(5, 1, NR_OF_OUTPUTS)
worksheet.write(6, 0, 'Anzahl Epochen', bold)
worksheet.write(6, 1, NR_OF_EPOCHS)
worksheet.write(7, 0, 'TimeSteps', bold)
worksheet.write(7, 1, NR_OF_STEPS)
worksheet.write(8, 0, 'BatchSize', bold)
worksheet.write(8, 1, BATCH_SIZE)
worksheet.write(9, 0, 'LearningRate', bold)
worksheet.write(9, 1, LEARNING_RATE)
worksheet.write(10, 0, 'LayerInfo', bold)
worksheet.write(10, 1, META_INF_LAYERS)
worksheet.write(11, 0, 'OutputLayer', bold)
worksheet.write(11, 1, META_INF_OUTPUT)
worksheet.write(12, 0, 'Dropout', bold)
worksheet.write(12, 1, META_INF_DROPOUT)
worksheet.write(13, 0, 'Batch Normalisierung', bold)
worksheet.write(13, 1, META_INF_NORMALIZATION)
worksheet.write(14, 0, 'Additional Info', bold)
worksheet.write(14, 1, META_INF_INFO)
worksheet.write(15, 0, 'SIZE_TrainingData', bold)
worksheet.write(16, 0, 'SIZE_TestData', bold)
worksheet.write(17, 0, 'Duration', bold)


# WRITING THE TRAINING-DATA-HEADERS:
first_data_row = 19
first_matrix_row = first_data_row
first_matrix_cell = 16
worksheet.write(first_data_row, 0, 'EPOCHE', bold)
worksheet.write(first_data_row, 1, 'ACC_Train', bold)
worksheet.write(first_data_row, 2, 'ACC_Test', bold)
worksheet.write(first_data_row, 3, 'Anzahl Testsätze', bold)
worksheet.write(first_data_row, 4, 'Korrekt', bold)
worksheet.write(first_data_row, 5, 'Korrekte Positive', bold)
worksheet.write(first_data_row, 6, 'Korrekte Negative', bold)
worksheet.write(first_data_row, 7, 'Falsche Positive', bold)
worksheet.write(first_data_row, 8, 'Falsche Negative', bold)
worksheet.write(first_data_row, 9, 'Falsche Klasse', bold)
worksheet.write(first_data_row, 10, 'Label Error Rate', bold)
worksheet.write(first_data_row, 11, 'Duration(whole train and test set including BPTT)', bold)
worksheet.write(first_data_row, 12, 'Mean Prediction Duration', bold)
worksheet.write(first_data_row, 13, 'Training cost', bold)


builder = tf.saved_model.builder.SavedModelBuilder(MODEL_EXPORT_DIR)


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

def load_training_data(filename, data_path=DATA_IMPORT_PATH):
    csv_path = os.path.join(data_path, filename)
    td = pd.read_csv(csv_path)
    labels = create_labels(td)
    td_clean = create_dataframe(td)
    return td_clean, labels


def create_labels(training_data):
    labels = training_data['LABEL']
    return labels


def create_dataframe(training_data):
    training_df = training_data
    del training_df['LABEL']
    del training_df['SessionID']
    del training_df['t']
    return training_df


def reshape_data(td):
    dt = td.as_matrix()
    data = dt.reshape(dt.shape[0], 1, -1)
    # print("from ",td.shape," to ",data.shape)
    return data


def reshape_labels_to_sequences(labels):
    outer = np.zeros((len(labels), NR_OF_OUTPUTS))
    for iteration in range(len(labels)):
        for f in range(NR_OF_OUTPUTS):
            if f == labels[iteration] - 1:
                outer[iteration, f] = 1
            else:
                outer[iteration, f] = 0
    return outer


def save_model(session, input_tensor, output_tensor):
    signature = tf.saved_model.signature_def_utils.build_signature_def(
        inputs={'input': tf.saved_model.utils.build_tensor_info(input_tensor)},
        outputs={'output': tf.saved_model.utils.build_tensor_info(output_tensor)},
    )
    b = tf.saved_model.builder.SavedModelBuilder('D:/NUI4.0/NUI4.0_Server/Export/TrainingData/ALL/Model/tmp')
    b.add_meta_graph_and_variables(session,
                                   [tf.saved_model.tag_constants.SERVING],
                                   signature_def_map={
                                       tf.saved_model.signature_constants.DEFAULT_SERVING_SIGNATURE_DEF_KEY: signature})
    b.save()

res_matrix = np.zeros((NR_OF_OUTPUTS-1, NR_OF_OUTPUTS-1))
def initialize_prediction_matrix():
    res_matrix = np.zeros((NR_OF_OUTPUTS-1, NR_OF_OUTPUTS-1))
    worksheet.write(first_matrix_row-1,first_matrix_cell, "SOLL/IST-Matrix der letzten Epoche: ", bold)
    worksheet.write(first_matrix_row,first_matrix_cell," Soll (Reihe) \ Ist (Zeile)")
    for i in range(NR_OF_OUTPUTS-1):
        worksheet.write(first_matrix_row, first_matrix_cell+i+1, i, bold)   #Write Headers
        worksheet.write(first_matrix_row+i+1, first_matrix_cell, i, bold)  #Write Column-Names


def write_prediction_matrix(matr):
    for row in range(matr.shape[0]):
        for column in range (matr.shape[1]):
            worksheet.write(first_matrix_row+row+1, first_matrix_cell+column+1, matr[row, column])


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

def restoreModel(saver):
    mod_uuid = input('Model Namen eingeben...')
    MODEL_IMPORT_DIR = ''.join((MAIN_DIR,"/Model_Export/",mod_uuid ,'/'))
    path=''.join((MODEL_IMPORT_DIR,"trained_model.ckpt"))
    print("trying to reload ",path)
    saver.restore(sess, path)

def train_and_save_rnn():
    # create a Saver object as normal in Python to save your variables
    saver = tf.train.Saver()

    # Use a saver_def to get the "magic" strings to restore
    saver_def = saver.as_saver_def()
    #print(saver_def.filename_tensor_name)
    #print(saver_def.restore_op_name)

    # Loading the Train-DataSet
    data_train, labels_train = load_training_data("Train.csv")
    data_test, labels_test = load_training_data("Test.csv")


    # labels_train=reshape_labels_to_sequences(labels_train)
    # labels_test=reshape_labels_to_sequences(labels_test)

    # WRITE DATA-INF TO EXCEL
    worksheet.write(15, 1, data_train.shape[0])
    print("Training data size: ",data_train.shape[0])
    worksheet.write(16, 1, data_test.shape[0])
    print("Test data size: ",data_test.shape[0],"\n")

    dt_train = reshape_data(data_train)
    dt_test = reshape_data(data_test)
    #X_test = dt_test
    #X_test = X_test.reshape((-1, NR_OF_STEPS, NR_OF_INPUTS))
    #y_test = labels_test - 1
    initialize_prediction_matrix()

    last_max = 0
    epochs_since_last_max = 0
    times_max_reached =0




    sess.run(tf.global_variables_initializer())

    use_restore = input('Sollen die Gewichte eines vorhandenen Modells verwendet werden? (Y/n)').lower().strip()
    if (use_restore=="y" or use_restore==""):
        try:
            restoreModel(saver)
            print("Restored Model successfully.")
        except:
            print("Fehler beim Laden des Modells. Bitte noch ein mal versuchen.")
            restoreModel(saver)

    print ("Completey loaded. Start training...")
    f = open('banner_while.txt', 'r')
    file_content = f.read()
    print(file_content)
    time.sleep(7)
    fkp = 0
    last_max = 0
    epochs_since_last_max = 0
    times_max_reached = 0
    accuracy = 0

    # START TRAINING ...

    for epoch in range(NR_OF_EPOCHS):
        try :

            res_matrix = np.zeros((NR_OF_OUTPUTS-1, NR_OF_OUTPUTS-1))
            epoch_start_time = time.time()
            progress.clear()
            for iteration in range(dt_train.shape[0]):
                train_cost = train_ler = 0
                X_batch, y_batch = dt_train[iteration], (labels_train[iteration])
                X_batch = X_batch.reshape((-1, NR_OF_STEPS, NR_OF_INPUTS))
                y_batch = y_batch.reshape((1))
                corr = y_batch[0]
                y_batch = sparse_tuple_from([y_batch])
                train_seq_len = [X_batch.shape[1]]
                feed = {X: X_batch,
                        y: y_batch,
                        seq_len: train_seq_len}
                #sess.run(training_op, feed_dict={X: X_batch, y: y_batch})
                batch_cost, _ = sess.run([cost_train, optimizer_train], feed)
                train_cost += batch_cost*BATCH_SIZE
                train_ler += sess.run(ler_train, feed_dict=feed)*BATCH_SIZE
                progress.printProgressBar(iteration, dt_train.shape[0], 0, dt_test.shape[0], epoch, NR_OF_EPOCHS, accuracy, fkp, last_max, epochs_since_last_max, times_max_reached)


            #print('Epoche ',epoch,' Training done ... ')
            correct =0
            false = 0
            false_positive = 0
            false_negative = 0
            correct_negative = 0
            correct_positive = 0
            count = 0
            duration_for_single_predicition = 0
            progress.clear()
            for iteration in range(dt_test.shape[0]):
                train_cost = train_ler = 0
                X_batch, y_batch = dt_test[iteration], labels_test[iteration]
                X_batch = X_batch.reshape((-1, NR_OF_STEPS, NR_OF_INPUTS))
                y_batch = y_batch.reshape((1))
                corr = y_batch[0]
                test_seq_len = [X_batch.shape[1]]
                y_batch = sparse_tuple_from([y_batch])
                val_feed = {X: X_batch,
                            y: y_batch,
                            seq_len: test_seq_len}

                t = time.time()
                pred_u =sess.run( pred, feed_dict=val_feed)
                duration_for_single_predicition=time.time()-t
                batch_cost, _ = sess.run([cost, optimizer], val_feed)
                train_cost += batch_cost*BATCH_SIZE
                train_ler += sess.run(ler, feed_dict=val_feed)*BATCH_SIZE
                prediction = pred_u.item(0)
                #iterations_needed =dt_test.shape[0]
                #print(iteration, ' of ',iterations_needed )
                # SOME STATISTICS:
                count+=1
                if (corr == prediction):
                    correct+=1
                    if (corr!=10):
                        correct_positive+=1
                    else:
                        correct_negative+=1
                else:
                    false+=1
                    if (corr!=10):
                        false_negative+=1
                    if (prediction!=10):
                        false_positive+=1
                accuracy = correct/count


                res_matrix[corr, prediction]+=1
                progress.printProgressBar(dt_train.shape[0], dt_train.shape[0], iteration, dt_test.shape[0], epoch, NR_OF_EPOCHS, accuracy, fkp, last_max, epochs_since_last_max, times_max_reached)

            # print(y_batch, " == ", sess.run(pred, feed_dict={X: X_batch, y: y_batch}), " == ",sess.run(correct, feed_dict={X: X_batch, y: y_batch}) )
            dur = round(time.time()-epoch_start_time,2)
            time_remaining = ((NR_OF_EPOCHS - epoch )-1)*dur
            hours_remaining = round(time_remaining / 3600)
            minutes_remaining  = round((time_remaining % 3600) /60)


            try :
                fkp=false_positive/correct_positive
            except:
                fkp=99


            line = first_data_row + epoch + 1
            worksheet.write(line, 0, epoch)
            worksheet.write(line, 1, 'null')
            worksheet.write(line, 2, accuracy)
            worksheet.write(line, 3, count)
            worksheet.write(line, 4, correct)
            worksheet.write(line, 5, correct_positive)
            worksheet.write(line, 6, correct_negative)
            worksheet.write(line, 7, false_positive)
            worksheet.write(line, 8, false_negative)
            worksheet.write(line, 9, (count-correct)-false_positive-false_negative)
            worksheet.write(line, 10, train_ler)
            worksheet.write(line, 11, dur)
            worksheet.write(line, 12, duration_for_single_predicition)
            worksheet.write(line, 13, train_cost)
            worksheet.write(line, 14, fkp)



            if (epoch==(NR_OF_EPOCHS-1)):
                write_prediction_matrix(res_matrix)

            if accuracy>last_max:
                last_max=accuracy
                epochs_since_last_max=0
                times_max_reached=1
            elif accuracy<last_max:
                epochs_since_last_max+=1
            elif accuracy==last_max:
                epochs_since_last_max=0
                times_max_reached+=1

            suffix = ''.join(('Complete ',str(epoch+1),' of ',str(NR_OF_EPOCHS+1),'  Estimated time (ignoring early stopping) ',str(hours_remaining),'h',str(minutes_remaining),'m'))
            #progress.printResults(str(epoch), str(accuracy),  str(fkp), str(last_max), str(epochs_since_last_max), str(times_max_reached))
            #progress.printProgressBar(epoch+1, NR_OF_EPOCHS+1, prefix= 'Progress: ', suffix= suffix, length= 50)


            # EARLY STOPPING
            if ( ((accuracy>=MIN_ACC) and (fkp<=MAX_FKP)) and ((epochs_since_last_max>=MAX_EPOCHS_SICNE_LAST_MAX) or (times_max_reached>=MAX_TIMES_MAX_REACHED))):
                write_prediction_matrix(res_matrix)
                worksheet.write(line+1, 2, 'early stopping applied')
                print('\n\nearly stopping...')
                break
            else:
                continue
        # INTERRUPT-HANDLING FOR KEYBOARD-EARLY-STOPPING
        except:
            print ("Interruption")
            write_prediction_matrix(res_matrix)
            print("\n\nInterrupted Process. Saving model to ",MODEL_EXPORT_DIR)
            builder.add_meta_graph_and_variables(sess, [tf.saved_model.tag_constants.SERVING])
            builder.save(True)  # true for human-readable
            saver.save(sess, ''.join((MODEL_EXPORT_DIR, '/trained_model.ckpt')))
            #worksheet.write(17, 1, round(duration,2))
            worksheet.write(line+1, 2, 'interruption applied')
            workbook.close()
            sys.exit(0)



    # SAVE THE TRAINED MODEL ...
    print ("\n\nMax epochs reached. Saving model to ",MODEL_EXPORT_DIR)
    builder.add_meta_graph_and_variables(sess, [tf.saved_model.tag_constants.SERVING])
    builder.save(True)  # true for human-readable
    saver.save(sess, ''.join((MODEL_EXPORT_DIR, '/trained_model.ckpt')))




start_time = time.time()
train_and_save_rnn()
duration = time.time() - start_time

worksheet.write(17, 1, round(duration,2))
workbook.close()

print ("Model trained and saved in ", round(duration,2))

