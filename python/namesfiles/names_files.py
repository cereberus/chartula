# -*- coding: utf-8 -*-
"""
Created on Sun Apr 20 11:52:57 2014

@author: root
"""

import os
from os import listdir
from os.path import isfile, join
import shutil

mypath = '/home/jesmasta/downloads/bg/'
file_output_path = '/home/jesmasta/downloads/psychopy_sample/settings/output/'

onlyfiles = [f for f in listdir(mypath) if isfile(join(mypath,f))]
names = []

for i in range(len(onlyfiles)-1):
    names.append(os.path.splitext(onlyfiles[i])[0])
    
for i in range(len(names)-1):
    shutil.copy2('/home/jesmasta/Desktop/jezi_srub_1366.csv', file_output_path+'csvs/'+names[i]+'.csv')

