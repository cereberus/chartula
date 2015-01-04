import csv
csv_list = []

with open('test.csv', 'rb') as csvfile:
     spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
     for row in spamreader:
         print ', '.join(row)
         csv_list.append(', '.join(row))
