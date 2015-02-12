#!/bin/bash

mask_list=$(ls -1 ../sub001/masks/ | grep "epi")
subs_list=$(ls -1 ../ | grep "sub00")

for i in $subs_list
do
    echo ""
    echo ""
    echo "############################################"
    echo $i
    echo "########"
    echo ""

    echo "###############"
    echo "complete DMN (all elements)"
    echo "####"
    counter=0
    echo "run_001 and run 002"
    3ddot ../$i/task001_run001/thresh_zstat2.nii.gz ../$i/task001_run002/thresh_zstat2.nii.gz
    counter=$(bc <<< "scale=8;$counter+$(3ddot ../$i/task001_run001/thresh_zstat2.nii.gz ../$i/task001_run002/thresh_zstat2.nii.gz)")
    echo "run_003 and run 004"
    3ddot ../$i/task001_run003/thresh_zstat2.nii.gz ../$i/task001_run004/thresh_zstat2.nii.gz
    counter=$(bc <<< "scale=8;$counter+$(3ddot ../$i/task001_run003/thresh_zstat2.nii.gz ../$i/task001_run004/thresh_zstat2.nii.gz)")
    echo "run_005 and run 006"
    3ddot ../$i/task001_run005/thresh_zstat2.nii.gz ../$i/task001_run006/thresh_zstat2.nii.gz
    counter=$(bc <<< "scale=8;$counter+$(3ddot ../$i/task001_run005/thresh_zstat2.nii.gz ../$i/task001_run006/thresh_zstat2.nii.gz)")
    echo "run_007 and run 008"
    3ddot ../$i/task001_run007/thresh_zstat2.nii.gz ../$i/task001_run008/thresh_zstat2.nii.gz
    counter=$(bc <<< "scale=8;$counter+$(3ddot ../$i/task001_run007/thresh_zstat2.nii.gz ../$i/task001_run008/thresh_zstat2.nii.gz)")
    echo "run_009 and run 010"
    3ddot ../$i/task001_run009/thresh_zstat2.nii.gz ../$i/task001_run010/thresh_zstat2.nii.gz
    counter=$(bc <<< "scale=8;$counter+$(3ddot ../$i/task001_run009/thresh_zstat2.nii.gz ../$i/task001_run010/thresh_zstat2.nii.gz)")
    echo "run_011 and run 012"
    3ddot ../$i/task001_run011/thresh_zstat2.nii.gz ../$i/task001_run012/thresh_zstat2.nii.gz
    counter=$(bc <<< "scale=8;$counter+$(3ddot ../$i/task001_run011/thresh_zstat2.nii.gz ../$i/task001_run012/thresh_zstat2.nii.gz)")
    echo ""

    avg_list_all+=$i"_whole_dmn_"
    avg_list_all+=$(bc <<< "scale=8;$counter/6")" "

    for j in $mask_list
    do
        echo "###############"
        echo $j
        echo "####"
        counter=0
        echo "run_001 and run 002"
        3ddot -mask ../$i/masks/$j ../$i/task001_run001/thresh_zstat2.nii.gz ../$i/task001_run002/thresh_zstat2.nii.gz
        counter=$(bc <<< "scale=8;$counter+$(3ddot -mask ../$i/masks/$j ../$i/task001_run001/thresh_zstat2.nii.gz ../$i/task001_run002/thresh_zstat2.nii.gz)")
        echo "run_003 and run 004"
        3ddot -mask ../$i/masks/$j ../$i/task001_run003/thresh_zstat2.nii.gz ../$i/task001_run004/thresh_zstat2.nii.gz
        counter=$(bc <<< "scale=8;$counter+$(3ddot -mask ../$i/masks/$j ../$i/task001_run003/thresh_zstat2.nii.gz ../$i/task001_run004/thresh_zstat2.nii.gz)")
        echo "run_005 and run 006"
        3ddot -mask ../$i/masks/$j ../$i/task001_run005/thresh_zstat2.nii.gz ../$i/task001_run006/thresh_zstat2.nii.gz
        counter=$(bc <<< "scale=8;$counter+$(3ddot -mask ../$i/masks/$j ../$i/task001_run005/thresh_zstat2.nii.gz ../$i/task001_run006/thresh_zstat2.nii.gz)")
        echo "run_007 and run 008"
        3ddot -mask ../$i/masks/$j ../$i/task001_run007/thresh_zstat2.nii.gz ../$i/task001_run008/thresh_zstat2.nii.gz
        counter=$(bc <<< "scale=8;$counter+$(3ddot -mask ../$i/masks/$j ../$i/task001_run007/thresh_zstat2.nii.gz ../$i/task001_run008/thresh_zstat2.nii.gz)")
        echo "run_009 and run 010"
        3ddot -mask ../$i/masks/$j ../$i/task001_run009/thresh_zstat2.nii.gz ../$i/task001_run010/thresh_zstat2.nii.gz
        counter=$(bc <<< "scale=8;$counter+$(3ddot -mask ../$i/masks/$j ../$i/task001_run009/thresh_zstat2.nii.gz ../$i/task001_run010/thresh_zstat2.nii.gz)")
        echo "run_011 and run 012"
        3ddot -mask ../$i/masks/$j ../$i/task001_run011/thresh_zstat2.nii.gz ../$i/task001_run012/thresh_zstat2.nii.gz
        counter=$(bc <<< "scale=8;$counter+$(3ddot -mask ../$i/masks/$j ../$i/task001_run011/thresh_zstat2.nii.gz ../$i/task001_run012/thresh_zstat2.nii.gz)")
        echo ""

        avg_list_all+=$i"_"$j"_"
        avg_list_all+=$(bc <<< "scale=8;$counter/6")" "
    done
    avg_list_all+=" ############################### "
    avg_list_all+=" ________ "
    echo "############################################"
    echo ""
    echo ""
done

for avg_corr in $avg_list_all
do
    echo $avg_corr
done
