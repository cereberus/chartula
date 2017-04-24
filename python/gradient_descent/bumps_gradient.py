'''
name:
bumps_gradient.py

type:
script
'''

import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import axes3d

min_range = -100
max_range = 100

epochs = 100

positions = np.zeros(epochs)

x = np.zeros((epochs, 2))
y = np.zeros(epochs)

c = 0.05
E = 0.00001


def f(x):
    return np.sin(5*x[0])*np.cos(5*x[1])/5.0

x[0][0] = -0.4
x[0][1] = 0.7
y[0] = f(x[0])
for i in range(1, epochs):
    x[i][0] = x[i-1][0] + c * np.cos(5*x[i-1][0])
    x[i][1] = x[i-1][1] + c * np.sin(5*x[i-1][1]) * np.power(x[i-1][1], -1)

    print(x[i])
    y[i] = f(x[i])

min_range = -1
max_range = 1
a = np.arange(min_range, max_range, 0.05)
x_values, y_values = np.meshgrid(a, a)
z_values = np.sin(5*x_values)*np.cos(5*y_values)/5.0


fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.plot_wireframe(
    x_values, y_values, z_values, rstride=2, cstride=2
    )
ax.plot(x.T[0], x.T[1], y, c='r')
ax.scatter(x.T[0], x.T[1], y, c='r')
ax.set_xlim(min_range, max_range)
ax.set_ylim(min_range, max_range)
ax.set_zlim(z_values.min(), z_values.max())
plt.show()
