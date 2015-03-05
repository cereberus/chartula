#!/usr/bin/env python

"""
# # # # #
DESCRIPTION:
#

Module for slicing and merging the fmri files (nifti format).

This program uses some fsl utilities thus the fsl has to be installed
in order to use all its functionalilities.
# # #

USAGE:
#
get_bold_files(*args)

Returns the list of paths (strings) to the particular run's main files
"bold.nii.gz". The default main path is '/z/sub002/BOLD/'. 
It can be changed by adding it as the first argument of the function.

example:
get_bold_files('sub001/BOLD')
# # #


# # # # #
"""

import os
import os.path
import csv
import numpy as np
import subprocess as sp  

bold_cond_list = []
main_dir_def = '/z/'
sub_dirs = sorted([os.path.join(o) \
        for o in os.listdir(main_dir_def) \
        if os.path.isdir(os.path.join(main_dir_def,o)) \
        and o[0:3]=='sub'])

# create list containing locations of the nifti files with bolds
def get_bold_files(*args):
    if len(args) == 0: 
        bold_main_dir = '/z/sub002/BOLD/'
    else:
        bold_main_dir = args[0]
    bold_files = []
    for root, dirs, files in os.walk(bold_main_dir, topdown=False):
        for file_name in files:
            if 'bold.nii.gz' in file_name and len(root) == 29:
                bold_files.append(os.path.join(root, file_name))
                bold_files = sorted(bold_files)
    return bold_files

# default directory storing model info
def_dir = '/z/sub002/model/model001/onsets'

# the possibility to specify this as argument during running script
models_dir = def_dir
model_run_dirs = sorted([os.path.join(models_dir,o) \
        for o in os.listdir(models_dir) \
        if os.path.isdir(os.path.join(models_dir,o))])

# create list containing locations of the condition files
def get_model_run_files(*args):
    def_dir = '/z/sub002/model/model001/onsets'
    if len(args) == 0:
        model_dir = def_dir
    elif len(args) == 1:
        model_dir = args[0]
    else:
        print('This function takes at most one argument')
    if len(args) <= 1:
        model_run_files = []
        for root, dirs, files in os.walk(model_dir, topdown=False):
            for file_name in files:
                if 'cond' in file_name and len(root)+len(file_name) == 57:
                    model_run_files.append(os.path.join(root, file_name))
                    model_run_files = sorted(model_run_files)
    return model_run_files

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
                                cond_num = int(\
                                        file_as_element[i+11] + \
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

def get_sliced_files_list(path_to_files):
    sliced_files = []
    for root, dirs, files in os.walk(path_to_files, topdown=False):
        for file_name in files:
            sliced_files.append(file_name)
#             if 'cond' in file_name and len(root) == 29:
#             if sliced_type in file_name:
#                 print(len(root))
#                 sliced_files.append(os.path.join(root, file_name))
#                 sliced_files = sorted(sliced_files)
    return sorted(sliced_files)

def volumes_list_create():
    volumes = []
    vol_overlap = []
    x = 0
    edges = [0, 12, 36, 48, 72, 84, 108, 120, 144, 156, \
            180, 192, 216, 228, 252, 264, 288]
    rests = [[0, 12],  [36, 48], [72, 84], [108, 120], [144, 156],\
            [180, 192],[216, 228],[252, 264], [288, 300]]
    while x<300:
        volumes.append([x])
        x += 2.5
    for i in range(len(volumes)):
        for j in range(len(edges)):
            if edges[j] > volumes[i][0] and edges[j] < volumes[i][0]+2.5:
                volumes[i].append(0)
                vol_overlap.append(i)
            if j == len(edges)-1 and len(volumes[i]) == 1:
                volumes[i].append(1)
        for rest in range(len(rests)):
            if volumes[i][0] >= rests[rest][0] \
                    and volumes[i][0] < rests[rest][1]:
                volumes[i].append(0)

    return volumes, vol_overlap

def vols_range_per_cond(sec_beg, sec_end):
    vols, vol_overlap = volumes_list_create()
    vol_begin = 0
    number_of_vols = 0
    for i in range(len(vols)):
        if vols[i][0] >= sec_beg and vols[i][0] < sec_end \
                and vols[i][1] == 1:
            if number_of_vols == 0:
                vol_begin = i
#             print(str(i) + " " + str(vols[i][0]))
            number_of_vols += 1
    return [vol_begin, number_of_vols]


# Fill the list with info about the particular conditions
# in the particular runs. Note that if the number of volumes
# is 9 then the fist volume is removed in order to equal
# the number of volumes per the condition.
# the last argument is the decision wether or not to remove 1st
# volume in the 9-volumes cases. The default is to cut
def cond_vols_info(bold_cond_list, vols_per_cond, *args): 
    if len(args) == 0:
        decision = 1
    else:
        decision = args[0]
    for i in range(len(bold_cond_list)):
        for j in range(len(bold_cond_list[0])):
            vol_cond = vols_range_per_cond(\
                    bold_cond_list[i][j][0],\
                    bold_cond_list[i][j][1])
            print(vol_cond)
            if decision == 0:
                vols_per_cond[i][j] = vol_cond
            else:
                # check what is the number of the volumes and removes 
                # the first of them if necessery
                if vol_cond[1] == 8:
                    vols_per_cond[i][j] = vol_cond
                else:
                    vols_per_cond[i][j] = [vol_cond[0]+1, vol_cond[1]-1]
    return vols_per_cond 

def rest_universal(num_of_conditions):
    vols, vol_overlap = volumes_list_create()
    number_of_vols = 0
    rest_num = 0
    rests_array = np.zeros((num_of_conditions + 1, 2))
    for i in range(len(vols)):
        if len(vols[i]) == 3:
            if vols[i][2] == 0:
                if number_of_vols == 0:
                    rests_array[rest_num][0] = i
                number_of_vols += 1
                if i == len(vols)-1:
                    rests_array[rest_num][1] = number_of_vols
                if i < len(vols)-1:
                    if len(vols[i+1]) == 2:
                        rests_array[rest_num][1] = number_of_vols
                        number_of_vols = 0
                        rest_num += 1
    return rests_array

def output_dir_create(output_dir_name):
    if not os.path.exists(output_dir_name):
        os.makedirs(output_dir_name)

def slice_nifti_conds(cond_info, *args):
    output_dir = 'slicing_output/conds'
    output_dir_create(output_dir)
    num_of_runs, num_of_conds, info_about_conds = cond_info.shape
    # A list instead of an array has to be created.
    # Creating an array of the strings is a bit sophisticated.
    cond_files_list = []
    for i in range(num_of_runs):
        cond_files_list.append([])
        for j in range(num_of_conds):
            cond_files_list[i].append([])
#             for k in (range(info_about_conds+1))):
#                 cond_files_list[i][j].append([])
    if len(args) == 0:
        bold_files = get_bold_files()
    else:
        bold_files = get_bold_files(args[0])
    for run in range(len(cond_info)):
        for cond in range(len(cond_info[run])):
            output_file = output_dir + '/sub002_run' + \
                    '{0:03}'.format(run+1) + '_' + \
                    'cond' + \
                    '{0:03}'.format(cond+1)
            cmd = 'fslroi ' + bold_files[run] + \
                    ' ' + output_file + ' ' + \
                     str(int(cond_info[run][cond][0])) + ' ' + \
                     str(int(cond_info[run][cond][1]))
            cond_files_list[run][cond] = output_file 
            process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
            output = process.communicate()[0]
            output
    return cond_files_list

'''
CRUCIAL:
    In this funcition the number of vols in all f the rest files
    is reduced to 4 (4 first volumes). Sometimes it is a possibility
    to use 4 last volumes (it it is to be the "pre" file.
    It is to be changed in the future.
'''
def slice_nifti_rests(rests_info, *args):
    output_dir = 'slicing_output/rests'
    output_dir_create(output_dir)
    if len(args) == 0:
        bold_files = get_bold_files()
    else:
        bold_files = get_bold_files(args[0])
    for run in range(len(bold_files)):
        for rest in range(len(rests_info)):
            cmd = 'fslroi ' + bold_files[run] + \
                    ' ' + output_dir + '/sub002_run' + \
                    '{0:03}'.format(run+1) + '_' + \
                    'rest' + \
                    '{0:03}'.format(rest+1) + ' ' + \
                     str(int(rests_info[rest][0])) + ' ' + \
                     '4'
                     # here the rest is set to only 4 volumes
                     # str(int(rests_info[rest][1]))
            process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
            output = process.communicate()[0]
            output

# There are three ways to merge the condition with the rest blocks
#  1. The condition and the precedind rets block
#  2. The condition and the following rets block
#  3. The condition and the precedind as well as the following rets block
# Thus there are three possible values of the pre_post variable: 1, 2 or 3.
# The default is 3.
#
# Take the file with the conditions from some output folder.
# Find it's location on the conditions array.
# Get the info about preciding as well as the following rest block (vols).
# Merge the condition with the block(s) in one of the ways: 1, 2 or 3.
# Save the output to the directory.
#
'''
Input:
    * cond_files
'''
def create_merge_list(conds_info, rests_info):
#     cond_files = get_sliced_files_list('slicing_output/conds')
    cond_files_pre_post = []
    for i in range(len(conds_info)):
        cond_files_pre_post.append([])
        for j in range(len(conds_info[0])):
            cond_files_pre_post[i].append([])
            for k in (range(len(conds_info[0][0])+1)):
                cond_files_pre_post[i][j].append([])
    # tmp filling cond_files. Sth is wrong with slicing conds function
    cond_files = []
    for i in range(len(conds_info)):
        cond_files.append([])
        for j in range(len(conds_info[0])):
            cond_files[i].append([])
    tmp_file_list = get_sliced_files_list('slicing_output/conds')
    print(tmp_file_list)
    j = 0
    k = 0
    for i in range(len(tmp_file_list)):
        print('')
        print(tmp_file_list[i])
        print('It goes to: run: ' + str(k) + '; cond: ' + str(j))
        cond_files[k][j] = tmp_file_list[i]
        j += 1
        if j == 8:
            j = 0
            k += 1
        if k == 13:
            k = 0
    # tmp filling rest_files. Sth is wrong with slicing conds function
    rest_files = []
    for i in range(len(conds_info)):
        rest_files.append([])
        for j in range(len(conds_info[0])+1):
            rest_files[i].append([])
    tmp_file_list = get_sliced_files_list('slicing_output/rests')
    print(rest_files)
    j = 0
    k = 0
    for i in range(len(tmp_file_list)):
        print('')
        print(tmp_file_list[i])
        print('It goes to: run: ' + str(k) + '; cond: ' + str(j))
        rest_files[k][j] = tmp_file_list[i]
        j += 1
        if j == 9:
            j = 0
            k += 1
        if k == 13:
            k = 0
    print(cond_files)
    print(rest_files)
    output_dir = 'slicing_output/sub002'
    output_dir_create(output_dir)
    for run in range(len(conds_info)):
        print('')
        print('run: ' + str(run+1))
        for cond in range(len(conds_info[0])):
            cond_files_pre_post[run][cond][1] = \
                    'slicing_output/conds/' + \
                    cond_files[run][cond]
            for rest in range(len(rests_info)):
                if rest < len(rests_info)-1:
                    if conds_info[run][cond][0] > rests_info[rest][0] and \
                        conds_info[run][cond][0] < rests_info[rest+1][0]:
                        cond_files_pre_post[run][cond][0] = \
                                'slicing_output/rests/' + \
                                rest_files[run][rest]
                        cond_files_pre_post[run][cond][2] = \
                                'slicing_output/rests/' + \
                                rest_files[run][rest+1]
    return cond_files_pre_post                                    

def merge_files(cond_pre_post, *args):
    output_dir = 'slicing_output/merged/'
    output_dir_create(output_dir)
    if len(args) == 0:
        pre_post = 3
    else:
        pre_post = args[0]
    for run in range(len(cond_pre_post)):
        for cond in range(len(cond_pre_post[0])):
            cmd = 'fslmerge -t' + \
                    ' ' + output_dir + \
                    'sub002_run' + '{0:03}'.format(run+1) + '_' + \
                    'cond' + '{0:03}'.format(cond+1)
            if pre_post == 1:
                cmd += '_pre'
                cmd += ' ' + cond_pre_post[run][cond][0]
                cmd += ' ' + cond_pre_post[run][cond][1]
            if pre_post == 2:
                cmd += '_post'
                cmd += ' ' + cond_pre_post[run][cond][1]
                cmd += ' ' + cond_pre_post[run][cond][2]
            if pre_post == 3:
                cmd += '_pre_post'
                cmd += ' ' + cond_pre_post[run][cond][0]
                cmd += ' ' + cond_pre_post[run][cond][1]
                cmd += ' ' + cond_pre_post[run][cond][2]
#             print(cmd)
            process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
            output = process.communicate()[0]
            output







