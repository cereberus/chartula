#!/usr/bin/env python
import numpy as np
import matplotlib.pyplot as plt

'''
NOTICE: this examples assumes that you want to create 1 or 2 samples plot.

In case of 2 samples mean horizontal line is plotted only for the first sample.
'''

# Now you choose in this example (number of samples: 0 or 1):
number_of_samples = 1

if number_of_samples==1:
    values = np.array([
        [
            60.53, 26.95, 59.78, 62.36, 54.98, 37.23,
            29.23, 27.65, 27.72, 42.55, 38.40, 43.04
        ],
        ])
    ylabel = 'Information Transfer Rate (ITR)'
    legend_labels = ('Subjects\' ITR', 'Mean ITR')
    # where the legend should be
    # if it ought to be outside the tuple's variables should be like:
    # box_to_anchor = (1.25, 0.0)
    box_to_anchor = (1.25, 0.0)
    ylim = (0, 70)

elif number_of_samples==2:
    values = np.array([
        [1., 0.83, 0.93, 0.93, 0.93, 0.88, 0.81, 0.83, 0.83, 0.93, 0.88, 0.93],
        [1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
        ])*100
    ylabel = 'Accuracy score [%]'
    legend_labels = (
        'Subjects\' performance', 'Mean performance', 'Blink classification'
        )
    # where the legend should be
    # if it ought to be outside the tuple's variables should be like:
    box_to_anchor = (1.35, 0.0)
    ylim = (0, 100)

colors = ['g', '#427cff']
xticklabels = (
    'sub_001', 'sub_002', 'sub_003', 'sub_004', 'sub_005', 'sub_006',
    'sub_007', 'sub_008', 'sub_009', 'sub_010', 'sub_011', 'sub_012'
    )
color_mean = 'r'

width = 0.35
init_space_width = 0.35
space_width = 0.7
rotation = 45

N = values.shape[-1]
index = np.arange(N)

fig, ax = plt.subplots()
ax.yaxis.grid(
    linewidth=2.0, linestyle='dashed', dash_capstyle='round', dashes=[1, 10]
    )
ax.set_axisbelow(True)
ax.xaxis.set_tick_params(width=2, length=12)

# Hide the right and top spines
ax.spines['right'].set_visible(False)
ax.spines['top'].set_visible(False)

# Only show ticks on the left and bottom spines
ax.yaxis.set_ticks_position('left')
ax.xaxis.set_ticks_position('bottom')

rects = []

for i in range(values.shape[0]):
    rects.append(
        ax.bar(
            init_space_width+width*i+index*(width+space_width),
            values[i], width, color=colors[i],
            zorder=1
            )
        )

mean = plt.axhline(
    np.mean(values[0]), linewidth=6, color=color_mean,
    # linestyle='dashed', dash_capstyle='round', dashes=[1, 10]
    )
# mean.set_dashes([1,10])

# ax.set_title('Scores')

axis_font = {'fontname': 'FreeSans', 'size': '36'}
ax.set_ylabel(ylabel, labelpad=20, **axis_font)
ax.set_xlabel('Subjects', labelpad=20, **axis_font)

xtickdists = init_space_width + width * values.shape[0]/2.0 - \
    ((90-rotation)/100. * width) + \
    index*(width+space_width)

ax.set_xticks(xtickdists)
ax.set_xticklabels(xticklabels, rotation=rotation)
x_max = init_space_width+N*(width+space_width) \
    - space_width+init_space_width*values.shape[0]
ax.set_xlim(0, x_max)
ax.set_ylim(ylim)

plt.rcParams.update({'font.size': 32})

[i.set_linewidth(2) for i in ax.spines.itervalues()]

box = ax.get_position()
# ax.set_position([box.x0, box.y0, box.width * 0.8, box.height])

# Put a legend to the right of the current axis
legend = ax.legend(
    [rects[0]] + [mean] + [rects[i] for i in range(len(rects)) if i != 0],
    legend_labels,
    fontsize=30,
    loc='lower right',
    bbox_to_anchor=box_to_anchor
    )
############################################
#
#    FIGURE SIZE AND EXPORT SETTINGS
#
############################################

# maximize the window
# NOTICE: figManager messes with figure size.
#  figManager = plt.get_current_fig_manager()
#  figManager.window.showMaximized()

# set export figure size
fig.set_size_inches(25, 15)
# save figure
fig.savefig(
    '/tmp/bar_n_samples_mean_hline_rotation.png',
    bbox_extra_artists=(legend,), bbox_inches='tight'
    )

plt.show()
