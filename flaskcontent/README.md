### Falk restfull
	using fields module.
	this alllows us to use whatever objects(ORM models/custom classes/etc) y	you want in your resource. You can filter the response so that you dont
	have to worry about exposing the internal data structure.

	You can define a dict such that the keys are the names of attribute 
	or the keys on the object to render, and whose values are the clases
	which will format and return the value for that field. 
