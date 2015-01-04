#!/bin/bash
#backlight_intel_increase

light_current=$(</sys/class/backlight/intel_backlight/brightness)

let "light_current -= 20"
tee /sys/class/backlight/intel_backlight/brightness <<< $light_current



