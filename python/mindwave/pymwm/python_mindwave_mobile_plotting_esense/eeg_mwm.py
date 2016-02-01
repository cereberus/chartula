#!/usr/bin/env python

from psychopy import visual, core, event
from parser import Parser
import random
import datetime
import multiprocessing
import csv
import matplotlib.pyplot as plt

p = Parser()

# dat=[-50000,50000]
dat=[0,100]
fig = plt.figure()
ax = fig.add_subplot(111)
Ln, = ax.plot(dat)
ax.set_xlim([0,50])
plt.ion()
plt.show()    



# def start_recording(e):
#     num_lines_prev = 0
#     while True:
#         count = 0
#         num_lines = sum(1 for line in open('baseline_raw.csv'))
#         if num_lines > num_lines_prev:
#             with open('baseline_raw.csv', 'rb') as csvfile:
#                 reader = csv.reader(csvfile, delimiter=' ', quotechar='|')
#                 for row in reader:
#                     count += 1
#                     if count > num_lines_prev:
#                         dat.append(row[0])
#                         print ', '.join(row)
#             ax.set_xlim([len(dat)-100,len(dat)]) 
# #             dat.append(float(value)*0.0002197265625)
#             Ln.set_ydata(dat)
#             Ln.set_xdata(range(len(dat)))
#             plt.pause(0.001)
# 
# 
# exp_end = multiprocessing.Event()
# 
# mindwave_rec = multiprocessing.Process(name='block', 
#                              target=start_recording,
#                              args=(exp_end,))

num_lines_prev = 0

while True:
    p.update()
#     print('start recording')
#     p.start_raw_recording("baseline_raw.csv")
    p.start_esense_recording("esense_raw.csv")
    count = 0
    num_lines = sum(1 for line in open('esense_raw.csv'))
    if num_lines > num_lines_prev:
        with open('esense_raw.csv', 'rb') as csvfile:
            reader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for row in reader:
                count += 1
                if count > num_lines_prev:
                    dat.append(row[1])
                    print(row[1])
#                     print ', '.join(row)
        ax.set_xlim([len(dat)-10,len(dat)]) 
#             dat.append(float(value)*0.0002197265625)
        Ln.set_ydata(dat)
        Ln.set_xdata(range(len(dat)))
        plt.pause(0.001)
