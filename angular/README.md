# intalling and running first angular app
        > npm install -g @angular/cli
        > ng new my-dream-app
        > cd my-dream-app
        > ng serve

# components 
        are specified in app.component.ts and can be used with the same tag
        name as html components

        @component({
          selector: 'app-root',
          templaUrl: './app.component.html', //template related to above component
          styleUrls: ['./app.component.css']
        })

        //html component
        <app-root></ap-root>

app.modules.ts is where you add the components needed for the app to run.
The course structure
	>> The basics
	>> Component and Databinding
	>> Directives
	>> services and deepndencies injection
	>> Routing
	>> Observables
	>> Forms
	>> Pipes
	>> htpp
	>> authentication
	>> optimization and NgModules
	>> Deployment 

# Typescipt
	More features than vanila javaScript has classes, interfaces, Types that is you have 
	to define int string etc, it gets recompiled to javaScript.

	you can create custom classes and export them to other ts files and use as custom
	data types to shell out objects

	the reipe.modal.ts file	

	export class Recipe {
	    public name: string;
	    public description: string;
	    public imagePath: string;

	    constructor(name: string, description: string, imagePath: string){
	      this.name = name;
	      this.description = description;
	      this.imagePath = imagePath;
	    }
	}

	importing it into the component tyscript file and shelling out objects

	import { Recipe } from '../recipe.modal'

	export class RecipeListComponent implements OnInit {
	  recipes: Recipe[] = [
	    new Recipe('A test recipe', 'this is simply a discription', 'https://		     images.unsplash.com/photo-1460306855393-0410f61241c7?	ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80')
	  ];

	  constructor() { }

	  ngOnInit() {
	  }

	}		

# Source Map

	All the javascrip code is compiled into typescript bundles which can be accessed
	from the brwoser, when you set break point the exact file opens up rather than
	the bundle.

# Augury
	This is a chrome extension which enhances the developer tools for angular application
	analysis. You can do state analysis, component map, injector graph
	

# Angular basics
	The index.html which is created during creating the app by cli is the single page 
	served by angular.

	main.ts is the file which is executed first the Appmodule passed to the boostrap
	fucntion starts the app.
	the circular binding
	main.ts >> AppModule(to boostrapModule func) >> app.module(file) >> (this file has
	a boostrap array which has list of all the components angular should know at time 
	of initializing index.html) >> AppComponent

# Components
	The building blocks of angular application, can be reused and have seprate html
	and css files and bussiness logic.
	>> the AppComponent is the root component
		>> The other componets created are not added to index.html but 			   app.component.html

	## Creating your first component
		Components can be created by creating a directory manually in app folder
		with component name and then defining the name.component.ts file along 
		with other helper files of name.component.html, name.component.css.
		Then adding it in declaratives of aap.module.ts and then the selector can
		be used as html tag in app.component.html
		
		app
		 --server
		    --server.component.ts
		    --server.component.html
		    --server.component.css
		
		________________________________________________________________

		server.component.ts
		import { Component } from '@angular/core';

		@Component({
		    selector: 'app-server',
		    templateUrl: './server.component.html'
		})
		export class ServerComponent {

		}
		
		__________________________________________________________________

		add decalration in app.module.ts
		
		
		@NgModule({
		  declarations: [
		    AppComponent,
		    ServerComponent,
		    ServersComponent
		  ],
		  imports: [
		    BrowserModule
		  ],
		  providers: [],
		  bootstrap: [AppComponent]
		})
		
		__________________________________________________________________

		This can also be done using ng generate component servers
		command, use the command ng g c servers this is the preferable
		method and must be used run the above command in folder where
		you wana create the component.

		## Adding styles to component
		Styles can be added to the component using the styleUrls giving link
		to the style sheet. Multiple stylesheets can be added through this.
		The styles can also be added using the simple 
		styles: [`
			h3 {
				color: blue;
				}			
			`]
		this give a inline styling will have higher prefernce.

		## compoent selector as attribute
 
		the component can be defined as attribute by adding square brackets
		
		
		@Component({
		  selector: '[app-servers]',
		  templateUrl: './servers.component.html',
		  styleUrls: ['./servers.component.css']
		})
		
		in this case you cannot use it as a html component you will have to 
		use it as an attribute. that is.
		<div app-servers></div>
	
		## compoent selector as class
		
		the componet can be defined as class by adding . operator befor the 
		name that is .app-servers
		
		<div class='app-servers></div>	

		to create a component inside a folder you just need to add path to ng 
		create something like
 
		ng g c receipes/recipe-detail --spec fail
	
		this will form a recipe-detial component inside the recipes folder and the
		--spec fail prevents creation of testing file
		
			
	
## Databinding 
		
	The communication between the typescript and template is where data binding comes
	into play.

	|--              --|  --------(output data)----------->>       |--            --|
	|		   |  String interpolation( {{ data }} )       |                | 
	| TypeScript Code  |  Property binding( [property]="data" )    | Template(HTML) |
	|(Bussiness Logic) |                                           |                |
	|                  |  <<------(React to User Events)----       |                |
	|                  |  Event Binding( (event)="expression")     |                |
	|--              --|                                           |--            --|

	         Combination of Both Two-Way-Binding( [(ngModel)]="data")

	# string interpolation
	Anything that returns a string can be used in between the curly  brackets
	{{ 'Server' }} or {{ serverId }} you can also call a funtion which return 
	string.


	databinding example as string interpolation
	you need to pass the variable in export class
	
	export class ServersComponent implements OnInit {
  	allowNewServer = false;
  	constructor() {
    	setTimeout(() => {
      		this.allowNewServer = true;
    	}, 2000)
   	}
  	ngOnInit() {
  	}

	now you can use this variable in the html template
	<button 
	class="btn btn-primary" 
	[disabled]="!allowNewServer">Add Server</button>
	<app-server></app-server>
	<app-server></app-server>
	you are using the allowserver in html template now you can also set the html
	property [disabled] to allowNewServer.
	
	any function that you put in the export class can be accessed in the html template
	that is event binding for you

	# From Component to view

	@Component({
	  selector: 'app-example',
	  template: `
	              <div>
		        <strong>{{firstName}}</strong>
		        <strong>{{lastName}}</strong>
                      </div>
		    `
	})
	
	export class AppComponent {
	  firstName: string = "Yallaling";
	  lastName: string = "Goudar";
	}
	
	above was an example of interpolation

	now take in consideration property binding
	
	import { Component } from "@angular/core";
	@Component({
	  selector: 'app-example',
	  template: `
	              <div>
                      <span [innerHTML]='firstName'></span>
	              </div>
		    `
	})
	export class AppComponent {
	  firstName: string = "Yallaing";
	}

	There can be style, class or attribute binding in similar way
	<h1 [style.color]="blue">This is a Blue Heading</h1> //style binding

	# From view to Component
	
	<button (click)="myFunction()">Show alert</button>

	import { Component } from "@angular/core";
	@Component({
	  selctor: 'app-example',
	  template: `<button (click)='myFunction()' >Show alert</button>
	})
	export class AppComponent {
	  myFunction(): void {
	  	alert("show alert!"):
	  }
	}

	# Two way data binding
	
	The two way data binding helps exchange data from component to view and
	view to component. It is acheived using (ngModel) directive which is a 
	combination of both square bracket property binding and parentheses of 
	event binding. for using this u need to import Forms module.
	
	import { Component } from '@angular/core';
	@Component({
	  selector: 'app-example',
	  template: `
	              Enter the value : <input [(ngModel)] = 'val'>
		      <br>
	                Entered value is: {{val}}
		     `
	})
	export class AppComponent {
	  val: string = '';
	}

## Directives

	Directives are instructions in the DOM(Document Object Model). Like when you
	use the selector of component to replace it with component template when html 
	is rendered you are giving an instruction to replace this place/object with 
	template of that component. Hence components are directives with templates
	there are other kind of directives too, pre build or self defined. 
	
	<p appTurnGreen>Recives a green backgroud!</p>

	@Directives({
		selector: '[appTurnGreen]'
	})
	export class TurnGreenDirective {
		----
	}

	The above is an example of self defined directive.	
	
	<p *ngIf="ServerCreated">Server was created, {{ serverName }}</p>
	
	This is an example of pre build directive and the * at the starting indicate
	that this is a strcutural directive. That is it will make changes to the DOM 
	structure.

	<p *ngIf="serverCreated; else noServer">Server was created, server name is 		{{ serverName }}</p>
	<ng-template #noServer>
    		<p>No server was created.</p>
	</ng-template>

	that's ngIf with an else statement and use of local marker shown there. The
	#noServer is the local marker which will is rendered in else case.

### ngStyle
	
	it is a attribute directory that is it can be used to change the attribute 
	of a dom element

	
 	<h1 [ngStyle]="{backgroundColor: getColor()}"> {{ 'Server' }} with ID {{ serverId }} 		is {{ serverStatus }} </h1>

	you can write a getColor() function in export of the same component 

### ngClass

	<h1 [ngStyle]="{backgroundColor: getColor()}" [ngClass]="{online: serverStatus === 		'online'}"> {{ 'Server' }} with ID {{ serverId }} is {{ serverStatus }} </h1>

	this will associate the styles associated with class online to the h1 element
	when online condition is sattisfied

### ngFor
	
	<app-server *ngFor="let server of servers"></app-server>
	
	this will loop over the elements in servers and pass the server in the template


# Property and Event Binding

## adding to own/custom property
	Assume a variable/property that is defined in a ts file of a component that can only 
	be accessed inside the component that is the html file attached to that component now
	assume you want to access that property/variable outside the component how will you 
	do it.

	Take this example for consideration 
	
	server-conponent.ts file	

	import { Component, OnInit, Input } from '@angular/core';
	import { Content } from '@angular/compiler/src/render3/r3_ast';

	@Component({
	  selector: 'app-server-element',
	  templateUrl: './server-element.component.html',
	  styleUrls: ['./server-element.component.css']
	})
	export class ServerElementComponent implements OnInit {
	  @Input() element: {type: string, name: string, content: string};
	  constructor() { }

	  ngOnInit() {
	  }

	}

	server-component.html file

	<div
	    class="panel panel-default"
	    >
	    <div class="panel-heading">{{ element.name }}</div>
	    <div class="panel-body">
	      <p>
	        <strong *ngIf="element.type === 'server'" style="color: red">		{{ element.content }}</strong>
	        <em *ngIf="element.type === 'blueprint'">{{ element.content }}</em>
	      </p>
	    </div>
	</div>

	app-component.ts file 

	
	import { Component } from '@angular/core';

	@Component({
	  selector: 'app-root',
	  templateUrl: './app.component.html',
	  styleUrls: ['./app.component.css']
	})
	export class AppComponent {
	  serverElements = [{type: 'server', name: 'Testserver', content: 'just a test'}, 
                    {type: 'blueprint', name: 'Teest blueprint', content: 'just a test'}];
	  
	}


	app-component.html file 

	<div class="container">
        <app-cockpit></app-cockpit>
	  <hr>
	  <div class="row">
	    <div class="col-xs-12">
	      <app-server-element 
	      *ngFor="let serverElement of serverElements"
	      [element]="serverElement"></app-server-element>
	    </div>
	  </div>
	</div>

	In the above example we have a element property in server-element.ts which under
	normal condition can only be accessed by server-component.html but here it is accessed
	by app-componet.html and used to shell out objects of type element from data taken
	from app-compoent.ts which was made possible by the use of @input()
	this makes it availble for parent component
	you will also have to import input from angular core


	Now consider a case where you want the property to be known by other name outside
	the component this can be done by using an alias which can be used outside the 
	component

	@Input('srvElement') element: {type: string, name: string, content: string};

	now you can use srvElement instead to just element in app-component.html
	that is
	
	<div class="col-xs-12">
	      <app-server-element 
	      *ngFor="let serverElement of serverElements"
	      [srvElement]="serverElement"></app-server-element>
	</div>


## Binding to custom events

	consider a scenario where there is a child component and an event occurs in the child
	component like a button is clicked or a form is submitted now you want to call a 
	function of parent component or pass the data from child to parent how will you do 
	that lets see
	

	so we create an event in the child component and then emit it to the parent compoenent
	when a button is clicked(or other such event) the parent has an event binding to 
	this custom and will call a fucntion or execute other task

	take an example of below code

	cockpit.component.ts
	
	import { Component, OnInit, EventEmitter, Output} from '@angular/core';

	@Component({
	  selector: 'app-cockpit',
	  templateUrl: './cockpit.component.html',
	  styleUrls: ['./cockpit.component.css']
	})
	export class CockpitComponent implements OnInit {

	  @Output() serverCreated = new EventEmitter<{serverName: string, serverContent: string}>();
	  @Output() bluprintCreated = new EventEmitter<{serverName: string, serverContent: string}>();
	  constructor() { }

	  ngOnInit() {
	  }
	  newServerName = '';
	  newServerContent = '';

	  onAddServer() {
	    this.serverCreated.emit({
	      serverName: this.newServerName,
	      serverContent: this.newServerContent
	    })
	  }

	  onAddBlueprint() {
	    this.bluprintCreated.emit({
	      serverName: this.newServerName,
	      serverContent: this.newServerContent
	    })
	  }
	}



	here we have created two event emitter and two functions which are executed when
	the button is clicked both of which call different event emitter. this event is what
	the parent listens to. Along wiht the event it also transmits some data

	<div class="row">
	    <div class="col-xs-12">
	      <p>Add new Servers or blueprints!</p>
	      <label>Server Name</label>
	      <input type="text" class="form-control" [(ngModel)]="newServerName">
	      <label>Server Content</label>
	      <input type="text" class="form-control" [(ngModel)]="newServerContent">
	      <br>
	      <button
		class="btn btn-primary"
		(click)="onAddServer()">Add Server</button> // the function being called
	      <button
		class="btn btn-primary"
		(click)="onAddBlueprint()">Add Server Blueprint</button>
	    </div>
	</div>
	
	this is how you trigger the event from browser, now have a  look at the parent
	component .ts file

	import { Component } from '@angular/core';

	@Component({
	  selector: 'app-root',
	  templateUrl: './app.component.html',
	  styleUrls: ['./app.component.css']
	})
	export class AppComponent {
	  serverElements = [{type: 'server', name: 'Testserver', content: 'just a test'}, 
		            {type: 'blueprint', name: 'Teest blueprint', content: 'just a test'}];
	  
	onServerAdded(serverData: {serverName: string, serverContent: string}) {
	  this.serverElements.push({
	    type: 'server',
	    name: serverData.serverName,
	    content: serverData.serverContent
	  });
	}
	onBlueprintAdded(blueprintData: {serverName: string, serverContent: string}) {
	  this.serverElements.push({
	    type: 'blueprint',
	    name: blueprintData.serverName,
	    content: blueprintData.serverContent
	  });
	}
	}



	here we have two functions which are called when the event is encountered now 
	see how the event lintener is put in the html file

	<div class="container">
	  <app-cockpit 
	  (serverCreated)="onServerAdded($event)"
	  (bluePrintCreated)="onBlueprintAdded($event)" // these are the event listener
	  ></app-cockpit>
	  <hr>
	  <div class="row">
	    <div class="col-xs-12">
	      <app-server-element 
	      *ngFor="let serverElement of serverElements"
	      [srvElement]="serverElement"></app-server-element>
	    </div>
	  </div>
	</div>
 
	The event listener also collect the data generated during event trigger
	you can also add alias to it as you have done above it also prevents the 
	real name to be exposed outside 


## view encapsulation

	That is the css written for a component is only applicable to that component 
	and will also not be applicable to its child componen. example you write a css
	p { color: blue; } in app.compoen.css and a child component has an p element 
	then it will not be blue

	This is because of the shadow dom feature of the angular its not a pure shadow 
	dom the angualar adds an add on class to the element hence the css is only applied
	to the coresponding component html 

## modifications to view encapsulation

	The encapsulation can be set to three values the deafult one being the emulated
	other is none which means any css apllied will also be applied globaly  and finaly
	native which gives the same result as emulated but use the shadow dom underneath as
	a technology

## local refrence
	these are refrences which can be used to denote an element and can only be used
	in the html file. These denote a element hence the compolete element is passed
	They can be setup using an # symbol
	take this for example 
	
	<input 
	  type="text"
	  class="form-control"
	  #serverNameInput>
	
	now you can pass this element around using the key word serverNameInput

	
	<button
	  class="btn btn-primary"
	  (click)="onAddServer(serverNameInput)">Add Server
	</button>

	onAddServer(nameInput: HTMLInputELement) {
	  this.serverCreated.emit({
	    serverName: nameInput.value,
	    serverContent: this.newServerContent
	  });
	}
	
	


	


	

	
