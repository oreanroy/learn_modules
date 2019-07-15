>> pip + easy install
>> Rest Api
>> API framework
>> Flask
>> Web Sockets
>> Falsk sockets

(virtaul env) >> prevents it from 
files to create in project
Requirements.txt

>>  REst apis
	>> crud is based on database
		>> C = Put
		>> R = GEt (R,U,D operation require obejectid)
		>> U = Post
		>> D = Del
			>> /<ID> R,U,D are the same end points with different headers
 
		>> The other four are used for controlling mechanism
			>> header (can be used to pass the authentication key, as we do not 
			mantain the session in rest api)
			>> options (what method are allowed on the endpoint)
			>> 
			#
	>> Rest is based on HTTP


## task create a crud application in flask
## create two methods in one allow all functions in other dont allow aall
## test the authentication in 
## read about web sockets 
## create a terminal to talk to terminal using websockets

>> runing a flask app bundled as a package
	>> run  pyhton setup.py install
	>> run entry point file eg, python parserlabs/api.py
	>> devlop the app db by running python setup.py develop
	>> propbaly install the db client eg apt-get install mysql-server
	>> run the app through entry point
	

