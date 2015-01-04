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
#import datetime
#import os
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

## Column list to store all the read columns
columns = []

## Counting 1s in columns and other choices
proper_choosen = 0
other_choosen = 0

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

for i in columns:
    if i == '1':
        proper_choosen += 1
    else:
        other_choosen += 1

print(columns)
print(str(len(columns)) + ' alles zusammen')
print(str(proper_choosen) + ' how many 1s')
print(str(other_choosen) + ' how many other')


### mine working
##!/usr/bin/env python
#"""Print a field specified by row, column numbers from given csv file.

#USAGE:
    #%prog csv_filename row_number column_number
#"""
#import csv
#import sys

#row_number, column_number = [int(arg, 10) for arg in sys.argv[1:]]

##Last to arguments given
##column_number, row_number = [int(arg, 10) for arg in sys.argv[::-1]
                             ##if arg > len(sys.argv) - 3]

#cells = []


#def csv_read_cell(x, y):
    #with open('201405202327.csv', 'r') as f:
        #rows = list(csv.reader(f))
        #cells.apend(rows[row_number][column_number])
        #return(cells)

#print(cells)




## original from net
#import csv
#import sys

#filename = sys.argv[1]
#row_number, column_number = [int(arg, 10) - 1 for arg in sys.argv[2:]]

#with open(filename, 'rb') as f:
    #rows = list(csv.reader(f))
    #print rows[row_number][column_number]