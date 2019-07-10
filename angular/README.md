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
