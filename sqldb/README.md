# logging into mysql console
	
	mysql -u root -p
	enter the mysql password
	
	stopping the mysql server
	service mysqld st
# Sql terminal commands

	show databases;
		to show all databases
	 user labs;
		the table name
	show tables;
		to show all tables in the database
	show columns from user;
		to show all columns of the user table;
	
	insert into user (username, phone, adress, city, country)
	values ('orean', '89808020', 'albama 32', 'albama', 'USA');
		to create an entry int the table

	drop database databasename;
		deletes a database completely

	update user set password_hash = 'value';
		updates a row entry in datatbase
	
	select * from tablename;
		show all entries in an table


## SQLAlchemy ORM
	The SQLAlchemy interacts with the database using the session object. Session object 
	wraps the database connection and transaction. Transaction implicitly starts as soon
	as the session starts communicating with database and will remsin open untill session
	is commited, rolled back or closed.
