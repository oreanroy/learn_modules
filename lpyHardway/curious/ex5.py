class test():
	def __init__(self, word):
		self.word = word
		print(self)
		print(dir(self))
		print(self.word)
test1 = test("a test")
test2 = test("another test")
