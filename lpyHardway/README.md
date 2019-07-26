## Pyhton Cheat sheet

#### %s, %d, %r uses in pyhton

%d is used for formated number display
%s is used for str(0) that is string representaion of object diaply it is a readble form 
%r is uded for repr(0) that is canonical representaion of object display that is if it is passed as an argument to eval function then it can executed as code. This gives out a format which can be run, not intrested in readable format as str(0) above.

Take an example of this 
	formatter = "%r %r %r %r"

	print formatter % (
	" I had this thing.".
	" That you could type up right.",
	" But it didn't sing.",
	" So i said goodnight."
	)
This thing prints

	'I had this thing.' 'That you could type up right.' "But it didn't sing."
 'So I said goodnight.'

That is beacuse python when using % prints in such a manner that is most efficient not replicate your way.

#### use of ** and * in arguments while declarinf functions

* indicates that the number of input to the function is variabe where as ** indicates that the multiple input will be a key value pair.

	def adder(*num):
    	sum = 0
    
   	 for n in num:
        	sum = sum + n
    	print("Sum:",sum)
	adder(3,5)
	adder(4,5,6,7)
	adder(1,2,3,5,6)



	def intro(**data):
		print("\nData type of argument:",type(data))
    		for key, value in data.items():
        		print("{} is {}".format(key,value))

	intro(Firstname="Sita", Lastname="Sharma", Age=22, Phone=1234567890)

#### __name__ in python

the python assigns a global value  __main__ to __name__ varibale if the source file is running as the main function but in case it is imported from other pyhton module the __name__ variable is assigned a value equal to the name of the module from which is imported.

### try to understand the code snippet below

##### the script.py
	print "Always executed"

	print("%s 2  this is printed from inside" % __name__)
	if __name__ == "__main__":
        	print "executed when invoked"
	else:
        	print "Executed when imported"

	def test():
        	print ("the test func was called")

##### the import.py	
	import script
	print(__name__+" 1  this is being printed from outside")


	for i in range(1000000):
        	None
	print(script)
	print(type(script))

	script.test()

##### This generates a output
	
	Always executed
	script 2  this is printed from inside
	Executed when imported
	__main__ 1  this is being printed from outside
	<module 'script' from '/home/orean/Desktop/lpyHardway/script.pyc'> this 	is the script in retr format
	<type 'module'>
	the test func was called

##### The explation of the output. 

	When the import function calls script the interpreter run through it and 	the code is run
	prints ("Always Executed")
	Then the second prin statement is encountered and the __name__ has a val	value of script at this moment
	as __name__ variable has a value of script at this moment
	Executed when importted is printed
	and then the print line of import func is encountered
	which prints __main__ as name has a different value now as the main inst	ance is running
	now the time waste loop is encountered and time buffer is created
	next we print script in canonccal form which is the module is printed ou	t 
	next the we prin the type of script that is a module
	next we call the test function of script and the test function prints
	the test func was called
	
#### multi threading in python
	
	Thread are parallel process running at the same time on the machine.
	A process has three instance 
	>>> The executable program
	>>> The associate data 
	>>> the state of the executing program
	
	There is a thread control block  which keeps data about the thread
	
	>>> Thread indentifier
	>>> Stack pointer
	>>> Program counter
	>>> Thread State
	>>> Thread regsiter state
	>>> Parent process pointer

	at times it could happen that two threads are using the same resourc	    e which can cause a condition of racing and problems in the output
	unpredicted outputs. In such a scenario locks are induced. Locks can
	be either blocking or non blocking. When a blocking lock is called 
	it prevents other functions from acessing the resource util the lock is
	released. 
	<a href="https://www.geeksforgeeks.org/multithreading-python-set-1/">Read more here</a>	

### Terminologies
	class    ---  tell python to make a new kind of thing
	object   --- basic kind of thing, instance of something
	instance --- what you get when you tell to create a class
	def      --- to define a fucntion inside a class
	self     --- variable inside a class of the instance which is being acce		     ssed
	inheritnace --- concept one class can inherit traits from another class
	composition --- class can be formed from composition of other class
	attribute   --- properties classes have usually variables
	is-a        --- phrase to say something inherits from another, eg, salmo			n is-a fish
	has-a       --- something is composed of other thing, eg, salmon has-a m			outh

### classes in python
### When to use classes, when you want to create other with similar properties and variables
 
	class MyClass:
		x = 5
	
	//making object
	p1 = MyClass()
	print(p1.x)  //acessing the properties of class

	### __init__() function
	__init__() function is like the constructor in java and used to initiali	ze the variables. It is always executed when the class is initiated.
	
	class Person:
		def __init__(self, name, age):
			self.name = name
			self.age = age

		def myfucnc(self):
			print("Hello my name is" + self.name)

	p1 = Person("John", 36)
	p1.myfunc()

	### the self keyword is the refrence to the current instance of the clas	s you can name it anything. 


### The object in class dmystified

### Why to use object as inherited name while creating class
	python's originam redition of class was broken in many serious
	ways hence in oder to fix it they needed new class style which inherits
	from base class named object to make a class.
	
	class person(object):
		def __init__(self, name):
			self.name = name

	Pyhton 2 and earlier
		if you do not mention object then it will be old classes
		and if you mention object explicitly it will be new classes
		the improve done
	pyhton 3 
		you don't need to write it will explicitly inherit from object

	OLD MRO and new MRO alogorithm

		Old Classes			New Classes
		
		class A:                      class A(object):
		  pass                           pass
		class B:                      class B(object):
		  pass                           pass
		class C(A, B):
		  pass
	
	dosen't inherit from python        First parent inherits from python
        root objeect class                 root object class
	
	uses the old MRO algo              uses new mro algorithm
	                                    
                                           introduced in pyhton 2.3

	The old mro was monotonic that is the mro of subclass were extensio of the 
	mros of the superclass without re-odering

	the old mro is based on DLR deep first from, left to right. The new mro is 
	based on c3serialization algorithm 

### functions as first class objects

	Everything in python is an object, including functiions. hence function 	can
	>> have types
	>> can be sent as arguments to another function
	>> can be used in expression
	>> can become part of various data structures like dictonaries

	### sending as arguments to another function

	def apply(L, F)
		result = []
		for i in range(len(L)):
			result.append(f(L[i]))
		
		return result

	L = [1, -2, -5, 6.3]
	print apply(L, abs)
	# [1, 2, 5, 6.3]

	### Function as elements of a list

	def apply_func(L, X):
		result = []
		for f in L:
			result.append(f(x))
		return result

	function_list = [abs, exp, int]
	print apply_func(function_list, -2.3)
	# [2.3, 0.10025884, -2]


	### functions can be assigned to other variables
	
	i = abs
	print(i(-2))
	# 2
	
	### objects as functions

	this can be done by defining a call function inside the object
	
	class Printer:
		def __init__(self, s):
			self.string = s

		def __call__(self):
			print(self.string)

	s1 = Printer("hello") #defining the object
	# calling object s1
	s1() # Hello
	
	<a href="https://medium.com/python-pandemonium/function-as-objects-in-python-d5215e6d1b0d">link source </a>


### self keyword
	The self keyword is used to create a dummy(temporary) instance of object 	and then innitialize it to the created object. It is also used to assign 	values to variables.
	
	why do we need self when we have __init__
	cheese = 'Frank' is ambiguous weahter you mean the local variable cheese
	or instance of cheese. self.cheese = 'Frank' makes it clear that its a i	instance atribute

### playing with self
	the self keyword takes the insatnce of object which is being created at 	that moment
	test1 = Test()
	test2 = Test()
	when these two objects are created of Test class the self in first will have test1 while i	  n second test2 as reference. 

	Take a look at the below code 

	class test():
		def __init__(self, word):
			self.word = word
			print(self)
			print(dir(self)
			print(self.word)

	test1 = test("a test")
	test2 = test("another tets")

	this produces an output
 
	<__main__.test instance at 0x7f3a22ae3680>
	['__doc__', '__init__', '__module__', 'word']
	a test
	<__main__.test instance at 0x7f3a22ae36c8>
	['__doc__', '__init__', '__module__', 'word']
	another test

### Inheritance in python
	
	class Person:
		def __init__(self, fname, lname):
			self.firstname = fname
			self.lastname = lname

		def printname(self):	
			print (self.firstname, self.lastname)

	class Student(Person):
		def __init__(self, fname, lname):
			person.__init__(self, fname, lname)

	x = Student("john", 'doe")
	x.printname()

	inheritance indicates that one class will get most or all of its features from parent class
	There are noramly three ways in which parent and child class can interact
		> Action on child imply an action on parent
			
			class parent(object):
				def implicit(self):
					print "parent implicit()"
	
			class Child(Parent):
				pass

			dad = Parent()
			son = Child()
	
			dad.implicit()
			son.implicit()

			#parent implicit()
			#parent implicit()
		
		> Actions on the child override the action on the parent

			class Parent(object):
				def ovveride(self):
					print "PARENT override()"
			
			class Child(Parent):
				def override(self):
					print "CHILD ovveride()"

			dad = Parent()
			son = Child()
	
			dad.override()
			son.override()

			# PARENT override()
			# CHILD override()
				
					

		> Actions on the child alter the action on the parent

			class Parent(object):
				def altered(self):
					print "PARENT altered()"
			
			class Child(Parent):
	
				def altered(self):
					print "CHILD BEOFRE PARENT altered()"
					super(Child, slef).altered()
					print "CHILD, AFTER PARENT altered()"
		
			dad = Parent()
			son = Child()
	
			dad.altered()
			son.altered()
		
			# PARENT altered()
			CHILD, BEFORE PARENT altered()
			PARENT altered()
			CHILD, AFTER PARENT altered()


	Now you will see composition and inheritane in action and try to understand the difference
	between the two futher explaintion will be given at the end of the code.
	
	class Parent(object)
		
		def override(self):
			print "PARENT override()"
		
		def implicit(self):
			print "PARENT implicit()"

		def altered(self):
			print "PARENT altered()"

	class Child(Parents):
		
		def override(self):	
			print "CHILD override()"
		
		def altered(self):
			print "CHILD, BEFORE PARENT altered()"
			super(Child, self).altered()
			print "CHILD, AFTER PARENT altered()"

		dad = Parent()
		son = Child()

		dad.implicit()
		son.implicit()
	
		dad.override()
		son.override()
	
		dad.altered()
		son.altered()
	
	this produces an output
		PARENT implicit()
		PARENT implicit()
		PARENT override()
		CHILD override()
		PARENT altered()
		CHILD, BEFORE PARENT altered()
		PARENT altered()
		CHILD, AFTER PARENT altered()

	Now see the same thing being implemented using Composition
		
		Class Other(object):
			
			def override(self):
				print "OTHER override()"
			
			def implicit(self):
				print "OTHER implicit()"
			
			def altered(self):
				print "OTHER altered()"
		
		Class Child(object):
			
			def __init__(self):
				self.other = Other()

			def implicit(self):
				self.other.implicit()
	
			def override(self):
				print "CHILD override()"
	
			def altered(self)
				print "CHILD, BEFORE OTHER altered()"
				self.other.altered()
				print "CHILD, AFTER OTHER altered()"

		son = Child()

		son.implicit()
		son.override()
		son.altered()

	this produces an output
		OTHER implicit()
		CHILD override()
		CHILD, BEOFRE OTHER altered()
		OTHER, altered()
		CHILD, AFTER OTHER altered() 
	
	Note that in composition you have rewrite all the function name unlike inheritance where
	you don't need to mention the parent class functions unless you want to overide it.
	Composition is used when you need to package up code into modules that are used in many 
	different unrelated places and situations.


### Dealing with classes and object design
	
	write or draw about plroblem
	extract key concepts from 1
	create class hierarchy and object map of concepts
	code the classes and a test to run them
	repeat and refine

### Build in functions in python 


### Property keyword in python
	The property keyword is used in classes modifcation in such a manner that 
	if the class needs to be updated for further requirements. The multiple users 
	who have inherited from the class need not to make cahnges in the code 
	that they are using at the present moment.
	





	
