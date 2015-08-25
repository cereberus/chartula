import time
import numpy as np
import matplotlib.pyplot as plt

a = []

plt.axis([0, 50, 0, 1])
plt.ion()
plt.show()

for i in range(50):
    a.append(np.random.random())
    plt.plot(a, 'b')
    plt.draw()
    time.sleep(0.05)
