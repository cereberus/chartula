#!/usr/bin/env python
# a bar plot with errorbars
import numpy as np
import matplotlib.pyplot as plt

values = np.array([
    [0.99074074074074081, 0.82407407407407396, 0.99537037037037035],
    [0.98333333333333339, 0.82815675609793249, 0.9916666666666667],
    [1.0, 0.90740740740740744, 1.0]
    ])*100

xticklabels = ('LDA', 'k-NN', 'SVC')
# colors = ['g', '#427cff', '#aa7939']
colors = ['g', '#427cff', '#cacaca']
color_chance = 'r'

width = 0.35
init_space_width = 0.35*2
space_width = width*values.shape[0]*2
ylim = (0, 100)

N = values.shape[-1]
index = np.arange(N)

fig, ax = plt.subplots()
ax.yaxis.grid(
    linewidth=2.5, linestyle='dashdot', dash_capstyle='round', dashes=[1, 8],
    alpha=0.5
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
means = []

for i in range(values.shape[0]):
    rects.append(
        ax.bar(
            init_space_width+index*(width+space_width)+width*i,
            values[i], width, color=colors[i],
            zorder=1
            )
        )

chance = plt.axhline(
    50, linewidth=6, color=color_chance,
    linestyle='dashed', dash_capstyle='round', dashes=[1, 10]
    )
# mean.set_dashes([1,10])


# ax.set_title('Scores')

axis_font = {'fontname': 'FreeSans', 'size': '36'}
ax.set_ylabel('Classification scores [%]', **axis_font)

xticks = init_space_width + width*values.shape[0]/2.0 + \
    index*(width+space_width)

ax.set_xticks(xticks)
ax.set_xticklabels(xticklabels)
x_max = init_space_width+N*(width+space_width) \
    - space_width+init_space_width*values.shape[0] + init_space_width*0.75
ax.set_xlim(0, x_max)
ax.set_ylim(ylim)

plt.rcParams.update({'font.size': 40})

[i.set_linewidth(2) for i in ax.spines.itervalues()]

ax.legend(
    # (rects[0], rects[1], rects[2]),
    # ('Accuracy', 'Precision', 'Recall'),
    (rects[0], rects[1], rects[2], chance),
    ('Accuracy', 'Precision', 'Recall', 'Chance level'),
    loc='lower right',
    fontsize=30
    )

############################################
#
#    FIGURE SIZE AND EXPORT SETTINGS
#
############################################

# maximize the window
# NOTICE: figManager messes with figure size.
figManager = plt.get_current_fig_manager()
figManager.window.showMaximized()

# set export figure size
fig.set_size_inches(25, 15)
# save figure
plt.savefig('/tmp/bar_nsample_means_hline.svg')

plt.show()
