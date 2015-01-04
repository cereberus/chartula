#!/usr/bin/env python
# ----------------------------------------------------------------------------
# pyglet
# Copyright (c) 2006-2008 Alex Holkner
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
#  * Redistributions of source code must retain the above copyright
#    notice, this list of conditions and the following disclaimer.
#  * Redistributions in binary form must reproduce the above copyright
#    notice, this list of conditions and the following disclaimer in
#    the documentation and/or other materials provided with the
#    distribution.
#  * Neither the name of pyglet nor the names of its
#    contributors may be used to endorse or promote products
#    derived from this software without specific prior written
#    permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.
# ----------------------------------------------------------------------------

'''A full-screen minute:second timer.  Leave it in charge of your conference
lighting talks.

After 5 minutes, the timer goes red.  This limit is easily adjustable by
hacking the source code.

Press spacebar to start, stop and reset the timer.
'''

import pyglet
#import time as tm

#window = pyglet.window.Window()
window = pyglet.window.Window(fullscreen=True)

background = pyglet.resource.image('green_pattern_poker_dark.jpg')

font_color_counting = (255, 255, 255, 255)
font_color_alarm = (180, 0, 0, 255)

minutes_to_rise = 10



class Timer(object):
    def __init__(self):
        self.label = pyglet.text.Label('00:00', font_size=180,
                                       font_name='Times New Roman',
                                       x = window.width // 2,
                                       y = window.height // 2,
                                       anchor_x='center', anchor_y='center')
        self.reset()

    def reset(self):
        ### set minutes here! ###
        self.minutes = minutes_to_rise
        self.time = self.minutes * 60
        m, s = divmod(self.time, 60)
        self.running = False
        self.label.text = '%02d:%02d' % (m, s)
        self.label.color = font_color_counting

    def update(self, dt):
        if self.running:
            self.label.color = font_color_counting
            self.time -= dt
            m, s = divmod(self.time, 60)
            self.label.text = '%02d:%02d' % (m, s)
            if self.time <= 1:
                self.label.color = font_color_alarm
                alarm = pyglet.resource.media('dota.mp3')
                alarm.play()
                self.time = self.minutes * 60
                timer.running = False
                #tm.sleep(alarm.duration)
                #timer.running = True


@window.event
def on_key_press(symbol, modifiers):
    if symbol == pyglet.window.key.SPACE:
        if timer.running:
            timer.running = False
        else:
            if timer.time <= 0:
                timer.reset()
            else:
                timer.running = True
    elif symbol == pyglet.window.key.ESCAPE:
        window.close()


@window.event
def on_draw():
    window.clear()
    background.blit(0, 0)
    timer.label.draw()

timer = Timer()
# repeat class every 1 second
pyglet.clock.schedule_interval(timer.update, 1)
pyglet.app.run()
