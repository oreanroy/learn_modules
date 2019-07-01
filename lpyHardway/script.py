print "Always executed"

print("%s 2  this is printed from inside" % __name__)
if __name__ == "__main__":
	print "executed when invoked"
else:
	print "Executed when imported"

def test():
	print ("the test func was called")

test()
