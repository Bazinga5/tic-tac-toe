Design Report for Tic-Tac-Toe
==============================

The assignment
----------------
For this assignment we chose to apply the agile methodology and TDD and feature branch workflow on Git. Our assignment was to create a simple version of the classic game Tic Tac Toe. 

About the game
----------------
Tic Tac Toe is a two player game played on a 3x3 grid. The first player is assigned the mark 'x' and second player is assigned the mark 'o'. The player who gets a complete row, horizontal, vertical or a diagonal line of 'x' or 'o' wins the game. There is a possibility of a tie between players if the players have not yet reach a winning row after filling up the grid.

About our design 
----------------
We choose to implement a simple version of this game. A two player human vs. human game. As the game develops we thought that we could also implement a human vs. computer game but that feature is not included in this version. The design is simple and user friendly. 

The web look is a very simple grid where the players take turns placing a mark on the grid and 'x' or 'o' appears. Players are welcomed with the text: 

<p align="center">
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/empty.jpg"  width="300">
</p>

When for example player x wins, the game prints out the winner with the text and the restart button appears:
<p align="center">
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/xwins.jpg"  width="300">
</p>

When there is a tie between the players, the tie screen appears and the restart button appears:
<p align="center">
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/tie.jpg"  width="300">

</p>

Classes
----------------
We started coding the assignment in one class. We kept adding functions to the class until we believed we had covered all issues. We then analysed the functions and sorted them into two classes, 'ConsoleUI' and 'TicTacToe'. 'ConsoleUI' is used for functions that "talk" to the console, either they get inputs from the console or write something to the console. 'TicTacToe' is used for the functions that then use the input from the functions from 'ConsoleUI'. 

Final class diagram
----------------

<p align="center">
<img src="https://github.com/Bazinga5/tic-tac-toe/blob/master/markdown/diagram.jpg"  width="450">
</p>
