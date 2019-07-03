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


### classes in python 
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
