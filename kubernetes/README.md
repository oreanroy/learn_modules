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
