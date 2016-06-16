'''
filename:
p300.py

type:
module

PySEEG package for detecting p300.
'''

import numpy as np


class P300Manager(object):
    def __init__(
            self, sampling_rate, store_range,
            l_letters,
            n_lines,
            line_i_times,
            line_interval, line_lag,
            detection_method='mean_0'
            ):

        self.sampling_rate = sampling_rate
        self.store_range = store_range
        self.l_letters = l_letters
        self.n_lines = n_lines
        self.line_i_times = line_i_times
        self.detection_method = detection_method

        self.lines = np.zeros(self.n_lines, dtype='int')

        self.samples_per_second = 1000/float(self.sampling_rate)

        self.samples_range = np.divide(
            self.store_range, self.samples_per_second
            )

        # number of sample within the trial
        self.current_sample_number = 0

        self.prev_letter = 0
        self.prev_line = None
        self.clusters_in_memory = 0

        # how many samples in range
        self.k_samples = int(
            round(np.diff(store_range[0])/self.samples_per_second)
            )

        self.storage = np.zeros(
            (l_letters, n_lines, line_i_times, 2, self.k_samples)
            )
        self.stored_sample_range = np.zeros(self.storage.shape[:-1]+(3,))

        self.highlight_counter = 0

        self.letter_matrix = [
            ['A', 'B', 'C', 'D', 'E', 'F'],
            ['G', 'H', 'I', 'J', 'K', 'L'],
            ['M', 'N', 'O', 'P', 'Q', 'R'],
            ['S', 'T', 'U', 'V', 'W', 'X'],
            ['Y', 'Z', '1', '2', '3', '4'],
            ['5', '6', '7', '8', '9', '0']
            ]

        self.report = ''

    def remember(self, sample, letter, line):

        if self.prev_letter != letter:
            self.prev_letter = letter
            self.prev_line = 0
            self.lines[:] = 0
            self.highlight_counter = 0
            self.report += '\n\n'
            print('')
            print('-----')
            print('')

        new_line = False

        if (self.prev_line != line) and line != -1:
            new_line = True

        clusters_in_memory = \
            (
                self.stored_sample_range[..., 1, -1] ==
                self.k_samples-1
            ).sum()

        if clusters_in_memory > self.clusters_in_memory:
            self.detect_line()
            self.clusters_in_memory = clusters_in_memory

        if new_line:
            self.stored_sample_range[letter][line][self.lines[line]][..., :2] \
                = np.add(self.samples_range, self.current_sample_number)

            self.lines[line] += 1

        in_range = np.logical_and(
            self.current_sample_number > self.stored_sample_range[..., 0],
            self.current_sample_number < self.stored_sample_range[..., 1]
            )
        more_samples_required = \
            self.stored_sample_range[..., 2] < self.k_samples

        store_samples = np.logical_and(
            in_range,
            more_samples_required
            )

        sample_number_mask = \
            self.stored_sample_range[store_samples, 2].astype('int')

        if store_samples.sum() > 0:
            self.storage[store_samples, sample_number_mask] = sample
            self.stored_sample_range[store_samples, 2] += 1

        self.prev_line = line
        self.current_sample_number += 1

    def detect_letter(self):

        mean_p300 = [
            self.storage[self.prev_letter, i, ..., 0, :].mean()
            for i in range(self.n_lines)
            ]

        col = np.argmax(mean_p300[6:])
        row = np.argmax(mean_p300[:6])

        print('')
        print('^')
        print('|')
        print('|')
        print('%s' % self.letter_matrix[col][row])
        print('')

        return (row, col)

    def detect_line(self):

        if self.detection_method == 'mean_0':
            mean_p300 = [
                self.storage[
                    self.prev_letter,
                    i,
                    self.stored_sample_range[0, 0, ..., 0, -1]
                    == self.k_samples-1, 0, :
                    ].mean()
                for i in range(self.n_lines)
                ]
        elif self.detection_method == 'min':

            first_full = \
                self.stored_sample_range[0, 0, ..., 0, -1] == self.k_samples-1
            second_full = \
                self.stored_sample_range[0, 0, ..., 1, -1] == self.k_samples-1

            both_full = np.logical_and(first_full, second_full)

            mean_p300 = [
                self.storage[self.prev_letter, i, both_full, 0, :].mean() -
                self.storage[self.prev_letter, i, both_full, 1, :].mean()
                for i in range(self.n_lines)]

        col = np.argmax(mean_p300[6:])
        row = np.argmax(mean_p300[:6])

        self.highlight_counter += 1
        print(
            '%s:, %s' %
            (self.highlight_counter, self.letter_matrix[col][row])
            )

        self.report += ('%s ' % self.letter_matrix[col][row])
