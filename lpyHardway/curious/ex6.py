class BaseAdder(object):
	def add(self, a, b):
		return a+b

class NonReturningAdder(BaseAdder):
	def add(self, a, b):
		super(NonReturningAdder, self).add(a, b)

class ReturningAdder(BaseAdder):
	def add(self, a, b):
		return super(ReturningAdder, self).add(a, b)

