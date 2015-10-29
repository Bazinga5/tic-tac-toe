package is.ru.bazinga;

public class Tic {
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

  //Loop through rows and columns and initialize all sets to e
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

  //places players mark on the right place
  public void placeMark (int row, int col, char p){

    if(!isEmpty(row, col)){
      System.out.println("Not a valid move");
      //please make another move!
      return;
    }
        
    board[row][col] = p; 
    count++;

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
}