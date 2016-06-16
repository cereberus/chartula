import numpy as np


def _create_letter_target(row_col, sampling_rate, threshold):

    letter_target = np.zeros(row_col.shape)

    threshold = threshold/(1000/sampling_rate)

    letter_cnt = 0
    cnt = 0
    expecting_new_letter = False

    for i in range(len(row_col)):
        if row_col[i] == -1 and expecting_new_letter:
            expecting_new_letter = True
            cnt += 1
        if cnt > threshold:
            letter_cnt += 1
            cnt = 0
            expecting_new_letter = False
        elif row_col[i] != -1:
            expecting_new_letter = True
            cnt = 0
        letter_target[i] = letter_cnt

    return letter_target.astype('int')


############################################
#                                          #
#      OPENBCI-LIKE CLASS FOR SAMPLES      #
#                                          #
############################################
class OpenBCISample(object):
    '''
        Class for samples handling. Normally in openbci.py class.
        Here it is used to make code similar to those from openbci.
    '''
    def __init__(self, packet_id, channel_data, aux_data):
        self.id = packet_id
        self.channel_data = channel_data
        self.aux_data = aux_data
