#!/usr/bin/env python
# a bar plot with errorbars
import numpy as np
import matplotlib.pyplot as plt

values = (89, 93, 83, 87, 90)
# errors = (2, 3, 4, 1, 2)
errors = None
if errors is None:
    from scipy import stats
    error_last = stats.sem(values)
else:
    error_last = np.mean(errors)
xticklabels = ('sub01', 'sub02', 'sub03', 'sub04', 'sub05')
color='g'
color_mean='r'

width = 0.35
init_space_width = 0.35
space_width = 0.35
space_avg = init_space_width*3

N = len(values)
index = np.arange(N)

fig, ax = plt.subplots()
ax.yaxis.grid()
ax.set_axisbelow(True) 
ax.xaxis.set_tick_params(width=2, length=12)

# Hide the right and top spines
ax.spines['right'].set_visible(False)
ax.spines['top'].set_visible(False)

# Only show ticks on the left and bottom spines
ax.yaxis.set_ticks_position('left')
ax.xaxis.set_ticks_position('bottom')

error = ax.errorbar(
    1.5*init_space_width+index*(width+space_width), values, yerr=errors,
    fmt=' ', ecolor='0.0', capsize=5.0, elinewidth=3, markeredgewidth=3,
    zorder=10
    )
rects = ax.bar(
    init_space_width+index*(width+space_width),
    values, width, color=color,
    zorder=1
    )

error_mean = ax.errorbar(
    init_space_width+N*(width+space_width)-space_width+space_avg+width/2.0,
    np.mean(values),
    yerr=error_last,
    fmt=' ', ecolor='0.0', capsize=5.0, elinewidth=3, markeredgewidth=3,
    zorder=10
    )
rects_mean = ax.bar(
    init_space_width+N*(width+space_width)-space_width+space_avg,
    np.mean(values), width, color=color_mean,
    zorder=1
    )

# ax.set_title('Scores')

axis_font = {'fontname':'FreeSans', 'size':'20'}
ax.set_ylabel('Accuracy score', **axis_font)

ax.set_xticks(1.5*init_space_width+index*(width+space_width))
ax.set_xticklabels(xticklabels)
x_max = init_space_width+N*(width+space_width)-space_width+space_avg+width+init_space_width
ax.set_xlim(0, x_max)

font = {'family' : 'sans-serif',
        'weight' : 'bold',
        'size'   :  14}
plt.rc('font', **font)

ax.legend(
    (rects, rects_mean), ('Subject\'s scores', 'Mean score'),
    loc='lower left',
    fontsize=14
    )

[i.set_linewidth(2) for i in ax.spines.itervalues()]


plt.show()
