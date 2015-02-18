#!/usr/bin/python

############################################
#
# NAME:
#     nifti_to_np_array.py 
#
# DESCRIPTION:
#
# Script that takes an NifTI 
# file format and converts it
# to 4D np.array
#
# USAGE:
#     python nifti_to_np_array.py *.nii.gz
#
############################################

import sys
import numpy as np



img = nib.load(sys.argv[1])
data = img.get_data()
