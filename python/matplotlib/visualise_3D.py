import matplotlib.pyplot as plt
import numpy as np


def plot(data):
    fig = plt.figure()
    ax = fig.add_subplot(111, projection='3d')

    cm = [['r', 'o'], ['b', '^'], ['g', 'x']]

    for i in range(len(data)):
        xs = data[i][0]
        ys = data[i][1]
        zs = data[i][2]
        ax.scatter(xs, ys, zs, c=cm[i][0], marker=cm[i][1], s=100)

    ax.set_xlabel('X Label')
    ax.set_ylabel('Y Label')
    ax.set_zlabel('Z Label')

    plt.show()


color = np.array([
    [214, 0, 0], [210, 62, 90], [147, 10, 36], [212, 52, 52],
    [229, 76, 98], [204, 0, 67], [188, 62, 109], [235, 0, 51],
    [16, 39, 213], [18, 157, 159], [53, 198, 153], [23, 119, 150],
    [0, 95, 255], [37, 74, 136], [4, 45, 196], [10, 143, 255]
    ])

data_classes = [color[0:8].T, color[8:16].T]
plot(data_classes)
