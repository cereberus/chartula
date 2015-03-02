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

volumes_per_cond = []

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


for i in range(len(bold_cond_list)):
    for j in range(len(bold_cond_list[0])):
        print('run: ' + str(i+1)  + '; cond: ' + str(j+1))
        print bold_cond_list[0][j]
        print(svc.vols_range_per_cond(bold_cond_list[0][j][0],\
                bold_cond_list[0][j][1]))
        print('')

a, b = svc.volumes_begin_sec()
print(b)
