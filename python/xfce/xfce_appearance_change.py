#!/usr/bin/env python

'''
    ############################################
    # NAME: xfce_appearance_change.py
    ############################################
        Switch between day (Xfce-basic) and night (HighContrastInverse)
        xfce-appearance theme mode.

    ############################################
    # EXAMPLE USE:
    ############################################
        To simply switch between two themes (Xfce-basic and 
        HighContrastInverse) you don't have to specify parameter:
            python xfce_appearance_change.py

        You can use -t parameter to set the particular theme:
            python xfce_appearance_change.py -t Xfce-dusk
'''

import subprocess as sp  
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("-t", "--theme", help="theme name")
args = parser.parse_args()

cmd_base = 'xfconf-query -c xsettings -p /Net/ThemeName'

cmd = cmd_base
process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
output = process.communicate()[0].rstrip()

if args.theme:
    cmd += ' -s ' + args.theme
    process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
else:
    if output == 'Xfce-basic':
        cmd += ' -s HighContrastInverse'
        process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
        print('dark')
    else:
        cmd += ' -s Xfce-basic'
        process = sp.Popen(cmd,stdout=sp.PIPE,shell=True)
        print('light')
