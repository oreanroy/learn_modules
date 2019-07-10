class test(object):
	def __init__(self, name):
		self.name = name
		self.testval = None
		dummyval = None



testinstance = test("orean")
print(testinstance.name)
print(testinstance.testval)

testinstance.testval = "the value"
print(testinstance.testval)

testinstance.dummyval = "dummy value there"
print(testinstance.dummyval)

testinstance2 = test("orean", "gothic")
print(testinstance2.name)
print(testinstance2.testval)
	
