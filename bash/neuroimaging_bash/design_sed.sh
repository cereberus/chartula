#!/bin/bash

############################################
#
# design_sed.sh
#
# The script for creating designs by
# substituting the paths from core design.
#
############################################

img_dirs=$(ls -d -1 */ )

main_design='design.fsf'
# ROOT='/home/jesmasta/neuro/'

sub_base='9603424'
num='1'


echo $ROOT$sub'session_1/_rest_'$num'/rest_linearMNI3mm.nii.gz'

echo $img_dirs

for sub in $img_dirs
do
    for num in 1 2 
    do
        sed "s/$sub_base rest_1/rest_$num/g" design.fsf > designs/design_${sub}_rest_${num}.fsf
    done
done

    sed 's/rest_1/rest_2/g' design.fsf > designs/design_${sub}_rest_${num}.fsf

sed 's/rest_1/rest_2/g' design.fsf > ../../../../designs/design_9603424_rest_2.fsf

