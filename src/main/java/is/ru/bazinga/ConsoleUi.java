package is.ru.bazinga;

import java.util.Scanner;

public class ConsoleUi extends Tic {
	public static Scanner in = new Scanner(System.in);

	public static void notValidMove() {
		System.out.println("Not a valid move, please choose again");
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j] + ' ');
			}

			System.out.println();
		}
	}

	public static boolean playAgain() {
		System.out.print("Again? ");
		char playAgain = getChar();
		return playAgain == 'y' || playAgain == 'Y';
	}

	public static void openingGreeting() {
		System.out.println("--Welcome to a simple game of tic-tac-toe.--");
		System.out.println("The squares are numbered from 1 - 9 (like on a phone).");
		System.out.println("X is the first player. X make your move.");
		System.out.println("| 1  2  3 |\n| 4  5  6 |\n| 7  8  9 |");
		System.out.println("May the force be with you.");
	}

	//Writes out who is the winner or if there is a tie.
	protected String gameOverMessage() {
		if (count < 9) {
			switchPlayer();
			return "Winner: " + player;
		} else {
			return "Tie!";
		}
	}

	//When players are offered to play a new game, reads in char.
	protected static char getChar() {
		char c = '\0';

		try {
			c = (char) System.in.read();
		} catch(Exception ex) {}

		return c;
	}

	//Needed to read int for console, where player´s going to place his mark.
	protected static int getInt() {
		while (!in.hasNextInt()) {
			in.next();
			notValidMove();
		}

		return in.nextInt();
	}
        
    //Needed due to inheritance.
	@Override
	protected void gameOver() {
		System.out.println(gameOverMessage());
	}

	@Override
	protected void display() {
		printBoard();
	}	
	
	@Override
	protected int getCurrentMove() {
		return ConsoleUi.getInt();
	}

	public static void main(String[] args) {
		do startGame();
		while (playAgain());
	}
}
