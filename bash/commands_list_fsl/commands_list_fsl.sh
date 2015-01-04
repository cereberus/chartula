#!/bin/bash

prefix_command="fsl5.0-"
commands_fsl=$(compgen -c | grep $prefix_command)

for i in $commands_fsl
    do
        echo "alias ${i#$prefix_command}='$i'" >> .fsl_inte  
    done

