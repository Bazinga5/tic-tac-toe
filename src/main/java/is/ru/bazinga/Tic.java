package is.ru.bazinga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Tic {
  public static Scanner in = new Scanner(System.in);
  private static int ROWS = 3;
  private static int COLUMNS = 3;
  public char[][] board;
  public char player;
  public int count;

  //Create a new instance of board and call a function to initialize it
  public Tic() {
    board = new char[ROWS][COLUMNS];
    player = 'x';
    count = 0;
    initializeBoard();
  }

  //Loop through rows and columns and initialize all sets to '-'
  private void initializeBoard() {
    for (int i = 0; i < ROWS;  i++) {
      for (int j = 0; j < COLUMNS; j++) {
        board[i][j] = '-';
      }
    }
  }
  //change players mark, to see which player is next up, possible to make the
  //function cout something about who's turn it is
  public char switchPlayer() {

    if (player == 'x'){
      player = 'o';
    }
    else{
      player = 'x';
    }
    return player; 
  }

  //to check if the cell is empty or not
  public boolean isEmpty(int row, int col) {
    if (board[row][col] == '-'){
      return true;
    }
    return false;
  }

  //message for invalid move, let´s player choose again.
  public static void notValidMove() {
    System.out.println("Not a valid move, please choose again");
  }

  public static boolean inBounds(int[] pos) {
    return pos[0] < 4 && pos[1] < 4 && pos[0] >= 0 && pos[1] >= 0;
  }

   //places players mark on the right place
   public void placeMark(int place) {
    int[] pos = getBoardPosition(place);

    if(inBounds(pos) && isEmpty(pos[0], pos[1])){
      board[pos[0]][pos[1]] = player;
      count++;
      return;
    }

    notValidMove();
  }

  public boolean isWinner () {

    for (int i = 0 ; i < ROWS ; i++){
      if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
        if(board[0][i] != '-'){
          return true;
        }
      }
      else if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
        if(board[i][0] != '-'){
          return true;
        }
      }
    }

    if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
        if(board[0][0] != '-'){
          return true;

        }
    }
    else if(board[0][2] == board[1][1] && board[0][2]== board[2][0]){
        if(board[0][2] != '-'){
          return true;
        }
    }
    return false;
  }

  public void printBoard() {
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        System.out.print(board[i][j] + ' ');
      }
      System.out.println();
    }
  }
  public static boolean newGame() {
    System.out.print("Again? ");
    char playAgain = getChar();
    return playAgain == 'y' || playAgain == 'Y';
  }
  
  public static int[] getBoardPosition(int place) {
    int[] position = new int[2];

    switch (place) {
    case 1:
      position[0] = 0;
      position[1] = 0;
      break;
    case 2:
      position[0] = 0;
      position[1] = 1;
      break;
    case 3:
      position[0] = 0;
      position[1] = 2;
      break;
    case 4:
      position[0] = 1;
      position[1] = 0;
      break;
    case 5:
      position[0] = 1;
      position[1] = 1;
      break;
    case 6:
      position[0] = 1;
      position[1] = 2;
      break;
    case 7:
      position[0] = 2;
      position[1] = 0;
      break;
    case 8:
      position[0] = 2;
      position[1] = 1;
      break;
    case 9:
      position[0] = 2;
      position[1] = 2;
      break;
    default:
      position[0] = -1;
      position[1] = -1;
      break;
    }

    return position;
  }

  public void openingGreeting() {
    System.out.println("Welcome to a simple game of tic-tac-toe.");
    System.out.println("The squares are numbered from 1 - 9 (like on a phone).");
    System.out.println("X is the first player. X make your move.");
    System.out.println("| 1  2  3 |\n| 4  5  6 |\n| 7  8  9 |");
    System.out.println("May the force be with you.");
  }

  protected String gameOverMessage() {
    if (count < 9) {
      switchPlayer();
      return "Winner: " + player;
    } else {
      return "Tie!";
    }
  }

  protected static char getChar() {
    char c = '\0';

    try {
      c = (char) System.in.read();
    } catch(Exception ex) {}

    return c;
  }

  protected static int getInt() {
    while (!in.hasNextInt()) {
      in.next();
      notValidMove();
    }

    return in.nextInt();
  }
}
