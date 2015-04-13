"""
corr_plt_example.py

Bar chart showing correlations between odd and even runs' rest blocks.
"""
import numpy as np
import matplotlib.pyplot as plt

n_groups = 3

corre = (0.45598450, 0.33875316, 0.56242216)
std_men = (0.1, 0.075, 0.05)
colors = ('#d52d29', 'g', '#f19c1b')
# colors = ('r', 'g', 'b')

fig, ax = plt.subplots()
# ax.axhline(linewidth=12)
ax.yaxis.grid()
ax.set_axisbelow(True) 
ax.xaxis.set_tick_params(width=2, length=12)
ax.yaxis.set_tick_params(width=2, length=12)

# Hide the right and top spines
ax.spines['right'].set_visible(False)
ax.spines['top'].set_visible(False)

# Only show ticks on the left and bottom spines
ax.yaxis.set_ticks_position('left')
ax.xaxis.set_ticks_position('bottom')

index = np.arange(n_groups)
bar_width = 0.35

opacity = 1.0
# opacity = 0.4
error_config = {'ecolor': '0.0', 'capsize': 10.0}

rects1 = plt.bar(index + bar_width*1.4, corre, bar_width*1.5,
                 alpha=opacity,
                 color=colors,
                 yerr=std_men,
                 error_kw=error_config,
                 )



# plt.xlabel('ROI')
# plt.ylabel('Correlation values')
plt.xticks(index + bar_width*1.5*1.4, ('ANG', 'FP', ' PCC + P'))

font = {'family' : 'sans-serif',
        'weight' : 'bold',
        'size'   :  16}
plt.rc('font', **font)

plt.tight_layout()
plt.ylim(0.0, 1.0)

[i.set_linewidth(2) for i in ax.spines.itervalues()]

plt.savefig('corr_plt_sub002.png')
plt.show()
