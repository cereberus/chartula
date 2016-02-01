#!/usr/bin/env python

import csv
import matplotlib.pyplot as plt

eeg_microvolts=[]

with open('baseline_raw.csv', 'r') as f:
    rows = list(csv.reader(f))
    for i in range(len(rows)):
        eeg_microvolts.append(rows[i][0])

print(eeg_microvolts)
print(len(eeg_microvolts))
print(len(eeg_microvolts)/512)

plt.plot(eeg_microvolts)
plt.ylabel('some numbers')
plt.show()
