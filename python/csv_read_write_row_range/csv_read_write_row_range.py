#!/usr/bin/env python
"""Takes rows in range and writes it to the new csv file.

Script has to check if file exists. Else no such file error

USAGE:
    %prog csv_filename row_number_begin row_number_end
"""
import csv
import os

def csv_read_cell(x, y):
    if os.path.isfile('eeg_magda_001.csv'):
        os.remove('eeg_magda_001.csv')
    with open('eeg_raw_magda.csv', 'r') as f:
        rows = list(csv.reader(f))
        for i in range(len(rows)):
            if i>x and i<y:
                print(rows[i])
                with open ('eeg_magda_001.csv','a') as f:
                    zapis=csv.writer(f)
                    zapis.writerow(rows[i])
    return

print(csv_read_cell(1570, 1580))

