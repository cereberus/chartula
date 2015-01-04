import csv
import datetime
import os
from os import listdir
from os.path import isfile, join

name = []
proper = []
decision = []

path_get_csv_input = '/home/jesmasta/downloads/psychopy_sample/csv_output/'

column = 0
row_begin = 6
row_end = 22

csv_input_list = [f for f in listdir(path_get_csv_input)
                  if isfile(join(path_get_csv_input, f))]

for i in range(len(csv_input_list)):

    # now, reads column as list. for for ordinate, y-z for abscissas
    def read_column_name(x, y, z):
        with open(path_get_csv_input + csv_input_list[i], 'r') as f:
            reader = csv.reader(f)
            y_count = 0
            for row in reader:
                if y_count > y and y_count < z:
                    cell = row[x]
                    name.append(cell)
                y_count += 1

    def read_column_proper(x, y, z):
        with open(path_get_csv_input + csv_input_list[i], 'r') as f:
            reader = csv.reader(f)
            y_count = 0
            for row in reader:
                if y_count > y and y_count < z:
                    cell = row[x]
                    proper.append(cell)
                y_count += 1

    def read_column_decision(x, y, z):
        with open(path_get_csv_input + csv_input_list[i], 'r') as f:
            reader = csv.reader(f)
            y_count = 0
            for row in reader:
                if y_count > y and y_count < z:
                    cell = row[x]
                    decision.append(cell)
                y_count += 1

    read_column_name(column + 1, row_begin, row_end)
    read_column_proper(column + 2, row_begin, row_end)
    read_column_decision(column + 3, row_begin, row_end)

    container = csv_input_list[i] + '_' + \
    datetime.datetime.now().strftime("%Y%m%d%H%M") + '_container.csv'

    with open(container, 'wb') as f:
        zapis = csv.writer(f)
        for i in range(len(name)):
            zapis.writerow([name[i], proper[i], decision[i]])
