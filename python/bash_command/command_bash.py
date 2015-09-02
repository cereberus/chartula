import subprocess as sp
cmd = 'pwd'
process = sp.Popen(cmd, stdout=sp.PIPE, shell=True)
output = process.communicate()[0]
print(output)
