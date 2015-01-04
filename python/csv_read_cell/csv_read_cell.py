#!/usr/bin/env python
"""Print a field specified by row, column numbers from given csv file.

USAGE:
    %prog csv_filename row_number column_number
"""
import csv
import sys
#import datetime
#import os
from os import listdir
from os.path import isfile, join
import argparse

## csv_read_cell Help ##
parser = argparse.ArgumentParser(
    description='''This script allows to get specified cell \
    value form a csv file ''',
    epilog="""Good luck with this one.""")
parser.add_argument('--foo', type=int, default=42, help='FOO!')
parser.add_argument('bar', nargs='*', default=[1, 2, 3], help='BAR!')
args = parser.parse_args()
#####

## Whether it is experimental or control gropup
## Specified during running the script
experimental = int(sys.argv[1], 10)

#row_number, column_number = [int(arg, 10) for arg in sys.argv[1:]]

###Last to arguments given
row_number, column_number = [int(arg, 10) for arg in sys.argv[:1:-1]]

## Cells list to store all the read cells
cells = []


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
    def csv_read_cell():
        with open(path_get_csv_input + csv_input_list[i], 'r') as f:
            rows = list(csv.reader(f))
            cells.append(rows[row_number][column_number] +
            ' ' + csv_input_list[i])
            return(cells)

    csv_read_cell()

print[cells]




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