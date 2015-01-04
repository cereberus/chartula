import csv
import datetime
import os
from os import listdir
from os.path import isfile, join

name = []
proper = []
decision = []
cell = ""


path_get_csv_input='/home/jesmasta/downloads/psychopy_sample/csv_output/'

csv_input_list = [ f for f in listdir(path_get_csv_input) if isfile(join(path_get_csv_input,f)) ]
print(csv_input_list)

for i in range(len(csv_input_list)):
    def csv_read_cell(x, y, z):
        with open(path_get_csv_input+csv_input_list[i] , 'r') as f:
            reader = csv.reader(f)
            y_count = 0
            for row in reader:
                decision.append(row[x])
                decision.append("BREAK")

    csv_read_cell(0, 6, 8)


    #
    #def csv_read_cell(x, y):
        #with open(path_get_csv_input+csv_input_list[i] , 'r') as f:
            #reader = csv.reader(f)
            #y_count = 0
            #for row in reader:
                #if y_count == y:
                    #cell = row[x]
                #y_count += 1
        #print(" ")
        #return(cell)

    #print(csv_read_cell(4,0))
    #csv_read_cell(1,1)

