'''
name:
parabole_3d_gradient.py

type:
script
'''

import numpy as np
import matplotlib.pyplot as plt

min_range = -100
max_range = 100

epochs = 100

positions = np.zeros(epochs)

x = np.zeros((epochs, 2))
y = np.zeros(epochs)

c = 0.05
E = 0.00001


def f(x):
    return x[0]**2 + x[1]**2

x[0] = 0.9
y[0] = f(x[0])
for i in range(1, epochs):
    for j in range(x.shape[1]):
        x[i][j] = x[i-1][j] - c * 2*x[i-1][j]
        print(x[i][j])
        # print(x[i])
        # print(x[i-1][j] - x[i][j])
    y[i] = f(x[i])

min_range = -1
max_range = 1
a = np.arange(min_range, max_range, 0.05)
x_values, y_values = np.meshgrid(a, a)
# z = np.zeros(x.shape)
z_values = x_values**2 + y_values**2


fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.plot_wireframe(
    x_values, y_values, z_values, rstride=5, cstride=5
    )
ax.plot(x.T[0], x.T[1], y, c='r')
ax.scatter(x.T[0], x.T[1], y, c='r')
ax.set_xlim(min_range, max_range)
ax.set_ylim(min_range, max_range)
ax.set_zlim(z_values.min(), z_values.max())
plt.show()
