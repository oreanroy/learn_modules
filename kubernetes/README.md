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
	To get more detailed version you can use -o wide flag or other flags to get detailed data
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
	 

## Pods 

	The pod is a group of whales. The whale is a symbol of docker so you get what pods
	represents.
	You put containers in pod and  most of the time a sigle container is run in a single
	pod but a case might arise where you run more than one container in a single pod as
	in both the container share a  common syncronized 

### What do appilcations running on same pod share
	The applications running on same pod share the same IP adress and port space.
	(network namespace) have same hostname and can communicate using interprocess 
	communication channels over system V, IPC etc

### When to put containers in same pods
	One question that you have to ask is will the containers work fine if they land up 
	on different machines. Other things to keep in mind is how will the container 
	scalling take place and are their symbiotic processes.

### Creating Pods
	The kubernetes API accepts the pod manifest and then stores that in the etcd storage
	the sheduler finds the pods that haven't been placed and then places them on machine
	which satisy the constraints. Kubernetes tries not to place multiple replica on same
	to provide a workout single machine failiure.

	There are two ways of creating pods that is by using replicaset deployment and other
	by pod Manifest.

### Deploying using Replicaset


### Deploying using manifest
	Pod manifets can be written uisng YAML or JSON. YAML is mostly prefered given the
	comment enabled and human readability.
	
	a breif example
	  apiVersion: v1
	  kind: pod
	  metadata:
	    name: kuard
	  spec:
	    containers:
	      - image: gcr.io/kaur-demo/kuard-amd64:1
	        name: kuard
	        ports:
		  - containerPort: 8080
	            name: http
	            protocol: TCP	

### Runnig Pods
	kubectl apply -f kuard-pod.yaml
	
	The Pod manifest will be submitted to kubernetes API server. The kubernets system
	will then schedule that pod to run on a healthy node in cluster. It wil be monitered
	by kubelet daemon process

	kubcetl get pods
	  to get pods

	kubectl descibe pods kuard
	  to get a detailed picture of the pod

	kubeclt delete pods/kuard 
	or
	kubcetl delete -f kuard-pod.yaml
	  to delete a pod

### accessing the pod
	
	Port forwarding

	  to expose a service to world or other container using load balancer or to access 
	  you need a port forwarding
	    kubcetl port-forward kuard 8080:8080
	
	This creates a secure tunnel from your local machine, through the kubernetes master 
	to the instance.

	Getting Logs
	  kubectl logs kuard
	This gives the logs related to that pod it you can use -f for contious log stream
	or other log aggreagatiob service like fluentd and elacticsearch 

	Running Commands in container
	  kubectl exec kuard date or kubcelt exec -it kuard bash

	Copying files to and from Containers
	  kubectl cp <pod-name>:/capture/capture3.txt ./capture3.txt
	   this copies file form container to local machine
	  kubectl cp $HOME/config.txt <pod-name>:/config.txt

	Health checks
	
	  When you run the application as a container in kubernetes, it is automatically 
	  kept alive uisng a process health check. This health check ensures that the main
	  process is running. However simple process check might not be enough as the 
	  application might have broken inside

	  To adress this kubernetes introduced health checks for application liveness and 
	  readiness
	    The liveness probe checks if application is live while the readiness probe checks
	    if the application is in ready state aong wilth built in health check that are
	    dependent on HTTP, TCP-sockets 

### Resource Management
	Kubernets can also be used for optimum uitlization of available computing resources
	so that there is less waste fo resources and dollars are saved. with sheduling system
	such as kubernets utilization greater than 50% can be acheived

	Minimum required Resource
	  apiVersion: v1
	  kind: pod
	  metadat:
	    name: kuard
	  spec:
            conatiners:
	      - image: gcr.io/kuar-demo/kuard-amd64:1
	        name: kuard
	        resources:
                  requests:
                    cpu: "500m"
                    memory: "128Mi"
                ports:
                  - containerPort: 8080
                    name: http
                    protocol: TCP
	
	Kubernetes shedules this in such a manner the pod is placed on a node where the 
	minimun resource requirement is met

	There is a maximum resoucrce requirement too
	
	when you set the maximun requirement you also set a minimum requirement the 
	diffrence between two is when you do not set the maximum cap all the available
	resource on the machine are given making sure minimum requirement is met meawhile
	in other case only the minimum asked resource is allocate and can only be scaled 
	to max cap limit

	requests:
	  cpu: "500m"
          memory: "128Mi"
	limits:
	  cpu: "1000m"
	  memory: "256Mi"
 
	
### Persistent Data with volume
	Whenver a pod is deleted or a container restarts the data created by it is deleted
	In certain use case you might require persistent volume

#### Using Volumes with pods
	you have to define all volumes in the pod and then inside the container you 
	define which volume are to be used by the container. Not all containers are 
	required to mount all volumes defined in the pod.
	
	apiVersion: v1
	kind: Pod
	metadata:
	  name: kuard
	spec:
	  volumes:
	    - name: "kuard-data"
	      hostPath:
	        path: "/var/lib/kuard"
	  containers:
	    - image: gcr.io/kuar-demo/kuard-amd64:1
              name: kuard
	      voumeMounts:
	        - mountPath: "/data"
	          name: "kaurd-data"
	      ports:
	        - contianerPort: 8080
	          name: http
	          protocol: TCP

	There are many application of persistent volumes or shared volumes like the 
	
	often times you want the data a pod is uing to stay with the pod, even when 
	the pod is restarted on different host machine. In that case you can use a 
	remote network volume. There are many ways to mount volumes over a network
	kubernetes has support for many protocols such as NFS, iSCSI etc

	volumes:
	  - name: "kuard-data"
	    nfs:
	      server: my.nfs.server.local
	      path: "/exports"

## Labels and anotation
	The label are maily used to create goups and subgroups to classify pods in a 	
	classifcation. Higly useful when the application gets scalled. The naming con
	vention is a key value pair. The label have simple syntax the key has two parts
	an optional prefix and a name. The porefix cab be a DNS subdomain with 253 character
	the name can be 63 and values can be 63.
	Key 			Value
	acme.com/app-version 	1.0.0

	applying label 
	  $ kubectl run alpaca-prod \
	  --image=gcr.io/kuar-demo/kuard-amd64:1 \
	  --replicas=2 \
	  --labels="ver=1,app=alpaca,env=prod"

	$ kubectl get deployments --show-labels

	you can also modify label after creation
	
	$ kubectl label deployments alpaca-test "canary=true"

	you can use label slector to get certain pods
	$ kubectl get pods --selector="ver=2"

### Anotaioins
	on the other hand  anotation are small notes kind of information stored in key 
	value pair which can be become importand during deployment or hold value of 
	certain info which is shared and very important.

	... 
	metadata
	  annotaions:
	    example.com/icon-url: "https://example.com/icon.png"
	...

## Delete all  deployment 
	$ kubectl delete deplyments -all


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

## Kubernetes Cluster
	They all have kubeproxy running on them this kube proxy updates or writes IP tables rules 
	such that any new service is created or deleted is taken in account. The api server 
	oversees the kube proxy.

## Replicaset
	Replicaset is a cluster wide Pod manager ensuring the right type and number of pods are
	running at all the time.
	When we dfine Replicaset we define the specificaion and the number of pods to be created
	Aditionaly we need to define a way to finding the pods the replicaset shoudl control.
	That is where Reconcilation loops come into play.
	The main concept behind reconcilation loop is current state, desired state, observed state
	The reconcilaion loop runs constantly to make sure the current observed state is equal to 
	the desired state.

### Some Important characteristics of replicaset
	Decoupling :- This is a theme that runs through kubernetes design. It is important to note
	most of the core conecpts of kubernetes are modular with respect to each other and they 
	are swapable and replaceable. That is even if Replicaset create pod but they are losely
	coupled. That is they do not own the created pod and the oly way to identify them is 
	through label queries and underneath they use the pod api to manage and maintain pods
	This decoupling can give additioinal features.

	>> Accepting existing containers :- a replicaset can be created to adopt an existing pod
	>> Qurantining containers :- A pod might be misbehaving and just deleting it would 
	   leave us with only exit logs but if we want to actully debug the pod we can remove it
	   from the existing replicset by changing the label.

	Things to keep in mind while desiging with replicasets
	  >  Pods created by reolicasets are homogeneous
	  >  Reoplicasets are dessigned to be stateless that is element created by replicasets are
             intercahngeable. When replicaset is scaled down aby arbitary pod is selected for
	     deletion.

### Insepecting a replicaset
	Kubectl describe kuard 
	  Get replicaset from a pod
	    kubectl get pods <pod-name> -o yaml
	  Finding set pods from a replicaset
	    kubectl get pods -l app = kuar

### Scalling 
	Imperative scalling and declarative scalling
	  imperative	
	    kubectl scale kuard --replicas=4
`         declrative
	    spec 
	       replcias: 3

### cooling period 

	3 mins scalling up
	5 mins scalling down
	15 sec to check utilization


## Config maps and secrtes 


	These comes in handy when we want to reuse image in production, deployment or any other
	such environment. At times the same image needs to be used across different applications
	To achive this you also need to share the pass keys, environment variables. This is where
	config maps and secrets come into play.
	config maps are used to provide configuration information for workplace this can be fine 
	grained infromation or composite value in form of file.

	Henec you can use the same image and pod def across multiple apps by changing the config
	provided by config maps or secretes.
	
	There are three main way in which config maps can be used:
	
	  >> to create a file system. The config file is loaded and a directory structure is 
	     created based on the entries in the config map
	  >> Enviroment variables :- to set enviroment variables
	  >> commmand line argiment :- used to create dynamic commands for a container based config
	     map

            

