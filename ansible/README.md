can run commands on multiple machines through ansible..

4 function
 	>> Change manageent
	>> Provisoning
	>> Automation
	>> Ochestraion


> Change Management 
	ensure a system satate, brings sysytem to a predefined 
	state, 
	IDEMPOTENT system is in the required state so 
	ansible will not apply any modifications

> Provisoning 
	Trasioning from system state to other system state
	removes corupted files if any that came from the 
	virtual image that is distributed to other machines
	
	take example of provisioning a webserver ansible
	will follow these steps
	>> install web software
	>> copy configuartions
	>> copy web files
	>> install security updates
	>> start web service

> Automation
	Define task to be executed automatically
	odered tasks
	make decison
	ad-hoc tasks
	
	can run a task on mutilple machines through playbooks 
  
> orchestraion

	Automation is execution of task within a single system 
	wheras orchestraion is making sure the system are 
	automation runs in a syncronised manner as in 
	a orchestra. Like the database server need to 
	be updated before the api server and similarly '
	the fornt end server or app server need to be updated
 	after the api server.


> Why use ansible

	>> Its clean
		>> No agents
		>> No databse
		>> No residual software 
		>> no complex upgrades
	>> Its extendable
		>> URL/RESTful calls(can be used to acess
		an existing manageemnt system)  
		shell comands and scripts can be launched
		from ansible
		((check out ansible galaxy for more info ))     
		

> YAML
	its a way to write the automation and playbooks

> Built-in Security 
	Usees SSH
	Root/Sudo usage is built in
	Encrypted vault ( you dont need a private key 
	infrastructure you can store the passwords and
	other important data in encrypted format) 


>> hands on ansible 

	create a file with host names(host01 ansible_ssh_user=ubuntu)
		> echo "host01 ansible_ssh_user=ubuntu" >> myhosts
		// adding host name to myhosts
	Running fist command on host machine
		> ansible group1 -i myhosts -m command -a date
		// getting the real time date and time of host machine
	Running a playbook on ansible 
		> ansible-playbook -i myhosts
	
@ Sidana Sir session two
	the developers were fast where as system admin were
	slow as they have update multiple machines and 
	keep back up of each machine

	palybook(commads)
	inventory (ip adress to all servers)
		>> inventory file fromat
			[server]
			10.0.0.1
			10.0.0.2
			10.0.0.3

			[client]
			10.0.0.4
			10.0.0.5
			
			[libarary]
			10.0.0.1
			10.0.0.2
			10.0.0.3
			10.0.0.4

			Application:
			Libarary
			server - apache, chrome, abc
			client - pip, python2.7, net-tools
			library - xyz, def, etc.

	Yaml synatx
 		apt/yam pkg manager can be configured by ansible
		depednding upon the os of the host machines


	1: Write an ansible playbook to take backup of /etc folder as /etc.back
	2: Write an ansible playbook to copy a text file into VM2 and VM3
	3. Write an ansible playbook to execute `ls -l /proc` on VM2-3
	 and get the output in VM1
	

	>>machines created
		>> machine1
			>>ghostpc1
			>>host ghostpc1
			>>user ghostpc1user
			>> password 24379811512437
		>> machine2
			>>ghostpc2
			>>host ghostpc2
			>>user ghostpc2user
			>> password 2437@orean
ansible playbook to take backup of /etc folder as /etc.back

Session 2 Manik sir

>> handlers
>> loops
>> conditionals/Register
>> tags
>> vars
>> Rolses

## handlers 
	Called by other tasks
	install nginix and then restart
	modify a configuration file(you will have to restart it)
## Loops
	- name: Ansible Loop example
	  apt:
	    name: "{{ item }}"
	    state: present
	  with_items:
	     - python3
             - ca-cerificates
 	     - git
//Ansible facts read about it
## conditional/Register
	-yum:
	  name: httpd
	  state: latest
	when: ansible_os_family == "RedHat"
//conditional based on ansible facts and other on a output

## Ansible tags
Used for group similar tasks

- hosts: localhost
  connection: local
  tasks:
    - name: display

ansible-playbook -i hosts playbook.yml --tags=bar 


## Roles
something similar to function they group a set of related 
task can be shared among team members (reusable)

## Directory Structure
ROLE: files handlers meta templates tasks vars
files/: Files/Scripts/Python executable etc that need to be
copied to target machines
handlers/: 
meta/: metadata about the role
template/: Configuration templates
tasks/: YML file(main.yml) that defines the tasks to be executed
vars/: variables that are used by the role
Defaults/: DDefaut variables that would be used 
//the meta data can be fetched from mutiple machines



## Distributed systems 
	There are certain things to ke kept in mind when implementing
	a distributed syste.
	CAP theorem
	>> c=consistency (all systems have the same data)
	>> A=Availibility (every requets gets a response)
	>> p=partition Tolerance (system responds even when some server fail)

	### To maintain a distributed system a concensus algorithm must be followed
	concensus algo must satify these things
	>> validity (a valid system porposed a value)
	>> agreement (all corect process must agree on same value)
	>> termination (correct process must terminate after finite number of steps)
	>> Integrity (if all correct process decide on the same value
		then the process has the said value)

## RAFT Consensus Algorithm
	>>Leader election
		--select one server to act as leader
		--Detect crashes, choose new leader
	>>Log replication
		--Leader accepts commmands from client, appends
		  to its log
		-- Leader replicates its log to other servers(overwrites inconsistencies)
	>>Safey
		-- keeps logs consistent
		-- Only servers with up-to-date logs can become leader

	
	The server can remain in three different states that is
		-- Follower
		-- candidate
		-- Leader
 
	Leader is the one which everyone follows
		> A leader is selected when one of the server 
		  times out 
		> A leader is also selected if the present leader
		  dies
			### The way to select a leader
			the cadidate which timed out sends
			a signal to all servers for polling 
			if it aquires enough votes it is selected
			as the leader or another one sends a polling 
			request.
			
			### There are ways to make sure two different 
			servers are not selected as leader at the same
			time. One of the ways is to select the one which 
			has most updated terms and logs

			### Another way is to count number of votes
			
			### A leader needs to keep on sending heart beat
			signals to other nodes to maintain its superamacy

	### Log manipulation in the leaders logs 
		The client sends the requets to leader and then the leader
		broadcasts it all the servers if the ample number of followers 
		make a entry in their logs. The leader commits it into its own log
		a log entry genrally consists of three information
		command(specified by client to execute)
		index(to identify the position of entry in the log)
		Term Number( to asertain time of entry of command)

	### Log inconcentancy maintainance
		
		if there is a inconcentancy in the log of the follower
		the leader sends past records along with the new uptill 
		the point where the logs start to match. If the follower 
		has a log with latest term it is appointed as the leader
		
		
		
		

 

			

			





