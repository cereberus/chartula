import os
import scipy.io as sio
import matplotlib.pyplot as plt

home_dir = os.path.expanduser('~')
matlab_data = sio.loadmat(
    os.path.join(home_dir, 'Downloads/SSVEP_14Hz_Trial1_SUBJ1.MAT')
    )
data = matlab_data['EEGdata']

plt.plot(data[10])
plt.show()
