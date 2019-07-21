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
	


	


	

	
