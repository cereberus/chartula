'''
    csv module for writing 2D list to the file

    arguments:
        results - 2D python list
        name - output filename (can be preceded with path)

    example use:

        import write_csv

        some_list = [[1, 2, 3], [4, 5, 6]]

        write_csv.write(some_list, name=example.csv)

'''

import csv


def write(input_list, name='csv_out.csv'):
    with open(name, 'wb') as f:
        save = csv.writer(f)
        for row_list in input_list:
            save.writerow(row_list)
