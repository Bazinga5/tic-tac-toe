Design Report for Tic-Tac-Toe
==============================

The assignment
----------------
For this assignment we chose to apply the agile methodology and TDD and feature branch workflow on GitHub. Our assignment was to create a simple version of the classic game Tic Tac Toe. 

About the game
----------------
Tic Tac Toe is a two player game played on a 3x3 grid. The first player is assigned the mark 'x' and second player is assigned the mark 'o'. The player who gets a complete row, horizontal, vertical or a diagonal line of 'x' or 'o' wins the game. There is a possibility of a tie between players if the players have not yet reach a winning row after filling up the grid.

About our design 
----------------
We choose to implement the a simple version of this game. A two player human vs. human game. As the game develops we thought that we could also implement a human vs. computer game but that feature is not included in this version. The design is simple and user friendly. 

The web look is a very simple grid where the players take turns pushing a slot on the grid and X or O appears. Players are welcomed with the text: 

Inline-style:
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/empty.jpg"  width="400">


When for example player x wins, the the game prints out the winner with the text and the restart button is activated:

Inline-style:
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/tie.jpg"  width="400">

When there is a tie between the players, the tie screen appears and the restart button is activated:

Inline-style:
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/xwins.jpg"  width="400">


Code guidelines
----------------

*KISS - keep it simple stupid
*DRY - dont repeat yourself
*SSR - single responsability rule

Brackest should be beside a function and then below the last line in the function. 
Space before and after each opareator. 
Space after for, while, if and similar statements. 
Comments should be placed above functions but not below. 
Indent should be used. (find better decription)
We are using Camel casing for functions and variables and Pascal casing for classes.

Pair Programming
------------------
We plan to implement the XP methodology "pair programming" quite a bit for this project. Pair programming tends to produce higher quality design, everybody gains a working knowldedge of the entire codebase and the pair is more likely to "do the right thing".

GitHub rules
----------------
The person who pushed somehing into the master is not the person to merge  when pushing code. 
A new branch should be created when working on each feature and then deleted when it has been merged with the master. 
As small changes should be pushed/commited each time. 
You should try to minimum or avoid pushing something from the branch master. 
Nothing will be merged with the master unless it workes on the feature branch, Gradle and Travis  .... (more detail needed).

Classes
----------------
We started to work the assignment in one class. We addded one and one function to the class until we had all the functions that we thought we needed. Then we analysed each function and sorted them into two classes, ConsoleUI and TicTacToe. ConsoleUI is used for functions that "talk" to the console, either get inputs from the console or write something to the console. TicTacToe is used for the functions that then use the input from the functions from ConsoleUI.

Final class diagram
----------------
//picture of diagram
