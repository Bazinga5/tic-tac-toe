Development Manual
========================

/*Development manual, that is, what is needed and how to get the
project to build on a fresh machine
Source control client and access to source control*/


Code rules
----------------
* KISS - keep it simple stupid
* DRY - dont repeat yourself
* SSR - single responsability rule

Brackest should be beside a function and then below the last line in the function. 
Space before and after each opareator. 
Space after for, while, if and similar statements. 
Comments should be placed above functions but not below. 
Indent should be used properly.
Use Camel casing for functions and variables and Pascal casing for classes.

Pair Programming
------------------
We use the XP methodology "pair programming". Pair programming tends to produce higher quality design, everybody gains a working knowldedge of the entire codebase and the pair is more likely to "do the right thing".

GitHub rules
----------------
The person who pushed somehing into the master is not the person to merge  when pushing code. A new branch should be created when working on each feature and then deleted when it has been merged with the master. 
All small changes should be pushed/commited when they are ready. 
You should try to minimum or avoid pushing something from the branch master. 
Nothing will be merged with the master unless it workes on the feature branch, Gradle and Travis  .... (more detail needed).

## Usage:

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

//segja hvernig við vinnum verkefnið
//nýr forritari, hvað þarf hann að vita
//hvernig við vinnum

/*Instructions for setup
---------------------------
This project was built in an UNIX environment so the manual reflects that fact. */


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
The game can now be built using the command:
```
./gradlew build
```

Heroku
------------
Heroku is a cloud platform that lets companies build, deliver, monitor and scale apps. Heroku puts an app you've developed on the Internet for others to use. 

We installed Heroku toolbelt for command lines operations.

```
wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh
```


For every push to master a build to Travis is staged. Travis checks the unit tests and then checks the end-to-end tests with Selenium. If Travis gives the green light on the tests the GAME?? is deployed on Heroku. 

Selenium
-------------
Selenium provides a record/playback tool for authoring tests without learning a test scripting language (Selenium IDE). Tests are saved in .html form and then exported to .java. Travis will then automatically run the selenium tests. The Firefox browser is needed (we use version 41.0.2) for the Selenum IDE to be integrated. 

Something about Travis+Selenium=howItWorks
