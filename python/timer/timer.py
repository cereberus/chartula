import time
import pyglet

minutes = 5
seconds = 60

while (minutes >= 0):
    if minutes >= 0:
        while(seconds > 0):
            if minutes >= 10:
                if seconds >= 10:
                    s = '%s:%s'
                    print('%s:%s' % (minutes, seconds))
                else:
                    s = '%s:0%s'
                    print('%s:0%s' % (minutes, seconds))
                time.sleep(1)
                seconds -= 1
            else:
                if seconds >= 10:
                    s = '0%s:%s'
                    print('0%s:%s' % (minutes, seconds))
                else:
                    s = '0%s:0%s'
                    print('0%s:0%s' % (minutes, seconds))
                time.sleep(1)
                seconds -= 1

            window = pyglet.window.Window(fullscreen=True)
            current_time = pyglet.text.Label(s % (minutes, seconds),
                              font_name='Times New Roman',
                              font_size=36,
                              x = window.width // 2, y = window.height // 2,
                              anchor_x='center', anchor_y='center')

            @window.event
            def on_draw():
                window.clear()
                current_time.draw()
            pyglet.app.run()
    seconds = 60
    minutes -= 1
    window.close()


music = pyglet.resource.media('dota.mp3')
music.play()

pyglet.app.run()


#from __future__ import print_function
#import time
#def timer(self):
    #for h in range(0, 24):
        #for m in range(0, 60):
            #for s in range(0, 60):
                #time.sleep(1)
                #print ("Elapsed time : %s:%s:%s" % (h, m, s), end="\r")
#
