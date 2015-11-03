Administration Manual
========================

For first time run please refer to the development manual:
```
https://github.com/Bazinga5/tic-tac-toe/blob/master/docs/development-manual.md
```


How to install and run the program
----------------

Since the game is a web app nothing has to be setup at the clients side. The client can just open the webpage: 

```
http://bazinga-tictactoe.herokuapp.com/

You can also run the game locally on a computer. First clone the repo into you computer with: 

```
git clone https://github.com/Bazinga5/tic-tac-toe.git. 
```

Then run this in shell: gradle run. And open the following url in your browser:

```
http://localhost:4567 

```


How to deploy, run and maintain
----------------

We have implemented continuous deployment.
We are using feature branching in this development and we have set up Travis to deploy automatically a new version of the game every time there is something pushed to master.

We push all new features into new branches and when we have reviewed the code and merged the pull request to master Travis see´s to the rest. And voila, we have a new feature.



