#!/bin/bash

############################################
#
# design_sed.sh
#
# The script for creating designs by
# substituting the paths from core design.
#
############################################

###############################
# lists created for: 
#  * all the subjects
#  * all masks
###############################

img_dirs=$(ls -d -1 */ )

echo $img_dirs

sed 's/rest_1/rest_2/g' design.fsf > ../../../../designs/design_9603424_rest_2.fsf
