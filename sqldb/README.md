# logging into mysql console
	
	mysql -u root -p
	enter the mysql password
	
	stopping the mysql server
	service mysqld st
# Sql terminal commands

## Initial db and table creation

	-- comment <, >, <=, >=, =, <>, AND, OR
		-- is how you comment in sql 

	show databases;
		to show all databases

	create database labs;
		to create a database called labs;

	use labs;
		to use that databse;

	CREATE TABLE student (
		student_id INT PRIMARY KEY,
		name VARCHAR(20) NOT NULL,
		major VARCHAR(20) UNIQUE
	);
		to create a table name student with those column fields

## Insertion and upadations

	insert into user (username, phone, adress, city, country) 
	values ('orean', '89808020', 'albama 32', 'albama', 'USA');
		to create an entry int the table
	
	UPDATE student set major = 'Bio' WHERE major = 'Biology';
		change the major value to Bio which has Biology as value
	
	UPDATE student set major = 'Biochemistry' WHERE major = 'Bio' OR major = 'chemistry';
		you can also use or to check multiple thing	
			
	ALTER TABLE student ADD gpa DECIMAL(3, 2);
		to alter a present table and add a new column(decimal) field to it.

	update user set password_hash = 'value';
		updates a row entry in datatbase

## Selecting certain data or displaying data
	
	DESCRIBE student;
		to get the detailed view of table 

	show tables;
		to show all tables in the database

	show columns from user;
		to show all columns of the user table;	
	
	select * from tablename;
		show all entries in an table
	
	SELECT name, major FROM student;
		selects name and major columns from student.

	SELECT name, major FROM student ORDER BY name;
		selects name and major and orders them by name ascending.

	SELECT * FROM student WHERE major = 'Chemistry';
		selects all student with major as Chemistry

	select first_name as forename, last_name as surname from employee limit 5;
		selects first five first_name and last_name and displays them as forename and
		surname

	SELECT DISTINCT sex FROM employee;
		selects different type of sex from employees 

## Deleting and drop functions 

	DELETE FROM student WHERE student_id = 5;
		Delete from student table where student_id meets the condition.
	
	drop database databasename;
		deletes a database completely

### SQL functions
	
	SELECT COUNT(emp_id) FROM employee;
		returns the number of emp_id in employee

	SELECT AVG(salary) FROM employee;
		returns the avegare of all employee salary

	SELECT COUNT(sex), sex FROM employee GROUP BY sex;
		groups the number of emplyees by M or F or other sex if you have provided

	SELECT * FROM client WHERE client_name LIKE '%school%'
		all client name that have school in there name

### SQL Wildcards
		
	wild cards are something similar to regex 
	% = any number of characters
	_ = one charatcer

	SELECT * FROM client WHERE client_name LIKE '%LLC';
		selects the company whose name ends with LLC
	
	select * from employee where birth_day like '____-10%';
		get people born in october.
	

### some special sql keywords
	
	UNION
	is used to club up two sql satatements together their are some constarints like
	both statmenet should return same number of column and the data type should be same.
	
	SELECT client_name FROM client UNION SELECT supplier_name FROM branch_supplier;

	JOIN
	this is used to query two tables which share a common cloumn field and can be made 
	to return certain values based on these qualities for example mangers of  a certain 
	branch. There are two tables one branch and other employee the branch table has manr_id
	as one column which is a foreign key mapping to employee id.

	SELECT employee.emp_id, employee.first_name, branch.branch_name FROM employee
	JOIN branch ON employee.emp_id = branch.mgr_id;

	There are 
	FULL JOIN
	RIGHT JOIN
	LEFT JOIN

### Nested Queries	
	queries can be nested to get the desired query
	
	SELECT employee.first_name, employee.last_name
	FROM employee
	WHERE employee.emp_id IN (
		SELECT works_with.emp_id
		FROM works_with
		WHERE works_with.total_sales > 3000
	);

	SELECT client.client_name 
	FROM client
	WHERE client.branch_id = (
		SELECT branch.branch_id
		FROM branch
		WHERE branch.mgr_id = 102
		LIMIT 1
	);

### ON DELETE
	considera situation where you delete an entry in one of the tables and there are other
	entries in other tables linked as foreign key to eariler table Now what will have to 
	the entires in those reference.
	
	On DELETE SET NULL
		Set the reference to NULL
	ON DELETE CASCADE
		Delete the references  

### Triggers
	triggers are certain actions to be performed when certain conditions are met
	
	DELIMITER $$
	CREATE
		TRIGGER my_tigger BEFORE INSERT
		ON employee
		FOR EACH ROW BEGIN
			INSERT INTO trigger_test VALUES('added new employee');
		END$$
	DELIMITER ;
	
	Every time a entry is made into the employee table the added new employee will be
	added to the trigger_test table. Also the deliminiter need to be changed and rechanged 
	for complete execution of command.
	
	DELIMITER $$
	CREATE
		TRIGGER my_tigger1 BEFORE INSERT
		ON employee
		FOR EACH ROW BEGIN
			INSERT INTO trigger_test VALUES(NEW.first_name);
		END$$
	DELIMITER ;

	DELIMITER $$
	CREATE
		TRIGGER my_trigger2 BEFORE INSERT
		ON employee
		FOR EACH ROW BEGIN
			IF NEW.sex = 'M' THEN
				INSERT INTO trigger_test VALUES("added male employee");
			ELSEIF NEW.sex = 'F' THEN
				INSERT INTO trigger_test VALUES('added female');
			ELSE
				INSERT INTO trigger_test VALUES('added other employee');
			END if;
		END$$
	trigger for update, delete, etc can be created 

### Enitity relationship diagram..

## Relational Database designing

### Things to consider while data base design

	 > Entity
		users, machine, cities etc..(info about which we are storing)
	 > Attribute 
		name, email, phone (for user.. The data that we store about a entity)
	 > Tuple 
		an entry in the table
	
	 > Data Integrity
	   	> Entity integrity (unique entries or a field to uniquiely identify two enties with
		  same data)
		> Referential integrity (integrity of references to other table, like a comment 
		  should have a user)
		> Domain integrity (data type and size)
	
	> Atomicity
		store only one thing, like first name, last name, instead of name that is one 
		column to store one value

	> Relationship 
	(That is how the data flows among tables and how are they interelated for data transfer)
	  ## Binary relationships

		> one to one
		> one to many 
		> many to many(they dont work in a relational database)

	>> Creating an one to one relationship
		to create an one to one relationship between two tables.. you store the unique id
		of one as the foreigin key in another and vice versa
	
		user              parent
	      ________          ________
		u_id              P_id
		name              name
		email             phone
                p-id(as fk)       u_id(as fk)

		foreign key being used to create an one to one to relationship

	>> creating an one to many relationship
		to create an one to many relationship the (multiple)qunatity which can be related
		or traced back to one quntity stores the unique id of the parent attribute as 
		foregin key. The child will always have the foreign key
	
		user             comment
	      ________		_________
		name		  c_id
		email		  date
		u_id              detail
			          u_id(as fk)

	>> creating many to many relationship
		take an example pf student and class. A student can take mutiple class and a clas
		can have multiple student so how would this be implemented. In a database schema
		To implement a many to many relationship an intermediate table is used. This 
		intermidiate table is known as junction table. This is done by 1:M and then M:1
		mapping that is one to many and then many to one.

		class             class_id   student_id            student              
	      ___________        ________________________         _________
	        63 math              75         8                   john 8
	        75 science           89         8                   jake 17
                81 english           75         16                  sally 16
                  						    claire 6

### Lookup Table
	Let us assume we have to keep in consideration weather a new user is of gold, platinum
	diamond, bronze etc membership. So one way is to create a seprate lookup table and link
	link there or other way is to fill the data in the table which you have username or other
	stuff. Now if you have seprate lookup table it gives you flexibility of updating at 
	one place or adding further to features. Whereas if you kept it int same table there
	would have been repetitive data

### keys
	super Key
		Any number of columns which create a unique entry index(only for desiging purpose)
		
	Candiate Key
		Minimum number of columns which create unique entry 

	primary Key
	  >> surogate key
		category of primary key which has no real world	significance like user_id
	 	(self incrimenting)
	  >> natural key
		category of primary key which has some real world significance like username
	
	Foregin Key
		When you reference the primary key of one table in another table it is foregin
		key binding. These relationship help us mantain data. It can be set to not 
		nullable. Assume a case where a comment is created with user_id which does 
		not exists or without a user_id, which is not possible in real world.
		These kind of disperency can be removed using foreign key
	
	  Constraints on FK
	    
	    ON DELETE	
	    ON UPDATE
	      These refer to the parent

	    RESTRICT (this prevents the actiion and throw the error)
	    CASCADE  (if deleted the FK row refrenced is also deleted, that is same action is 
 	              taken for the reference)
	    SET NULL (sets that column in refrence to NULL, no the complete row)


### Things with key 
	>> unique
	>> never changing
	>> never Null
	(this is more about specificaly primary key)

### normalization function 
	Steps That you take to improve the database  	
	  
	  >> number1function (make everything atomic)
	  >> number2function (Remove the partial dependency)
	  >> number3function (Remove the trainsitive dependency)

	Transitive depepndency is a dependency in the databse an indirect relationship between
	values in the same table that causes a functiontional dependency. 
	something like column A in a table relies on Column B through an intermedite column C.

### Cardinality
	reltionship between row one and row of another table, kind of relationship which
	happen in database is called cardinality
		one to one (nullable) / one to zero	
		one to one (not nullable)
		one to many (nulllabe)
		one to many(not nullable)

### Joins
	These are statements which are used to collect data from multiple tables and present
	them in a required format

	   User                   comments
      ______________          ____________________
       u_id   name              u_id     comment
	7     jane               7        lol
	8     kobe               7        haha
                                 8        dman!


       join will produce

		name          comment
	       jane             lol
               jane             haha
	       kobe             damn!

	That is an inner join/left join on u_id betwen user and comments table

	Inner Join
		It works as intersection of sets, it will take those rows which have 
		entries in both table that is if select customer_id only those rows will
		be selected which have values for customer_id in both table

	Outer Join
	  Left Join
		Returns everthying from left side and only the rows related on right side
	  Right Join
		same as left only this time all of right is returned
	  Full outer'
	
	Self Join
		That is a join with the same table, take the example of referal system we
		we may have table in below format
	
		user_id  name  email  referal_key
                                         FK to User_id

	 	Now if we want to return a table in which we have a column of name and refred
	 	by should have name of refree rather than the user_id we can we use a self join
	 	we need to use an alias to make the implementation possible.

		SELECT u1.fn, u1.ln, u1.email, u2.email FROM user AS v1 JOIN
		user as v2 ON v1.ref_id = v2.user_id

## SQLAlchemy ORM
	The SQLAlchemy interacts with the database using the session object. Session object 
	wraps the database connection and transaction. Transaction implicitly starts as soon
	as the session starts communicating with database and will remsin open untill session
	is commited, rolled back or closed.

## Lazy load
	When loading data from a database into memory it's handy to design things so that you load
	an object of intrest and also the objects realated to it. This might come handy at time 
	but can also become cubersome and time consuming. So an object with the same interface 
	with the original is loaded which fields can contain value(real) or be empty and contain 
	a marker to to getValue to get value from real object. This saves time and can create a 
	win win situation if certain fileds which are not loaded are never accessed. That's lazy 
	loading.
