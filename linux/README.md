## File sysytem hierearchy of linux

   bin
	This stores the basic binaries like ls, cat etc..

   sbin
	This contains the sytem binaries which a system admin would need while running as root

   boot
	this contains the bootloader and other files needed for boot

   dev 
        this is where the files related to devices live that is files needed to run the laptop
        the webcam etc. This will be usualy accessed by drivers etc

   /etc
        this folder contains all the configuration settings. settings of system wide 
        applications

   lib, lib32, lib64
        they contain the libraries needed by different programs. This would be accessed by
	programs runing from bin, sbin.

   media, mnt 
	These are where you find other mounted devices, flopy, usbstick
        mnt is for manualy mounting while media is manged by the os automaticaly

   opt/
        manualy installed software from vendors reside, you can put software you have created
	yourself.

   /proc
	pseudo files contains information about processes, information on cpu.

	cat /proc/cpuinfo

   /root
	this is the root user home folder..location of root is such that it has access to 
	other user home folder
  
   /run
	it is at tmpfs file system that means it contains files that run in the ram
	everything stored in it is gone once the system is shutdown
  
   /snap
	usualy used by ubuntu, snap packages run differently than regular pacakages and
	applications

   /srv 
	this is the service folder which is empty initaly and is populated when you run a 
	server and has files which are accessible by external user. It is at the root 
	
   /sys
	the sytem folder it is the way to interact with the kernel this is similar to 
	run directory annd not written to the disk and is created every time the system
	boot

   /tmp
	this is where files are stored by application that could be used during a session
	take an example you are writing a word document a temperary copy of the file would
	be stored in the folder just in case the application crashes so the application 
	can look here for copies on rerun..these files are normally cleared on rerun

   /usr
	this is the user application bay where applications installed by user will be 
        insatalled any apllication insatlled here will not be considered esential 
	for proper functioning of linux system.
	The libraries of these application will be installed in the lib folder.
	large programs will get installed in user share
	installed source code will go into src folder
        

   /var 
	the variable directory.'
	It contains files and directories that are expected to grow in size
	example var/crash contains info about the process that have crashed
	Temporary storage for printer queues also known as spool

   /home 
	Each user has his own folder, inside each user stores its own personal folder
	and they can only view there own folders unless using admin permission

## Concept of Deamon

	A dameon is a background process/service that is designed to run autonomously, with
	little or no user intervention. Theses process have names ending wiht d postfix like
	the httpd process

## Some commands

### grep
	grep stands for global regular expression and print, it looks for patterns of text in
	a file and prints them, grep uses posix regular exp

	$ grep "jane williams" names.txt

	above it searches foe jane williams in names.txt or similar pattern matching text
	to make it explicitly look for the same text we can use -w 

	$ grep -w "jane williams" names.txt

	grep is case sensitive, we can by pass that by using the -i 

	$ grep -wi "jane williams" names.txt

	if we use the -in it will also give the line number where it finds the text

	$ grep -win -B 4 "John willimas" names.txt

	This will also return the four lines before the match

	grep -winr "jane williams" ./

	This will recursively search everything inside the directory.

#### pipping will other commands

	$ history | grep "git commit"

	this will give out all commands which involved git commit in them

	$ history | grep "git commit" | grep "dotfile"
	
	this taken in only the git commit commands and then takes out oly the one 
	involving dotfile in them

#### using it with regular expressions
		
	$ grep "..._..._...." names.txt
	
	this maches phone number that is thre character then a _ then again three character

### env
	This will display the environment variables 

### unset
	To unset a environment variable 

### Comands to monitor process

#### top
	This lists all the running process and their sysytem usage 

#### ps and pstree
	This lists all the running process, while the tree prfix lists them in
	tree structure

	


