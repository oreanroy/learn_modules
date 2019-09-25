## What is Kubernetes
	
	Kubernetes is a containerized deployment management tool. It helps to manage 
	containerized workloads.
	Kubernetes is written in Go

## Kubernetes cluster Components

### Kubernetes Proxy
	kubernetes proxy routes network traffic to loas-balanced servie in cluster. 
	To do the job proxy must be preset on ever node in cluster

### Kubernetes DNS
	kubernetes runs a DNS server which provides naming and discovery for the services 
	that are defined in the cluster. This server also runs a replicated service on the
	cluster. Depending on the size of the cluster there might be mutiple DNS servers
	running.

	$ kubectl get deployments --namespace=kube-system kube-dns

	For this there is a kubernetes service running which performs the load balancing for 
	the DNS server.

	$ kubectl get services --namespace=kube-system kube-dns

### Kubernetes UI
	The final componet is a GUI service running. There is a single replicla managed by
	kubernetes depolyment fro reliability and upgrades.

	$ kubectl get deplyments --namespace=kube-system kubernetes-dashboard
	
	This shows the running dashbaord server
	
	$ kubectl get services --namesapce=kube-system kubernetes-dashboard

	To acess the UI launch kubectl proxy
	
	$ kubectl proxy
	
	Now you cam acess the dashboard at http://localhost:8001/ui


## kubectl

### Namespaces 
	Kubernetes uses namespaces to organize objects in the cluster. Namespace can be taken
	as a folder that holds a set of objects. That is in namespace kubectl can only acess
	objects defined in that namespace. By deafult the kubectl will interact with default
	namespace. To change namespace you can use.

	$ kubectl --namespace=mystuff

### Contexts 

	Kubernetes uses contexts to manage different cluster or different user for
	authenticating to those clusters. Conetext make changes in the .kube/config 
	file. 

	$ Kubectl config set-context my-context --namespace=mystuff
	
	This will create a context with a differen namespace

	to start using this context you can use
	
	$ kubectl config use-context my-context

### Kubernetes Objects

	Everything contained in kubernetes is represented by a RESTFul resource.These objects
	can be referenced using an simple API call. Each resource object exists at a differen
	t unique HTTP path for example, https://your-k8s.com/api/v1/namespaces/default/pods/ 
	my-pod. The Kubectl command converts the get command in a simple http request.

	The kubectl configures the repsonse and extracts the human redable important data 
	and presents that in more readble from. 
	To get more detailed version you can use -o flag or other flags to get detailed data
	-o json or -o yaml will represent the returned object in the specified format

	The kubectl uses Json path query laguage to extarct information from the returned 
	object. To get specific information you can use specified flags to get it

	$ kubectl get pods my-pod -o jsonpath --template={.status.podIP}

	To get the ip of that specific pod
	

### creating, Updating, and destroying Kuberneets Objects
	Objects in kubernetes API are represente as JSON or YAML files. These files are 
	either returned by the server in response to a query or posted to the server
	as a part of an API request. 

	To create an object just run the yaml file pertaining to it the typeo of object
	and other data will be taken from the file

	$ Kubectl apply -f obj.yaml

	To upadate or moidify also make changes and re run 
	
	$ kubectl apply -f obj.yaml

	to delete an object run
	
	$ kubectl delete -f obj.yaml
	
	Thsi will delete the specific object

### Labeling and Annotating Object
	$ kubectl label pods

### Debugging Commands
	
	$ kubectl log <pod-name> 
	
	This displays the logs for the current conatiner

	$ kubectl exec -i <pod-name> --bash
	
	This runs a interactive bash shell inside the running container 

	$ kubectl cp <pod-name>:/path/to/remote/file /path/to/local/file

	This can be used to copy fils to and fro from cluster to local

	kubectl help
	kubectl help command-name
	
	TO get info about the command
	 


## Canary Deploments

	During the old mining times in britain the miners used to put caged canaries in 
	the mine and when ever the level of methane would increase or oxygen decreased
	beyond the safety limit the canaries would die or faint giving a signal to the 
	miners to vacate the caves
	
	Something similar is used in containerized workloads where a certain portion
	of servers are kept as canary servers and any new cahanges are first rolled out 
	on these servers and tested and then rolled out full fleged.

## Kubernetes RBAC authorization

## cretaing user

## creating roles

## applying roles

## creating bindings

## applying bindings  
