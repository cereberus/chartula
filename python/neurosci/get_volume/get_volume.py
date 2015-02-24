#!/usr/bin/python

import sys
import numpy as np
import nibabel as nib

nifti_location = sys.argv[1]
output_array = np.zeros((40,64,64,), dtype=np.float32)
volume_number = 37

img = nib.load(nifti_location)
data = img.get_data()
affine = img.get_affine()

volumes = []
x = 0
while x<300:
    volumes.append(x)
    x += 2.5

edges = [0, 12, 36, 48, 72, 84, 108, 120, 144, 156, 180, 192, 216, 228, 252, 264, 288]

# here the info which volume which conditions is has to be put
cond = [[cond001, [44,144]], cond002, cond003, cond004, \
        cond005, cond006, cond007, cond008]

# remove volumes where two states (object and rest) are present
for i in volumes:
    for j in edges:
        if j > i and j < i+2.5:
            volumes.remove(i)

def get_volumes_range(fmri_data, vol_beg, vol_end):
    for i in range(len(fmri_data)):
        for j in range(len(fmri_data[i])):
            for k in range(len(fmri_data[i][j])):
                for l in range(len(fmri_data[i][j][k])):
                    if l == vol_num:
                        output_array[i][j][k] = fmri_data[i][j][k][l]
    output_image = nib.Nifti1Image(output_array, affine)
    nib.save(output_image, 'volume_'+'{0:03}'.format(vol_num)+'.nii.gz')

def get_single_volume(fmri_data, vol_num):
    for i in range(len(fmri_data)):
        for j in range(len(fmri_data[i])):
            for k in range(len(fmri_data[i][j])):
                for l in range(len(fmri_data[i][j][k])):
                    if l == vol_num:
                        output_array[i][j][k] = fmri_data[i][j][k][l]
    output_image = nib.Nifti1Image(output_array, affine)
    nib.save(output_image, 'volume_'+'{0:03}'.format(vol_num)+'.nii.gz')
