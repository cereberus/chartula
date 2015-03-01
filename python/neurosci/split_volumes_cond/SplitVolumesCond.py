#!/usr/bin/env python

############################################
#
# name: split_volume_cond.py
#
########
# 
# purpose: splitting 4D fmri nifti data
# into separate files
#
########
# 
# usage: python split_volume_cond.py
# path_to_model_onsets
#
############################################

import os
import os.path
import csv
import numpy as np

# bold_run_0xx_cond00y
# bold_run_0xx_cond00y_subtr

bold_cond_list = []

main_dir_def = '/z/'
sub_dirs = sorted([os.path.join(o) \
        for o in os.listdir(main_dir_def) \
        if os.path.isdir(os.path.join(main_dir_def,o)) and o[0:3]=='sub'])

# create list containing locations of the nifti files with bolds
bold_dirs = []
for root, dirs, files in os.walk('/z/sub002/BOLD/', topdown=False):
    for file_name in files:
        if 'bold.nii.gz' in file_name and len(root) == 29:
            bold_dirs.append(os.path.join(root, file_name))
            bold_dirs = sorted(bold_dirs)

# default directory storing model info
def_dir = '/z/sub002/model/model001/onsets'

# the possibility to specify this as argument during running script
models_dir = def_dir
model_run_dirs = sorted([os.path.join(models_dir,o) \
        for o in os.listdir(models_dir) \
        if os.path.isdir(os.path.join(models_dir,o))])

# create list containing locations of the condition files
model_run_files = []
for root, dirs, files in os.walk(def_dir, topdown=False):
    for file_name in files:
        if 'cond' in file_name and len(root) + len(file_name) == 57:
            model_run_files.append(os.path.join(root, file_name))
            model_run_files = sorted(model_run_files)

for i in model_run_files:
    print(i)

def get_file_spec(file_as_element):
    # checks if three letter string is a substring of the other string
    # then sets the run_num to the rumber of the run
    # the searched substring is 'run'
    searched = 'run'
    for i in range(len(file_as_element)):
            if file_as_element[i] == searched[0]:
                if i+1 < len(file_as_element):
                    if file_as_element[i+1] == searched[1]:
                        if i+2 < len(file_as_element):
                            if file_as_element[i+2] == searched[2]:
                                run_num = int(file_as_element[i+3] + \
                                        file_as_element[i+4] + \
                                        file_as_element[i+5])
                                cond_num = int(file_as_element[i+11] + \
                                        file_as_element[i+12] + \
                                        file_as_element[i+13])
    return run_num, cond_num
                                

def get_cond_info(cond_file):
    cond_list = []
    with open(cond_file, 'rb') as csvfile:
        spamreader = csv.reader(csvfile, delimiter='\t', quotechar='|')
        for row in spamreader:
            cond_list.append(row)
    cond_sec_begin = int(float(cond_list[0][0]))
    # add 2 seconds to the last info to get the absolute end of the stimuli
    cond_sec_end = int(float(cond_list[-1][0]) + float(2))

    return [cond_sec_begin, cond_sec_end]


num_of_runs = 12
num_of_conditions = 8

# The array is better because it is easier to put the value
# in the specific cell. List is optional and commented below:
# bold_cond_list = [[[0]*2] * num_of_conditions] * num_of_runs
bold_cond_list = np.zeros((num_of_runs, num_of_conditions, 2))

while (len(model_run_files) > 0):
    print(len(model_run_files))
    print(model_run_files[0])

    # take first element of the list of condition files
    considered = model_run_files.pop(0)

    # get specification, an info about runs and conds numbers
    run_num, cond_num = get_file_spec(considered)

    # read the file for cond info for the particular run
    # TODO cond is a 2-element list - range: from x to y second
    cond_info = get_cond_info(considered)

    # append the info about conditon to the main list with the
    # info about the bolds
    # -1 beacause in the files numbering starts with 1, not 0
    bold_cond_list[run_num-1][cond_num-1] = cond_info
