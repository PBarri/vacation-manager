# Vacation Manager

This project contains a demo projec to test things with Angular, building an application to manage the vacations of a company.
The project is built from the angular seed project.

## Project Structure

The project is divided into to modules, `api` and `ui`.

* The `api` module is a **Spring MVC** application, and is in charge of providing data to the client side.
* The `ui` module is an **Angular JS** application that provides the interface of the application.

### Directory layout

```
vacation-manager/
  api/
    src/
      main/
        java/
          api/                  --> *package folders ommited*
            config/               --> Package for configuration classes
            controllers/          --> Package for storing all the API controllers
            data/                 
              repositories/       --> Package for JPA repositories
              services/           --> Package for Spring services
            ApiApplication.java   --> Spring Boot main class
        resources/
        webapp/
      test/
  ui/
    app/                  --> all of the source files for the application
      components/           --> all app specific modules
      views/                --> all app specific views
        index/                --> the index view template and logic
          index.html            --> the partial template
          index.js              --> the controller logic
          index_test.js         --> tests of the controller
        view2/                --> the view2 view template and logic
          view2.html            --> the partial template
          view2.js              --> the controller logic
          view2_test.js         --> tests of the controller
        WEB-INF/
          jboss-web.xml         --> jboss configuration
      app.css               --> default stylesheet
      app.js                --> main application module
      components.js         --> file that require all the components in order to ship them with webpack
      index.html            --> app layout file (the main html template file of the app)
      services.js           --> javascript service dependencies to be included in the webpack bundle
      vendor.js             --> javascript dependencies to be included in the webpack bundle
      vendor.css            --> css dependencies
      views.js              --> file requiring all the views modules to ship with webpack 
    bower.json            --> bower configuration file
    karma.conf.js         --> config file for running unit tests with Karma
 .   package.json          --> node configuration file
    webpack.config.js     --> webpack configuration file
```


## Getting Started

To get you started you can simply clone the repository and execute the following gradle tasks:

### Install Dependencies

We have three kinds of dependencies in this project: tools, angular framework code and spring framework code.  
The tools help us manage and test the application.

* We get the tools we depend upon via `npm`, the [node package manager](https://www.npmjs.com/).
* We get the angular code via `bower`, a [client-side code package manager](http://bower.io).
* We get the spring framework code via `gradle`, a [java build tool](https://gradle.org/)

We have preconfigured `gradle` to automatically run `npm` and `bower` so we can simply do:

```
gradlew dist
```

Behind the scenes this will do the following:

* Compile the java sources in the `api` project
* Creates a war file from the sources in the `api` project
* Trigger a `npm install` task
* Call `bower install`
* Call `webpack`, creating a javascript and a css bundle from files in the `ui` project
* Creates a war file from the bundles and the resources in the `ui` project

You should find that you have many new folders into your project:

* `dist` - contains the war files of the two projects
* `ui/node_modules` - contains the npm packages for the tools we need
* `ui/bower_components` - contains the angular framework files
* `ui/dist` - contains the bundles created by webpack

You should also see `api/build`, `ui/build`, but those are folders created by Gradle

*_NOTE: For installing in Eclipse, you need to install the [Buildship](https://projects.eclipse.org/projects/tools.buildship) plugin, and then import the project._*

### Running the Application

#### Docker

We have configured a [Docker](https://www.docker.com/) file and two Gradle tasks for creating and running the whole application into a Docker container.

```
gradlew dockerBuild
```

This task will create a Docker container with the name `pbarri/vm`

```
gradlew dockerRun
```

This task will run the previous container.

After running this task, you could browse the app at `http://localhost:8080/vacation-manager`.
You could also call the API, located at `http://localhost:8080/api`

*_NOTE: You must have Docker installed in your computer to use this feature_*

#### API application

We have preconfigured the project with [Spring Boot] (https://projects.spring.io/spring-boot/), and add a Gradle task for easy deployment.
The simplest way to start the server is:

```
gradlew runApi
```

#### Ui application

We have preconfigured the project with a simple development web server, provided by webpack.  The simplest way to start
this server is:

```
gradlew runUi
```

Now browse to the app at `http://localhost:8000/vacation-manager`.

Another way to run the ui application is by `npm` with:

```
npm start
```

*Note that you have to be in the ui root folder*

### Application versioning

This project follows the semantic versioning.

Given a MAJOR.MINOR.PATCH version, increment:

* `MAJOR` version when new incompatible changes are introduced in the API.
* `MINOR` when new features are introduced and are backwards compatible with the existing API.
* `PATCH` for barckwards compatible bug fixes.

In adition to that, we've included two labels, `SNAPSHOT` and `RELEASE` to distinguish 
between production ready releases and nightly builds.

To help in the version, the application is shipped with gradle tasks to create new versions. Those tasks are:

* `gradlew majorRelease dist`
* `gradlew minorRelease dist`
* `gradlew patchRelease dist`
* `gradlew majorSnapshot dist`
* `gradlew minorSnapshot dist`
* `gradlew patchSnapshot dist`

Executing any of those tasks will create the artifacts with the new version, and update the properties in the file gradle.properties.
 
In the current version, this file must be pushed to the repository manually to prevent version conflicts.

## Extending the application

To add new functionality to the application, you have to have in mind the next:

* To add a new view, you have to require the entry point of the view in the `views.js` file.

Example:
```
require('views/index/index.js');
```

* To add a new component (directives), you have to require the entry point of the component to the file `components.js` in the same way we did in the views.

## Testing

`SECTION IN PROGRESS`

### Running Unit Tests
