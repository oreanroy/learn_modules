## What is Docker

## How does it work

## intalling docker

## What is container

## what is image

## Running your first container

## Docker commands on container

## Docker commands on image

## Building your first container

## Docker compose files 

## Docker Engine

## Docker storage

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
	

