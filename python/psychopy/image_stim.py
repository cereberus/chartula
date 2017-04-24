#!/usr/bin/env python2

'''
name:
image_stim.py

type:
script
'''

from psychopy import visual, event

mywin = visual.Window(
    [2560, 1440],
    monitor='testMonitor',
    winType='pyglet',
    units='pix',
    fullscr=True
    )
mywin.setMouseVisible(False)

image = visual.ImageStim(win=mywin, image='cee.png', pos=(0, 0))

image.draw()
mywin.flip()

while 'space' not in event.getKeys():
    pass

mywin.close()
