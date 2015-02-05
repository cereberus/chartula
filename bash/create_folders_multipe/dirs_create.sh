#!/usr/bin/env bash

################################
# Creates directories
# for fmri data
################################

SUBS_NUMBER=6
RUNS_NUMBER=12

mkdir $( seq --format="sub%03.f" $SUBS_NUMBER)

for ((i=1;i<=SUBS_NUMBER;i++)); do
    cd $(seq --format="sub%03.f" $i $i)
    mkdir $( seq --format="task001_run%03.f" $RUNS_NUMBER)
    cd ..
done
