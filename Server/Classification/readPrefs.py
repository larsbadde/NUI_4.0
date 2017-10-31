# To support both python 2 and python 3
from __future__ import division, print_function, unicode_literals, absolute_import
# Common imports
import xml.etree.ElementTree as ET
import tensorflow as tf
import os


"""
     Created by Lars Badde

"""

tree = ET.parse('preferences.xml')
root = tree.getroot()



def import_prefs():
    print("PEREFERENCES:")
    print("_________________________")
    for option in root.findall('option'):

        name= option.get('name')
        value = option.find('value').text
        print (name, value)
        if (name == 'NR_OF_EPOCHS'):
            NR_OF_EPOCHS=int(value)-1
        elif (name == 'NR_OF_STEPS'):
            NR_OF_STEPS=int(value)
        elif (name == 'NR_OF_LAYERS'):
            NR_OF_LAYERS=int(value)
        elif (name == 'NR_OF_NEURONS'):
            NR_OF_NEURONS=int(value)
        elif (name == 'NR_OF_OUTPUTS'):
            NR_OF_OUTPUTS=int(value)
        elif (name == 'NR_OF_INPUTS'):
            NR_OF_INPUTS=int(value)
        elif (name == 'BATCH_SIZE'):
            BATCH_SIZE=int(value)
        elif (name == 'PREPROCESS_COLLAPSE_REPEATED'):
            PREPROCESS_COLLAPSE_REPEATED=bool(value)
        elif (name == 'CTC_MERGE_REPEATED'):
            CTC_MERGE_REPEATED=bool(value)
        elif (name == 'APPLY_DROPOUT'):
            APPLY_DROPOUT=bool(value)
        elif (name == 'KEEP_PROB'):
            KEEP_PROB=float(value)
        elif (name == 'ACTIVATION'):
            if (value=='tanh'):
                ACTIVATION=tf.nn.tanh
            elif (value=='sigmoid'):
                ACTIVATION=tf.nn.sigmoid
            elif(value=='soft step'):
                ACTIVATION=tf.nn.softsign
            else:
                print('ALERT: The value of the Activation-function: ',value,' is not supported (yet)! Possible values={tanh,sigmoid,soft step}')
                ACTIVATION='not supported'
        elif (name=='LEARNING_RATE'):
            LEARNING_RATE=float(value)
        elif (name=='OPTIMIZER'):
            if (value=='gradient descent'):
                OPTIMIZER=1
            elif (value=='momentum'):
                OPTIMIZER=2
            elif (value=='rmsProp'):
                OPTIMIZER=3
            elif (value=='adaGrad'):
                OPTIMIZER=4
            elif (value=='adam'):
                OPTIMIZER=5
            else:
                print('ALERT: The value of the Optimizer: ',value,' is not supported (yet)! Possible values={gradient descent,momentum,rmsProp,adaGrad,adam}')
                OPTIMIZER='not supported'
        elif (name == 'MOMENTUM'):
            MOMENTUM=float(value)
        elif (name == 'EPSILON'):
            EPSILON=float(value)
        elif (name == 'DECAY_1'):
            DECAY_1=float(value)
        elif (name == 'DECAY_2'):
            DECAY_2=float(value)
        elif (name == 'USE_LOCKING'):
            USE_LOCKING=bool(value)
        elif (name == 'CENTERED'):
            CENTERED=bool(value)
        elif (name == 'MIN_ACC'):
            MIN_ACC=float(value)
        elif (name == 'MAX_FKP'):
            MAX_FKP=float(value)
        elif (name == 'MAX_EPOCHS_SICNE_LAST_MAX'):
            MAX_EPOCHS_SICNE_LAST_MAX=int(value)
        elif (name == 'MAX_TIMES_MAX_REACHED'):
            MAX_TIMES_MAX_REACHED=int(value)
    print("_________________________")
    return NR_OF_EPOCHS,NR_OF_STEPS,NR_OF_LAYERS,NR_OF_NEURONS,NR_OF_OUTPUTS,NR_OF_INPUTS,BATCH_SIZE,PREPROCESS_COLLAPSE_REPEATED,CTC_MERGE_REPEATED,APPLY_DROPOUT,KEEP_PROB,ACTIVATION,LEARNING_RATE,OPTIMIZER,MOMENTUM,EPSILON,DECAY_1,DECAY_2,USE_LOCKING,CENTERED, MIN_ACC, MAX_FKP, MAX_EPOCHS_SICNE_LAST_MAX, MAX_TIMES_MAX_REACHED