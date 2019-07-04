class Person:
	def __init__(self, fname, lname):
		self.firstname = fname
		self.lastname = lname
		print(self)

	def printname(self):
		print(self.firstname)
		print(self)


class Student(Person):

	def __init__(self, fname, lname):
		print(self)
		Person.__init__(self, fname, lname)
		self.printname()
x = Student("john", "doe")

x.printname()
