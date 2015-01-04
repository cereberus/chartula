import csv

raw_signal=[]
time_elapsed=[]

with open('baseline_raw.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
    for row in spamreader:
        raw_signal.append(row[1])
        time_elapsed.append(row[0])

print(raw_signal)
print(time_elapsed)
