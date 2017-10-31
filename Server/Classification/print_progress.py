# To support both python 2 and python 3
from __future__ import division, print_function, unicode_literals, absolute_import

import colorama
from colorama import Fore, Back, Style
colorama.init()


"""
     Created by Lars Badde

"""

def put_cursor(x,y):
    print ("\x1b[{};{}H".format(y+1,x+1))
def clear():
    print ("\x1b[2J")

f = open('banner.txt', 'r')
file_content = f.read()

def printProgressBar (train_iteration, train_total, test_iteration, test_total,epoch_iteration, epoch_total,accuracy, fkp, last_max, epochs_since_last_max, times_max_reached, decimals = 1, length = 100, fill = '#'):
    """
    Call in a loop to create terminal progress bar
    @params:
        train_iteration   - Required  : current iteration in training(Int)
        train_total       - Required  : total iterations in training (Int)
        test_iteration   - Required  : current iteration in test(Int)
        test_total       - Required  : total iterations in test (Int)
        epoch_iteration   - Required  : current iteration global(Int)
        epoch_total       - Required  : total iterations gloabl (Int)
        accuray     - Required : accuracy of actual test-epoch (Float)
        fkp         - Required :
           ...
           ...
           ...
        decimals    - Optional  : positive number of decimals in percent complete (Int)
        length      - Optional  : character length of bar (Int)
        fill        - Optional  : bar fill character (Str)
    """
    percent_epoch = ("{0:." + str(decimals) + "f}").format(100 * (epoch_iteration / float(epoch_total)))
    percent_test = ("{0:." + str(decimals) + "f}").format(100 * (test_iteration / float(test_total)))
    percent_train = ("{0:." + str(decimals) + "f}").format(100 * (train_iteration / float(train_total)))
    filledLength_epoch = int(length * epoch_iteration // epoch_total)
    filledLength_test = int(length * test_iteration // test_total)
    filledLength_train = int(length * train_iteration // train_total)
    bar_epoch = fill * filledLength_epoch + '-' * (length - filledLength_epoch)
    bar_test = fill * filledLength_test + '-' * (length - filledLength_test)
    bar_train = fill * filledLength_train + '-' * (length - filledLength_train)

    suffix_epoch = ''
    suffix_test = ''
    suffix_train = ''
    if (fkp==99):
        fkp='nAn (no correct positives)'


    put_cursor(0, 1)

    print( file_content)
    print("Test accuracy:", "%.2f" % round((accuracy*100),2), '% fkP:', "%.2f" % round(fkp,2), 'Last maximum:',"%.2f" % round((last_max*100),2),'% reached',epochs_since_last_max,'epochs ahead. This Maximum was reached',times_max_reached,'time(s).', end='\n')

    print('\r%s |%s| %s%% %s' % ('Training: ', bar_train, percent_train, suffix_epoch), end = '\n')
    print('\r%s |%s| %s%% %s' % (' Testing: ', bar_test, percent_test, suffix_test), end = '\n')
    print('\r%s |%s| %s%% %s' % (' Global : ', bar_epoch, percent_epoch, suffix_train), end = '\r')
    print('\r', end='\r')
    print('\r', end='\r')


