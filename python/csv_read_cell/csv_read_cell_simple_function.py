#!/usr/bin/env python
"""Print a field specified by row, column numbers from given csv file.

USAGE:
    %prog csv_filename row_number column_number
"""
import csv
#import sys

cell = ''


def csv_read_cell(x, y):
    with open('201405202327.csv', 'r') as f:
        rows = list(csv.reader(f))
        cell = rows[x][y]
        return(cell)

print(csv_read_cell(1, 1))




## original from net
#import csv
#import sys

#filename = sys.argv[1]
#row_number, column_number = [int(arg, 10) - 1 for arg in sys.argv[2:]]

#with open(filename, 'rb') as f:
    #rows = list(csv.reader(f))
    #print rows[row_number][column_number]