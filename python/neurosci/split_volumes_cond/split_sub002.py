#!/usr/bin/env python

import svc
import numpy as np

num_of_runs = 12
num_of_conditions = 8

# The array is better because it is easier to put the value
# in the specific cell. List is optional and commented below:
# bold_cond_list = [[[0]*2] * num_of_conditions] * num_of_runs
bold_cond_list = np.zeros((num_of_runs, num_of_conditions, 2))

model_run_files = svc.get_model_run_files()

vols_per_cond = np.zeros((num_of_runs, num_of_conditions, 2))

while (len(model_run_files) > 0):
    # take first element of the list of condition files
    considered = model_run_files.pop(0)

    # get specification, an info about runs and conds numbers
    run_num, cond_num = svc.get_file_spec(considered)

    # read the file for cond info for the particular run
    # TODO cond is a 2-element list - range: from x to y second
    cond_info = svc.get_cond_info(considered)

    # append the info about conditon to the main list with the
    # info about the bolds
    # -1 beacause in the files numbering starts with 1, not 0
    bold_cond_list[run_num-1][cond_num-1] = cond_info

vols_per_cond = svc.cond_vols_info(bold_cond_list, vols_per_cond, 1)
# cond_files_list = svc.slice_nifti_conds(vols_per_cond)

rests_info = svc.rest_universal(8)
# svc.slice_nifti_rests(rests_info)

merge_info_list = svc.create_merge_list(vols_per_cond, rests_info)

svc.merge_files(merge_info_list)
