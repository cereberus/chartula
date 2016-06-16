'''
filename:
speller_p300.py

type:
script

Detect p300 potential for spelling purposes.
'''

import numpy as np
import matplotlib.pyplot as plt

from utils_p300 import _create_letter_target

############################################
#                                          #
#             INIT SETTINGS                #
#                                          #
############################################

# how many samples per minute is acquired
sampling_rate = 240
sampling_frequency = 1/float(sampling_rate)

# which ranges to store (in milliseconds)
store_range = ((250, 500), (500, 750))
# store_range = ((0, 400), (400, 800))

# 6x6 organisation => 12 lines (6 rows, 6 cols)
n_lines = 12

# how many times line appear (is highlighted, etc.)
line_i_times = 15

# single line highlighting interval
# line_interval = 0.015625
line_interval = 0.100

# pause (lag) between lines - ISI - inter stimulus interval
# line_lag = 0.0625
line_lag = 0.075

# select the electrode
channel = 10


############################################
#                                          #
#          GET DATA FROM FILE              #
#                                          #
############################################
'''
    If it were real-time the data would come directly from eeg.
    For the simulation purpose it has to be read from the file.
'''

from scipy.io import loadmat


matfile = loadmat('data/AAS010R01.mat')

data = matfile['signal']
row_col = matfile['StimulusCode'].T[0].astype('int')-1
target = matfile['StimulusType'].T[0].astype('bool')

letter_target = _create_letter_target(
    row_col, sampling_rate, store_range[1][1]
    )

# how many letters was presented during one session
l_letters = np.unique(letter_target).shape[0]-1


############################################
#                                          #
#           OBJECTS CREATION               #
#                                          #
############################################

from p300_module import P300Manager

# create brain for our speller
p300 = P300Manager(
    sampling_rate, store_range,
    l_letters, n_lines, line_i_times,
    line_interval, line_lag,
    detection_method='min'
    )


############################################
#                                          #
#          DETECTING P300 ONLINE           #
#                                          #
############################################
'''
this function iterates x time in this simulator
as it does in the openbci
'''
from time import sleep


def detect_p300(sample):

    # get sample form the first channel (index '0')
    smp = sample.channel_data[channel]
    # smp = sample.channel_data.mean()

    # which letter did the subject look at
    letter = sample.aux_data[0]

    # which line (row or column) has been presented
    line = sample.aux_data[1]

    # put the sample to the storage
    p300.remember(smp, letter, line)


from utils_p300 import OpenBCISample

# iterate trough EEG data samples read form the file
for sample_num in range(len(data)):
    # create sample using openbci-like class
    sample = OpenBCISample(
        0, data[sample_num],
        [letter_target[sample_num], row_col[sample_num], 0]
        )

    sleep(sampling_frequency/100.)

    # stoing p300 information, classifying letters
    detect_p300(sample)


proper = [
    np.unique(row_col[np.logical_and(target == 1, letter_target == i)])
    for i in range(l_letters)
    ]

print('\n\nIt should be:')
for i in range(len(proper)):
    print(p300.letter_matrix[proper[i][1]-6][proper[i][0]])


zzz = p300.storage


print(proper)
print('')

predicted = np.zeros(np.shape(proper))

for l in range(l_letters):
    per = [
        zzz[l, i, ..., 0, :].mean() /
        zzz[l, i, ..., 1, :].mean()
        for i in range(12)
        ]
    min = [
        zzz[l, i, ..., 0, :].mean()-zzz[l, i, ..., 1, :].mean()
        for i in range(12)
        ]
    mean_0 = [zzz[l, i, ..., 0, :].mean() for i in range(12)]
    print('per: [%s, %s]' % (np.argmax(per[:6]), np.argmax(per[6:])+6))
    print('min: [%s, %s]' % (np.argmax(min[:6]), np.argmax(min[6:])+6))
    print('mean_0:[%s, %s]' % (np.argmax(mean_0[:6]), np.argmax(mean_0[6:])+6))
    print('')

    clf = min

    row_pred = np.argmax(clf[6:])+6
    col_pred = np.argmax(clf[:6])

    predicted[l][0] = col_pred
    predicted[l][1] = row_pred

accuracy_line = (proper == predicted).sum()/float((proper == predicted).size)
accuracy_letter = np.sum(
    [np.logical_and(i[0], i[1]) for i in (predicted == proper)]
    )/float((proper == predicted).shape[0])
print('----')
print('Line accuracy:   %0.2f' % accuracy_line)
print('Letter accuracy: %0.2f' % accuracy_letter)

# import ipdb
# ipdb.set_trace()

################################
#          PLOT P300           #
################################
cnt = 0
for i in range(l_letters):
    for j in range(12):
        plt.subplot(12, l_letters, j*l_letters+1+i)
        plt.plot(
            np.arange(
                store_range[0][0], store_range[1][1], 1000/float(sampling_rate)
                ),
            np.append(
                zzz[i, j, ..., 0, :].mean(axis=0),
                zzz[i, j, ..., 1, :].mean(axis=0)
                )
            )
        plt.axvline(x=300, c='r')
plt.show()
