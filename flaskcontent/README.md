### Falk restfull
	using fields module.
	this alllows us to use whatever objects(ORM models/custom classes/etc) y	you want in your resource. You can filter the response so that you dont
	have to worry about exposing the internal data structure.

	You can define a dict such that the keys are the names of attribute 
	or the keys on the object to render, and whose values are the clases
	which will format and return the value for that field. 


### flask basic auth
	
	the basic auth works in this manner. The user hits a login/verify endpoint with username and
	password. The server verifies this password and replies back with a token. This token 
	can be used to acess resources which are authentication protected. you will have to reply
	back with this token in header. The server will verify if this token exists and then alow
	access to resource.

	the authentication header looks like
	GET /user/1 HTTP/1.1
	Host: 127.0.0.1:5000
	Content-Type: application/x-www-form-urlencoded
	token: eyJhbGciOiJIUzUxMiIsImV4cCI6MTU2MzUxMTM4NCwiaWF0IjoxNTYzNTEwNzg0fQ.eyJpZCI6MX0.Syct_C8x4PD8d-4VJeiqxAWv-X_PTbrV6JzJTZgjryNp9P-UrZYUQYyhzNoVulbtfJZcMPJL71VhRiQjHcj5jg
	Authorization: Bearer eyJhbGciOiJIUzUxMiIsImV4cCI6MTU2MzUxMTM4NCwiaWF0IjoxNTYzNTEwNzg0fQ.eyJpZCI6MX0.Syct_C8x4PD8d-4VJeiqxAWv-X_PTbrV6JzJTZgjryNp9P-UrZYUQYyhzNoVulbtfJZcMPJL71VhRiQjHcj5jg
	cache-control: no-cache
	Postman-Token: f964a508-5754-491a-829f-7e5c401d21dc
	token=eyJhbGciOiJIUzUxMiIsImV4cCI6MTU2MzUxMTM4NCwiaWF0IjoxNTYzNTEwNzg0fQ.eyJpZCI6MX0.Syct_C8x4PD8d-4VJeiqxAWv-X_PTbrV6JzJTZgjryNp9P-UrZYUQYyhzNoVulbtfJZcMPJL71VhRiQjHcj5jgundefined=undefined


### flask-restful request parsing

	Flask restful request parisng interface, reparse, is designed to provide simple
	and uniform access to any variable on the flask.request object in Flask.
	That is we can access the different varibales, form data, cookies, header etc
	other things which are passed by the user.
	
	from flask_restful import reqparse

	parser = reqparse.RequestParser() //creating an instance of request parser 
	parser.add_argument('rate', type=int, help='rate cannot be converted') //rate 
	parser.add_argument('name')
	args = parser.parse_args()//parsing the request

	now you can access the values 
	
	args['rate'] # 56
	
	For further understanding the different options availble in this package 
	check this out https://flask-restful.readthedocs.io/en/0.3.5/reqparse.html 



	
