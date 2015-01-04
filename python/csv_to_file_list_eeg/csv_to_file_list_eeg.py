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

paths=['blink/','norma/']
blink = [ f for f in listdir(paths[0]) if isfile(join(paths[0],f)) ]
norma = [ f for f in listdir(paths[1]) if isfile(join(paths[1],f)) ]

both_list=[]
both_list.append(blink)
both_list.append(norma)
            

def csv_read_cell():
    with open(paths[0]+blink[0], 'r') as f:
        rows = list(csv.reader(f))
        samples_num=len(rows)
    if os.path.isfile('eeg_magda.data'):
        os.remove('eeg_magda.data')
    f = open('eeg_magda.data','a')
    f.write(str(len(both_list[0])+len(both_list[1]))+' '+str(samples_num)+' '+str(1)+'\n')
    f.close()
    for i in range(len(both_list)):
        for j in both_list[i]:
            with open(paths[i]+j, 'r') as f:
                rows = list(csv.reader(f))
                for k in range(len(rows)):
                    f = open('eeg_magda.data','a')
                    #print(str(rows[k][0]))
                    f.write(rows[k][0]+' ') # python will convert \n to os.linesep
                    f.close()
                f = open('eeg_magda.data','a')
                f.write('\n'+str(i)+'\n') # python will convert \n to os.linesep
                f.close()
    return

print(csv_read_cell())
