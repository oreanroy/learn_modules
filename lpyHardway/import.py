import script
print("%s 1  this is being printed from outside" % __name__)


for i in range(1000000):
	None

print("%r this is the script in retr format" % script)
print(type(script))

script.test()
