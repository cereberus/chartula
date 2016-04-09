'''
name:
parabole_gradient.py

type:
script
'''

import numpy as np
import matplotlib.pyplot as plt


def f(x):
    return x**2

arguments = np.arange(-1, 1, 0.05)

plt.plot(arguments, f(arguments))

c = 0.05
E = 0.00001

epochs = 1000

positions = np.zeros(epochs)

x = np.zeros(epochs)
y = np.zeros(epochs)

x[0] = 0.9
y[0] = f(x[0])

for i in range(1, epochs):
    x[i] = x[i-1] - c * 2*x[i-1]
    print(x[i-1] - x[i])
    y[i] = f(x[i])

plt.plot(x, y, 'or-')
plt.show()
