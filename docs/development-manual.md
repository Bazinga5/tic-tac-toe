Development Manual
========================


Code rules
----------------
* KISS - keep it simple stupid
* DRY - dont repeat yourself
* SSR - single responsability rule

Braces should be after a function and then below the last line of the function.
Space before and after each opareator.
Space after for, while, if and similar statements.
Comments should be placed above functions but not below.
Indent should be used properly.
Use Camel casing for functions and variables and Pascal casing for classes.

Git rules
----------------
A person who creates a pull request can not merge it herself.
A new branch should be created when working on each feature and then deleted when it has been merged with the master.
All small changes should be pushed/commited when they are ready.
Pushing something directly to the master branch should be avoided at all cost.
Nothing will be merged with the master unless it workes on the feature branch, Gradle and Travis.


Instructions for setup
---------------------------
This project was built in an UNIX environment so the manual reflects that fact.


The Java JDK developer kit
---------------------------------
The JDK is a development environment for building applications, applets, and components using the Java programming language. For the game to be able to run locally, java-jdk needs to be set up.

```
sudo apt-get update && sudo apt-get install default-jdk
```


Github
--------------
GitHub is a Git repository hosting service with a distributed version control system for software development.  

To install git locally, please enter the following command:
```
sudo apt-get install git
```
To retrieve the repository from github, please enter the following command:
```
sudo git clone https://github.com/Bazinga5/tic-tac-toe.git
```

Gradle
---------------
Gradle is an open source build automation system tool with a focus on build automation and support for multi-language development. Gradle offers a flexible model that can support the entire development lifecycle from compiling and packaging code to publishing web sites.
```
sudo apt-get install software-properties-common
sudo add-apt-repository ppa:cwchien/gradle
sudo apt-get update
sudo apt-get install gradle
```
Please verify the version of gradle with the command:
```
java --version
```

Build:
```sh
$ ./gradlew build
```

Test:
```sh
$ ./gradlew test
```

Run server:
```sh
$ ./gradlew run
```

Deploy to Staging
------------
The staging server is hosted on Heroku and automatic deployments are made after successful builds on Travis on the master branch.

Integration
-------------
To run integration tests make sure to have Firefox installed then do

```sh
$ ./gradlew seleniumXvfb
```
