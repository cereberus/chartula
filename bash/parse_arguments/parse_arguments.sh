#!/bin/bash

# Iterate trough list of arguments.
# http://stackoverflow.com/a/255913
ARGS="$@"
for arg in "$@"
do
    echo "$arg"
done

# Consequent agruments are $1, $2, ..., $n
# http://how-to.wikia.com/wiki/How_to_read_command_line_arguments_in_a_bash_script
base_dir=$1
output_dir=$2/$(basename $base_dir)

echo 'base_dir: '$base_dir
echo 'output_dir: '$output_dir
