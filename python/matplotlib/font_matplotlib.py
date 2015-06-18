#!/usr/bin/env python
# -*- coding: utf-8 -*-

import matplotlib.pyplot as plt

font = {'family': 'sans-serif',
        'weight': 'bold',
        'size': 20}
plt.rc('font', **font)

sample_data = [i for i in range(5)]

plt.plot(sample_data, sample_data)
plt.show()
