#!/usr/bin/env python
"""Print a cow specified by row_begin, row_end, column numbers from given
csv file.

USAGE:
    %run csv_read_column_count.py group row_begin row_end column

    example:
    %run csv_read_column_count.py 0 8 22 3
"""

import csv
import sys
import datetime
import os
from os import listdir
from os.path import isfile, join

############################################
############### sample usage ###############
# run csv_read_column_count.py 0 8 22 3 ####
############################################


## Whether it is experimental or control gropup
## Specified during running the script
experimental = int(sys.argv[1], 10)

#row_number, column_number = [int(arg, 10) for arg in sys.argv[1:]]

###Last to arguments given, !!!backward [:1:-1]
column_number, row_end, row_begin, = [int(arg, 10) for arg in sys.argv[:1:-1]]

## Lists to store data
columns = []
participants = []
values = []


## Counting 1s in columns
proper_choosen = 0

#row number = sys.argv[1]
#column number = sys.argv[2]


if experimental == 1:
    path_get_csv_input = \
    '/home/jesmasta/downloads/psychopy_sample/csv_output/'
else:
    path_get_csv_input = \
    '/home/jesmasta/downloads/psychopy_sample/csv_output_control/'


csv_input_list = [f for f in listdir(path_get_csv_input)
                  if isfile(join(path_get_csv_input, f))]

for i in range(len(csv_input_list)):
    def csv_read_columns():
        with open(path_get_csv_input + csv_input_list[i], 'r') as f:
            rows = list(csv.reader(f))
            for j in range(len(rows)):
                if j >= row_begin - 1 and j <= row_end:
                    columns.append(rows[j][column_number])
                    #columns.append(rows[j][column_number] +
                    #' ' + csv_input_list[i])
            #columns.append('break')
            return(columns)

    csv_read_columns()

## values count
values_counting = 0
for i in columns:
    if i == '1':
        proper_choosen += 1
    values_counting += 1
    if values_counting % 15 == 0:
        values.append(proper_choosen)
        proper_choosen = 0

container = str(experimental) + '_' + \
datetime.datetime.now().strftime("%Y%m%d%H%M") + '_container.csv'

print(len(values))

with open(container, 'wb') as f:
    zapis = csv.writer(f)
    for i in range(len(csv_input_list)):
        #zapis.writerow([os.path.splitext(csv_input_list[i])[0], experimental])
        zapis.writerow([os.path.splitext(csv_input_list[i])[0], experimental,
        values[i]])

print(columns)
print(str(len(columns)) + ' alles zusammen')
print(values)
