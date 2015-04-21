#!/usr/bin/env python2

from psychopy import visual, core, event, gui

mywin = visual.Window([2560, 1440],monitor='testMonitor', \
        winType='pyglet', units='pix', fullscr = True)
mywin.setMouseVisible(False)

image = visual.ImageStim(win=mywin, image='cee.png', pos=(0,0))

image.draw()
mywin.flip()

while not 'space' in event.getKeys():
    pass

mywin.close()
