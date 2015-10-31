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
  public Tic(){
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
  public char switchPlayer(){

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

  //check if the move is valid, aka inside the board
  public boolean validMove(int row, int col) {

    //check if the board is full and a tie
    if(count > 9){
      System.out.println("Tie! Game Over!");
      return true;
    }
    //if not in the board return false
    if (row > 3 || col > 3 || row < 0 || col < 0) {
      return false;
    }
    return true;
  }

   //message for invalid move, let´s player choose again.
  public void notValidMove(int place){
    System.out.println("Not a valid move, please choose again");
    placeMark(place);
  }

   public static void illegalMove(){
    System.out.println("Not a valid move, please choose again");
  }

   //places players mark on the right place
  public void placeMark(int place){

    switch(place){

      case 1: if(!isEmpty(0, 0)){
        notValidMove(place);
        break;
      }
      board[0][0] = player;
      count++;
      break;
      case 2: if(!isEmpty(0, 1)){
        notValidMove(place);
        break;
      }
      board[0][1] = player;
      count++;
      break;
      case 3: if(!isEmpty(0, 2)){
        notValidMove(place);
        break;
      }
      board[0][2] = player;
      count++;
      break;
      case 4: if(!isEmpty(1, 0)){
        notValidMove(place);
        break;
      }
      board[1][0] = player;
      count++;
      break;
      case 5: if(!isEmpty(1, 1)){
        notValidMove(place);
        break;
      }
      board[1][1] = player;
      count++;
      break;
      case 6: if(!isEmpty(1, 2)){
        notValidMove(place);
        break;
      }
      board[1][2] = player;
      count++;
      break;
      case 7: if(!isEmpty(2, 0)){
        notValidMove(place);
        break;
      }
      board[2][0] = player;
      count++;
      break;
      case 8: if(!isEmpty(2, 1)){
        notValidMove(place);
        break;
      }board[2][1] = player;
      count++;
      break;
      case 9: if(!isEmpty(2, 2)){
        notValidMove(place);
        break;
      }
      board[2][2] = player;
      count++;
      break;
      default: notValidMove(place);
      break;
    }

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

  public void printBoard(){
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        System.out.print(board[i][j] + ' ');
      }

      System.out.println();
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
      illegalMove();
    }

    return in.nextInt();
  }
}
