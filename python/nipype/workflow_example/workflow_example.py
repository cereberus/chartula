# example based on:
# http://nbviewer.ipython.org/github/mwaskom/nipype_concepts/blob/master/\
#     workflows.ipynb

from __future__ import print_function
import numpy as np
import matplotlib.pyplot as plt
import nibabel as nib

def plot_slice(fname, z_idx=5):

    # Load the image and collect the data
    # and orientation information
    img = nib.load(fname)
    data = img.get_data()
    aff = img.get_affine()

    # Find the center of the brain matrix
    ctr = np.dot(np.linalg.inv(aff), [0, 0, 0, 1])[:3]

    # Plot the data
    vmin, vmax = (30, 150) if data.dtype == np.int16 else (30, 150)
    plt.imshow(np.rot90(data[:, :, ctr[2] + z_idx]),
           cmap="gray", vmin=vmin, vmax=vmax)
    plt.gca().set_axis_off()

from nipype.interfaces import fsl
from nipype import Node, Workflow

# For reasons that will later become clear, it's important to
# pass filenames to Nodes as absolute paths
from os.path import abspath
in_file = abspath("data/T1.nii.gz")

skullstrip = Node(fsl.BET(in_file=in_file, mask=True), name="skullstrip")

smooth = Node(fsl.IsotropicSmooth(in_file=in_file, fwhm=4), name="smooth")

mask = Node(fsl.ApplyMask(), name="mask")


# Workflows need names too
wf = Workflow(name="smoothflow")

# First the "simple", but more restricted method
wf.connect(skullstrip, "mask_file", mask, "mask_file")

# Now the more complicated method. Note this way you can define several 
# connections at once, and you can even define several connnections between
# two nodes in one smalller step
wf.connect([(smooth, mask, [("out_file", "in_file")])])



wf.write_graph("workflow_graph.dot")
from IPython.display import Image
Image(filename="workflow_graph.dot.png")



wf.base_dir = "working_dir"
wf.run()

f = plt.figure(figsize=(12, 7.5))
for i, img in enumerate(["data/T1.nii.gz",
                         "working_dir/smoothflow/smooth/T1_smooth.nii.gz",
                         "working_dir/smoothflow/mask/T1_smooth_masked.nii.gz"]):
    f.add_subplot(1, 3, i + 1)
    plot_slice(img)

plt.show()
