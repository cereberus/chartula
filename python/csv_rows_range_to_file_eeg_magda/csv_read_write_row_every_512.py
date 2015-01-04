#!/usr/bin/env python
"""Takes rows in constant range (e.g. every 512)
Then writes it to the new csv file.
You can do it for the following packages.

Script also checks if files already exist. If so it deletes them

number_of_packages - how many y-s does it takes

USAGE:
    %prog row_number_begin constant_range number_of_packages blink_or_not_blink
"""
import csv
import os
from os import listdir
from os.path import isfile, join
import shutil

shutil.rmtree('blink', ignore_errors=True)
os.makedirs('blink')

shutil.rmtree('norma', ignore_errors=True)
os.makedirs('norma')

paths=['blink/','norma/']

def csv_rows_split(x, y, z, b):
    with open('eeg_learn.csv', 'r') as f:
        rows = list(csv.reader(f))
        for j in range(z):
            if os.path.isfile('eeg_learn_'+'{0:03}'.format(j)+'.csv'):
                os.remove('eeg_learn_'+'{0:03}'.format(j)+'.csv')
            for i in range(len(rows)):
                if i>x and i<=x+y:
                    #print(rows[i])
                    if(b==1):
                        with open (paths[0]+'eeg_learn_blink_'+'{0:03}'.format(j)+'.csv','a') as f:
                            zapis=csv.writer(f)
                            zapis.writerow(rows[i])
                    if(b==0):
                        with open (paths[1]+'eeg_learn_norma_'+'{0:03}'.format(j)+'.csv','a') as f:
                            zapis=csv.writer(f)
                            zapis.writerow(rows[i])
            x+=y
    return

print(csv_rows_split(1500,256,21,0))
print(csv_rows_split(8000,256,21,1))

blink = [ f for f in listdir(paths[0]) if isfile(join(paths[0],f)) ]
norma = [ f for f in listdir(paths[1]) if isfile(join(paths[1],f)) ]

both_list=[]
both_list.append(blink)
both_list.append(norma)



def csv_write_splitted():
    with open(paths[0]+blink[0], 'r') as f:
        rows = list(csv.reader(f))
        samples_num=len(rows)
        print(samples_num)
    if os.path.isfile('eeg_learn.data'):
        os.remove('eeg_learn.data')
    f = open('eeg_learn.data','a')
    f.write(str(len(both_list[0])+len(both_list[1]))+' '+str(samples_num)+' '+str(1)+'\n')
    f.close()
    for i in range(len(both_list)):
        for j in both_list[i]:
            with open(paths[i]+j, 'r') as f:
                rows = list(csv.reader(f))
                for k in range(len(rows)):
                    f = open('eeg_learn.data','a')
                    #print(str(rows[k][0]))
                    f.write(rows[k][0]+' ') # python will convert \n to os.linesep
                    f.close()
                f = open('eeg_learn.data','a')
                f.write('\n'+str(i)+'.0'+'\n') # python will convert \n to os.linesep
                f.close()
    return



print(csv_write_splitted())
