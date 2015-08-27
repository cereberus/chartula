import os
import psutil

process = psutil.Process(os.getpid())
print(process.get_memory_info()[0] / float(2 ** 20))
