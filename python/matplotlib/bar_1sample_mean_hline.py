#!/usr/bin/env python
# a bar plot with errorbars
import numpy as np
import matplotlib.pyplot as plt

# values = [5934.87, 5632.14, 3365.38, 5500.0, 3166.67, 6431.82]
values = [4945.19, 4025.0, 7967.14, 4687.5]
# errors = (2, 3, 4, 1, 2)
errors = None
if errors is None:
    from scipy import stats
    error_last = stats.sem(values)
else:
    error_last = np.mean(errors)
# xticklabels = (
    # 'Developers', 'Managers', 'Designers',
    # 'Consultants', 'Copywrighters', 'Different'
    # )
xticklabels = (
    'Umowa o Prace', 'Umowa Zlecenie', 'Business-to-Business', 'UoP/B2B'
    )
color='b'
color_mean='r'

width = 0.5
init_space_width = 0.35
space_width = 0.35
ylim=(0.0, 8000.0)

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


plt.axhline(
    np.mean(values), linewidth=3, color='k',
    linestyle='dashed', dash_capstyle='round'
    )

# ax.set_title('Scores')

axis_font = {'fontname':'FreeSans', 'size':'20'}
ax.set_ylabel('Expected Salaries [PLN]', **axis_font)

xticks = (1.5*init_space_width+index*(width+space_width))-0.2
xticks[2] -= 0.15
xticks[3] += 0.15
ax.set_xticks(xticks)
ax.set_xticklabels(xticklabels, rotation=45)
plt.tick_params(
    axis='x',          # changes apply to the x-axis
    which='both',      # both major and minor ticks are affected
    bottom='off',      # ticks along the bottom edge are off
    top='off')         # ticks along the top edge are off
x_max = init_space_width+N*(width+space_width)-space_width+init_space_width
ax.set_xlim(0, x_max)
ax.set_ylim(ylim)

font = {'family' : 'sans-serif',
        'weight' : 'bold',
        'size'   :  14}
plt.rc('font', **font)

[i.set_linewidth(2) for i in ax.spines.itervalues()]


fig.savefig(
    '/tmp/bar_1_samp.png',
    bbox_inches='tight'
    )
fig.savefig(
    '/tmp/bar_1_samp.pdf',
    bbox_inches='tight'
    )

plt.show()
