## What is Docker
   
   Docker is a containerization tool 

## How does it work

## intalling docker

## What is container

## what is image

## Running your first container
	docker run container name
	  This runs the container 

	docker run -d container name
	  This runs the container in detached mode that is it runs in the background and
	  the terminal is open for taking other commands

	docker run -d -p 8081:8080 -e env_val="bash" container tag/id
	  This runs the container in detached mode also forwards the trafiic from host
	  port 8081 to 8080 of the container it also sets a enviroment variable e using 
	  the -e prefix.


## Docker commands on container

	docker stop container name/ id
	  This stops the running container 
	
	docker rmi image tag
	  This removes the container completely

## Docker commands on image

## Building your first container

### Dcoker build command
	The build command is used to create a docker image from a docker file
### Docker onbuild command
	The on build command is used to postpond the execution of certian command
	and are executed when a new image is created taking the initial image where
	the onbuild was used as a base image.

### Preventing certain files from being added to image
	User .dockerignore file
	it is something similar to .gitinore add the file or directory which needs to 
	ignored 

## Docker compose files 

## Docker Engine

## Docker storage

### Storing data in the host 
	you can store data in a directory in the host usig the volume command
	
	-v <host-dir>:<container-dir>

### data containers
	You can also configure some containers as data containers and store data into them
	these can be referenced whwn required

	create such container

	  docker create -v /config --name dataContainer busybox
	The -v option tells where other containers will be storing data

	copying files into such container
	  docker cp config.conf dataContainer:/config/

	You can mount voulumes from this container to other container when you create 
	the new container 
	  dcoker run --volumes-from dataContainer ubuntu ls /config
	
	We can also export the data container as a tar file 
	  dcoker export dataContainer > dataContainer.tar

	which can be reimported to docker by
	  docker import dataContainer.tar

	

## Docker Networking

	When docker is installed it creates three network by default
	> Bridge
		Every container created gets attached to this network by default
		docker run ubuntu
		containers get a .17 series ip, 172.17.0.2 172.17.0.3 meanwhile docker
		runs on 172.17.0.1
	> None 
		docker run ubuntu --network=none
		Would not be accessible outside they run in an isolated environment
	> Host
		docker run ubuntu --network=host
		This removes the isolation and you would not require port mapping, that the
		services running on a port in docker would be accessible on the same port on
		the host machine 

### creating own internal network

	By default docker created only one bridge network that is the 172.17.0 series ip
	you can create a seprate bridge by using network create command

	docker network create \
	    --driver bridge \
            --subnet 182.18.0.0/16
	    custom-isolated-network

### Embedded DNS
	Assume you have a database server running on 172.17.0.3 and a webserver running
	on 172.17.0.2 both on the same bridge network now how will you connect the webserver
	to db one way is through the ip adress
	mysql-connect(172.17.0.3) but the ip can change once you reboot
	
	docker has an internal DNS server running at 127.0.0.11 so you can connect to 
	containers using the name

## Docker Registry
	Docker Registry are the collections from where you get docker images, that is the 
	cloud from where docker images are pulled

	When you try to run docker run ngnix , ngnix is the image name docker will look
	into the local images and then pull it from cloud if not found 
	it will prefix ngnix  to it making it "ngnix/ngnix"  where first ngnix is username
	while the next one is image name. It happens when you dont provide the accouname
	it will assume it to be same as image name

	and further it will add docker.io to it makin git "docker.io/ngnix/ngnix"

### deploy a private registery
	To create a private local registry follow these steps
	You will have to use docker registry which itself is a docker image and runs on
	port 5000
	
	docker run -d -p 5000:5000 --name registry registry:2
	now you can push to this private registry, pull and give access within your org

	  docker image tag my-image localhost:5000/my-image

	  docker push localhost:5000/my-image

### Run an image from priavte repository

	Login the private registry
	  docker login private-registry.io
	
	Now docker run	
	  docker run private-registery.io/apps/internal-app

## Container orchestration

	When an application is deployed there are time when new instance of a image
	need to be swapned or extra instances need to be destroyed. Or if the load 
	on the host increases beyond an extent the complete the host can go down
	you write a script work around this or keep a person to keep an eye on it
	or use an orceshteration tool like docker swarm, kubernetes, mesos etc


## Running windows containers 
	Ohk so this one was a hard task given the no support policy of microsoft 
	dockerized windows container can only run on windows 10 pro or enterprise 
	edition. This took almost 2 days to finaly figure a work around and do it
	the people at aerocuke have done a great job regarding this and their work
	served as the base of my work. 
	
	So how do you do it on linux.. 
	You take up a base ubuntu image and inside that they run a virtualization
	tool likle qemu and then copy the windows image and a pre configured sdd image
	inside the dockerfile folder and then boot this pre booted image of windows
	There is one problem that will come up that the driver image is not signed 
	windows can throw this error when you use the redhat provided drivers through
	some luck the amd architecture of driver worked out.... and was able to create	
	the booted snap and then dockerize it through the docker file. The final docker
	fie came out to be 13 gigs.
	
	Now you can run the docker image and connect it to through a VNC server. You put 		the localhost:5900 as the connection adress and selenoid as the password.

## Steps to run

	>> Keep the driver file and the windows image file the directory where you want
	   to create the container

	>> create the hard disk image where windows will be installed
 	   
	   qemu-img create -f qcow2 hdd.img 40G

	>> Now run the vritual machine 
	
	   sudo qemu-system-x86_64 -enable-kvm \
           -machine q35 -smp sockets=1,cores=4,threads=2 -m 4096 \
           -usb -device usb-kbd -device usb-tablet -rtc base=localtime \
           -net nic,model=virtio -net user,hostfwd=tcp::4444-:4444 \
           -drive file=hdd.img,media=disk,if=virtio \
           -drive file=Win10_18090Oct_x64.iso,media=cdrom \
           -drive file=virtio-win-0.1.141.iso,media=cdrom 

	
	    sudo qemu-system-x86_64 -enable-kvm \
           -machine q35 -smp sockets=1,cores=2,threads=2 -m 4096 \
           -usb -device usb-kbd -device usb-tablet -rtc base=localtime \
           -net nic,model=virtio -net user,hostfwd=tcp::4444-:4444 \
           -drive file=hdd.img,media=disk,if=virtio \
           -drive file=Win10_18090Oct_x64.iso,media=cdrom \
           -drive file=virtio-win-0.1.141.iso,media=cdrom


	>> Now you install windows and when prompted for the drivers select the 
	   amd type of driver for E/veritio/win10/amd  
	>> this will show red hat driver install the windows on the hard disk you 
	   created earlier.

	>> Now you lo in the windows and install web driver binaries for the edge 
	   browser 


	  DISM.exe /Online /Add-Capability /CapabilityName:Microsoft.WebDriver~~~~0.0.1.0

	   by running the above command in the CMD run as administrator


	>> Then you shut down the machine and virtual machine and save the state using
	   the below command.


	 sudo qemu-system-x86_64 -enable-kvm \
        -machine q35 -smp sockets=1,cores=4,threads=2 -m 4096 \
        -usb -device usb-kbd -device usb-tablet -rtc base=localtime \
        -net nic,model=virtio -net user,hostfwd=tcp::4444-:4444 \
        -drive file=snapshot.img,media=disk,if=virtio \
        -monitor stdio

	>> Now you go in the windows and run the following command
	  MicrosoftWebDriver.exe --host=10.0.2.15 --port=4444 --verbose
	
	this 
	  MicrosoftWebDriver.exe --host=10.0.2.15 --port=4444 --verbose

	this will run the web driver server

	>> Now you need to save the vm state

	   (qemu) savevm windows

	>> Now quit the vm
	   (qemu) quit 


	>> Now you can manually run the 

	 sudo qemu-system-x86_64 -enable-kvm \
        -machine q35 -smp sockets=1,cores=4,threads=2 -m 4096 \
        -usb -device usb-kbd -device usb-tablet -rtc base=localtime \
        -net nic,model=virtio -net user,hostfwd=tcp::4444-:4444 \
        -drive file=snapshot.img,media=disk,if=virtio \
        -loadvm windows


	>> Now you can create a docker iamge using this 

	docker build -t windows/edge:18 . # For Microsoft Edge

	>> now you can run the container using 
	docker run -it --rm --privileged -p 4444:4444 -p 5900:5900 windows/edge:18 

	>> now log check it out using a vnc client 
	 	vnc://localhost:5900
		using password selenoid

	

	

