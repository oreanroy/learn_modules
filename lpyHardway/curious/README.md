# The mystery of os.path function solved
	TEMPLATE_DIR = os.path.join(os.path.dirname(__file__), "templates")
	print(TEMPLATE_DIR)
	print(__file__)


	The __file__ variable is a pre shipped varibale which is the path of python file api.y
	from home dir.
	The os.path.dirname(__file__) just strips of the name of the file and returns the dir 		in 
	which the file is staying. now we goin the templates path to git 

	See the below output to get a clearer outlook

	/home/orean/Desktop/prodcode/terminal-proxy/parserlabs/templates
	/home/orean/Desktop/prodcode/terminal-proxy/parserlabs/api.py



# Static methods in python 
	These are method of class and can be accesed without creating an object of the class
	Integres and other variables can also be declared static. Means the same they are 
	properties of class.


# soft and deep copy in python 
	the soft and deep copy are both part of the copy module of pyhton you can use it
	by importing copy module. 
	The differencere
	when we deep copy it creates a seprate reference of the same object and recursively
	copies the content to the new instance created.
	when using deep copying it the new copy is refrenced to the same object hence
	any changes made in the copined object all reflects on the original enough of talk 
	now look at the code
	
