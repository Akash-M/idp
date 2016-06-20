Baggage Handling System Dashboard - Backend
---
=================================
This project is built for Department of Operations Research, Technische Universität München as an Inter-Disciplinary Project.
The project is back-end part of a two part application(front-end and back-end) implemented using Play 2.1.5 with Spring Data MongoDB.
front-end is implemented using AngularJS and is present as a seperate repository

# Baggage Handling System Dashboard
---
The application consists of two pages: `Home` and `Carousel`
- Home page displays details of all current carousels present in the DB
- Carousel page displays flight details, baggage details and graphs belonging to a carousel as selected by you in the dropdown menu

## Getting Started
---
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
Steps: 
```
> Clone this project into your local machine using git `git clone https://github.com/Akash-M/idp-backend.git`
> cd to project directory where `activator.bat` is present.
> run commands `activator clean` and `activator run`
> the application will now run on port 9000
```
[LocalHost:9000](http://locahost:9000/)

### Prerequisities
What things you need to install the software and how to install them
[Install Play](https://www.playframework.com/documentation/2.5.x/Installing)
```
> Play 2.1.5 ( we will use activator version of the play for this) 
```
[Install Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
```
> Any version of Git
```
[Setting up your preffered IDE for play](https://www.playframework.com/documentation/2.5.x/IDE)
```
> for further developmnet configure any IDE of your choice wiht Scala/Java plugins 
```

## Directory structure
---
and important files
Click [here](https://www.playframework.com/documentation/2.5.x/Anatomy) for complete anatomy of Play application
```
app                      → Application sources
 └ assets                → Compiled asset sources
    └ stylesheets        → Typically LESS CSS sources
    └ javascripts        → Typically CoffeeScript sources
 └ configs/              → Your custom configuration exists here
    └ AppConfig           → your applications global setting: Injecting MongoTemplates, Encapsulation your preflight requests etc.
 └ controllers           → Application controllers
 └ daos                  → All data access sevices objects interfaces are here
 └ services              → All services that act on daos are deffined here
 └ models                → Application business layer
 └ views                 → Templates: We'll not be using these as this is just a back-end of the application
build.sbt                → Application build script
conf                     → Configurations files and other non-compiled resources (on classpath)
 └ application.conf      → Main configuration file
 └ routes                → Routes definition
dist                     → Arbitrary files to be included in your projects distribution
public                   → Public assets
 └ stylesheets           → CSS files
 └ javascripts           → Javascript files
 └ images                → Image files
project                  → sbt configuration files
 └ build.properties      → Marker for sbt project
 └ plugins.sbt           → sbt plugins including the declaration for Play itself
lib                      → Unmanaged libraries dependencies
logs                     → Logs folder
 └ application.log       → Default log file
target                   → Generated stuff
 └ resolution-cache      → Info about dependencies
 └ scala-2.11
    └ api                → Generated API docs
    └ classes            → Compiled class files
    └ routes             → Sources generated from routes
    └ twirl              → Sources generated from templates
 └ universal             → Application packaging
 └ web                   → Compiled web assets
test                     → source folder for unit or functional tests
```
---
## Adding configuration strings that can be access by play application
You can add any configuration constant that you will need to use in the application with in conf/application.conf as key/value pairs 
ex. play.application.status.ok=90

with in you service implementation add these to import statements
```
import play.Configuration;
import play.Play;
```
Create configuration object to access configuration strings like 
```
    `Configuration conf = Play.application().configuration();`       
```
Now you can get your configuration value using 
```
    `conf.getInt("<Your.string.key")` --> for retreiving the value as Integer
    `conf.getString("<Your.string.key")` --> for retreiving the value as String
```
     