'''
    name:
        calculator_time.py
    # # #

    description:
        Calculates the time between the set of the houres.

        Modified version of: http://stackoverflow.com/a/1965230
'''

def difftime(start, finish):
    sh, sm = start.split(':')
    time1 = int(sm) + 60 * int(sh)

    sh, sm = finish.split(':')
    time2 = int(sm) + 60 * int(sh)

    diff = time2 - time1
    return diff

# counter
overall = 0

# 0'th element is date, then start time and finish time
table = [
    [20150624, '11:40', '19:40'],
    [20150702, '10:00', '19:00'],
    [20150703, '10:00', '19:00'],
    [20150707, '11:00', '19:00'],
    [20150708, '11:00', '19:00'],
    [20150710, '10:30', '18:30'],
    [20150715, '10:00', '15:30'],
    [20150721, '10:00', '18:30'],
    [20150722, '10:00', '20:00'],
    [20150723, '10:30', '19:00'],
    [20150804, '10:30', '17:30']
    ]

# calculate for all examples
for i in table:
    overall += difftime(i[1], i[2])

# there are X houres and Y minutes between these days/houres
print "Overall time: %d hours and %d minutes" % (overall//60, overall%60)
