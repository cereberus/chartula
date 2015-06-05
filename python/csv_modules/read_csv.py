'''
    csv module for reading csv file to the 2D list

    Default mode is 'rb'
    Default delimiter is ',' and the quotechar '|'
    # # #

    arguments:
        input_csv - read csv file name
        header - specify how many lines (from the begining) are to be removed
    # # #

    example use:

        import read_csv

        some_list = read_csv.read(example.csv)
        other_list = read_csv.read(example.csv, header=5)

'''

import csv


def read(csv_file, mode='rb', delimiter=',', quotechar='|', header=None):
    data = []
    with open(csv_file, mode) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',', quotechar='|')
        for row_list in csv_reader:
            data.append(row_list)
    if header is not None:
        data = data[header:]
    return data
