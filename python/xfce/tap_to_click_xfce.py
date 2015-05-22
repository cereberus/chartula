#!/usr/bin/env python

'''
    ############################################
    # NAME: tap_to_click_xfce.py
    ############################################
        Turns on and off xfce's tap to click.

    ############################################
    # EXAMPLE USE:
    ############################################
        python tap_to_click_xfce.py
'''

import subprocess as sp  

# command to query the value of the parameter of the touchpad
cmd = 'xfconf-query -c pointers \
        -p /SynPS2_Synaptics_TouchPad/Properties/Synaptics_Tap_Action'
process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
output = process.communicate()[0].rstrip()

# check the last digit of the output
# if it is 0 it means that the tap to click is disabled
if output[-1] == '0':
    # enable tap  to click
    cmd += ' -t int -t int -t int -t int -t int -t int -t int \
            -s 0 -s 0 -s 0 -s 0 -s 1 -s 3 -s 2'
    process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
    print('tap to click is enabled')
else:
    # disable tap  to click
    cmd += ' -t int -t int -t int -t int -t int -t int -t int \
            -s 0 -s 0 -s 0 -s 0 -s 0 -s 0 -s 0'
    process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
