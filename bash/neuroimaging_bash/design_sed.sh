#!/bin/bash

############################################
#
# design_sed.sh
#
# The script for creating designs by
# substituting the paths from core design.
#
############################################

cd cocaine
img_dirs=$(ls -d */ | cut -f1 -d'/')
cd ..

img_dirs+=' '

cd controls
img_dirs+=$(ls -d */ | cut -f1 -d'/')
cd ..

echo $img_dirs


main_design='design.fsf'

sub_base='1065809'
design_path='cocaine/1065809/session_1/rest_1/rest.ica/design.fsf'

mkdir designs

for sub in $img_dirs
do
    for num in 1 2 
    do
        if [ $sub != $sub_base ] || [ $num != 1 ]
        then
#             echo "${sub}"
#             echo "${sub_base}"
#             echo "${sub_base}/session_1/rest_1"
#             echo "${sub}/session_1/rest_$num"
#             echo ""
            sed "s/${sub_base}\/session_1\/rest_1/${sub}\/session_1\/rest_$num/g" $design_path > designs/design_${sub}_rest_${num}.fsf
    fi
    done
done
