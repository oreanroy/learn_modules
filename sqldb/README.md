# logging into mysql console
	
	mysql -u root -p
	enter the mysql password
	
	stopping the mysql server
	service mysqld st
# Sql terminal commands

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

	UPDATE student set major = 'Bio' WHERE major = 'Biology';
		change the major value to Bio which has Biology as value
	
	UPDATE student set major = 'Biochemistry' WHERE major = 'Bio' OR major = 'chemistry';
		you can also use or to check multiple thing	
			
	ALTER TABLE student ADD gpa DECIMAL(3, 2);
		to alter a present table and add a new column(decimal) field to it.

	DESCRIBE student;
		to get the detailed view of table 

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

	DELETE FROM student WHERE student_id = 5;
		Delete from student table where student_id meets the condition.

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
