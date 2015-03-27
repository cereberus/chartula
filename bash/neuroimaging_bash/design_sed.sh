#!/bin/bash

############################################
#
# design_sed.sh
#
# The script for creating designs by
# substituting the paths from core design.
#
############################################


img_dirs=$(ls -d -1 cocaine/*/)
img_dirs+=$(ls -d -1 controls/*/)

echo $img_dirs

main_design='design.fsf'

sub_base='1065809'
# sub='9858555'
# num='2'

mkdir designs

echo $ROOT$sub'session_1/_rest_'$num'/rest_linearMNI3mm.nii.gz'
echo $img_dirs

for sub in $img_dirs
do
    for num in 1 2 
    do
        sed "s/${sub_base}\/session_1\/rest_1/${sub}\/session_1\/rest_$num/g" design.fsf > designs/design_${sub}_rest_${num}.fsf
    done
done
