#!/usr/bin/python
import numpy as np
import nibabel as nib

img = nib.load('bold.nii.gz')
data = img.get_data()
