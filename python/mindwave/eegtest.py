#!/usr/bin/env python

from psychopy import visual, core, event
from pymindwave.parser import Parser
import random
import pickle
import datetime


p = Parser('/dev/rfcomm0')



for i in range(5):
	levele=[]
	wektory=[]
	atencje=[]
	medytacje=[]
	blinki=[]
	jakosci=[]
	core.wait(0.5)
	
   # p.update()
	levele.append(p.raw_values[-1])
	wektory.append(p.current_vector)
	atencje.append(p.current_attention)
	medytacje.append(p.current_meditation)
	blinki.append(p.current_blink_strength)
	try:
		jakosci.append(p.poor_signal)
	except AttributeError:
		jakosci.append(666)
	core.wait(0.5)

print levele
print wektory
print atencje
print medytacje
print blinki
print jakosci
