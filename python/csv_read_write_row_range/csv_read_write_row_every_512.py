#!/usr/bin/env python
"""Takes rows in constant range (e.g. every 512)
Then writes it to the new csv file.
You can do it for the following packages.

Script also checks if files already exist. If so it deletes them

USAGE:
    %prog row_number_begin constant_range numbers_of_packages
"""
import csv
import os

def csv_read_cell(x, y, z):
    with open('eeg_raw_magda.csv', 'r') as f:
        rows = list(csv.reader(f))
        for j in range(z):
            if os.path.isfile('eeg_magda_'+'{0:03}'.format(j)+'.csv'):
                os.remove('eeg_magda_'+'{0:03}'.format(j)+'.csv')
            for i in range(len(rows)):
                if i>x and i<=x+y:
                    print(rows[i])
                    with open ('eeg_magda_blink_'+'{0:03}'.format(j)+'.csv','a') as f:
                        zapis=csv.writer(f)
                        zapis.writerow(rows[i])
            x+=y
    return

print(csv_read_cell(2890, 512,2))

