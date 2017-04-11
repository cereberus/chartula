from savReaderWriter import SavWriter

def _example():
    savFileName = 'someFile.sav'
    records = [[b'Test1', 1, 1], [b'Test2', 2, 1]]
    varNames = ['var1', 'v2', 'v3']
    varTypes = {'var1': 5, 'v2': 0, 'v3': 0}

    with SavWriter(savFileName, varNames, varTypes) as writer:
            for record in records:
                    writer.writerow(record)

def write_to_SPSS(savFileName, records, varNames, varTypes):
    with SavWriter(savFileName, varNames, varTypes) as writer:
        for record in records:
                writer.writerow(record)
