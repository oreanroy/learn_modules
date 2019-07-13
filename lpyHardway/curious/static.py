class test:
	def do(self):
		print("i was called")
	@staticmethod
	def doit():
		print(" i work only when static")

#test.do()
test.doit()

test1 = test()
test1.do()
test1.doit()
