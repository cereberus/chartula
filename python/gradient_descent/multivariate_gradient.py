'''
name:
task_004_gradient.py

type:
script

description:
Two examplary functions available. Choose function variable value: 1 or 2.
'''

import numpy as np
import matplotlib.pyplot as plt
import inspect


def f_1((x, y, z)):
    return 2*x**2 + 2*y**2 + z**2 - 2*x*y - 2*x*z - 2*x - 3

derivate_1 = (
    lambda x1: 4*x1 - 4,
    lambda x2: 4*x2 - 4,
    lambda x3: 2*x3 - 2,
    )


def f_2((x, y)):
    return 3*x**4 + 4*x**3 - 12*x**2 + 12*y**2 - 24*y

derivate_2 = (
    lambda x1: 12*x1**3 + 12*x1**2 - 24*x1,
    lambda x2: 24*x2 - 24,
    )


###
# SETTINGS
###

# possible 1 or 2
function = 2

c = 0.01
epsilon = 0.000001

epochs = 10000
###

###
# APPLY SETTINGS
###

# choose function
if function == 1:
    f = f_1
    Df = derivate_1
else:
    f = f_2
    Df = derivate_2

# num_arguments = f.func_globals['num_arguments']
num_arguments = len(inspect.getargspec(f)[0][0])
###

x = np.zeros(shape=(epochs, num_arguments))
y = np.zeros(shape=(epochs))
x[0] = 3.0
y[0] = f(x[0])


for i in range(1, epochs):

    for j in range(len(x[i])):

        x[i][j] = x[i-1][j] - c*Df[j](x[i-1][j])

    y[i] = f(x[i])

    if np.max(abs(x[i] - x[i-1])) < epsilon:
        print('arguments: %s' % x[i])
        print('f() value: %s' % f(x[i]))
        last_ind = i
        break


# visualization available only for 3 dimensions (i.e. 2 arguments, 1 value)
if num_arguments == 2:
    min_range = -3.7
    max_range = 3.2
    step = 0.05

    a = np.arange(min_range, max_range, step)
    x_values, y_values = np.meshgrid(a, a)
    z_values = f([x_values, y_values])

    fig = plt.figure()
    ax = fig.add_subplot(111, projection='3d')
    ax.plot_wireframe(
        x_values, y_values, z_values, rstride=10, cstride=10
        )
    ax.plot(x.T[0][:last_ind], x.T[1][:last_ind], y[:last_ind], c='r')
    ax.scatter(x.T[0][:last_ind], x.T[1][:last_ind], y[:last_ind], c='r')
    ax.scatter(x.T[0][0], x.T[1][0], y[0], c='g', s=100)
    ax.set_xlim(min_range, max_range)
    ax.set_ylim(min_range, max_range)
    ax.set_zlim(z_values.min(), z_values.max())
    plt.show()
