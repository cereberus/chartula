#!/usr/bin/env python
"""Takes rows in range and writes it to the new csv file.

Script has to check if file exists. Else no such file error

USAGE:
    %prog csv_filename row_number_begin row_number_end
"""
import csv
import os
from os import listdir
from os.path import isfile, join

paths=['norma/','blink/']
blink = [ f for f in listdir(paths[0]) if isfile(join(paths[0],f)) ]
norma = [ f for f in listdir(paths[1]) if isfile(join(paths[1],f)) ]

both_list=[]
both_list.append(blink)
both_list.append(norma)

def csv_read_cell():
    for i in range(len(both_list)):
        for j in both_list[i]:
            with open(paths[i]+j, 'r') as f:
                rows = list(csv.reader(f))
                for k in range(len(rows)):
                    print('input['+str(k+1)+'] = '+str(rows[k][0])+';')
    return

print(csv_read_cell())
