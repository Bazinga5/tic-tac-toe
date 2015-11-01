Development Manual
========================

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
The game can now be built using the command:
```
./gradlew build
```
