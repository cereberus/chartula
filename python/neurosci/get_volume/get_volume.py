#!/usr/bin/python

import sys
import numpy as np
import nibabel as nib

path_basic = sys.argv[1]
number_of_runs = int(sys.argv[2])
file_name = sys.argv[3]

runs_together = []
output_array = np.zeros((40,64,64), dtype=np.float32)

for i in range(number_of_runs):
    img = nib.load(path_basic + '{0:03}'.format(i+1)+ '/' + file_name)
    data = img.get_data()
    runs_together.append(data)
    affine = img.get_affine()

runs_together = np.array(runs_together)

def count_voxels(fmri_data):
    voxel_activated = 0
    voxel_tmp = 0
    for i in range(len(fmri_data[0])):
        for j in range(len(fmri_data[0][i])):
            for k in range(len(fmri_data[0][i][j])):
                for l in range(len(runs_together)):
                    if fmri_data[l][i][j][k] != 0:
                        voxel_tmp += 1
                if voxel_tmp == len(runs_together):
                    voxel_activated += 1
                    output_array[i][j][k] = 5
                voxel_tmp = 0
    print(voxel_activated)

count_voxels(runs_together)
print(affine)

output_image = nib.Nifti1Image(output_array, affine)
nib.save(output_image, 'voxels_coactivation.nii.gz')


# count_voxels for single image
def count_voxels_py_like(fmri_data):
    counter = 0
    count_non_zeros = 0
    for i in fmri_data:
        for j in i:
            for z in j:
                counter += 1
                if z != 0:
                    count_non_zeros += 1
    print counter
    print count_non_zeros
