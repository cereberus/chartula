#!/bin/bash

# Takes all files within current directory and replaces one substring with
# another.
#
#
# e.g. files:
#
# left-hand.txt
# left-hand_01.txt
# left-hand_02.txt
#
# bash mass_rename.sh left-hand right-hand
#
# right-hand.txt
# right-hand_01.txt
# right-hand_02.txt

string_orig=$1
string_mod=$2

fileslist=$(ls -1)

for i in $fileslist; do
    if [[ $i == *$string_orig* ]]; then
        new_filename=$(echo $i | sed "s/$string_orig/$string_mod/")
        echo "mv $i $new_filename"
        mv $i $new_filename
    fi
done
