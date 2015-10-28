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
        board[i][j] = 'e';
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
    if (board[row][col] == 'e'){
      return true;
    }
    return false;
  }
  
  //check if the move is valid, aka inside the board
  public boolean validMove(int row, int col) {

    //print out board if board is full and return false
    if(count >= 9){
      System.out.println("Board is full");
      return false; 
    }

    if (row > 4 || col > 4 || row < 0 || col < 0) {
      return false;
    }

    return true; 
  }

  //places players mark on the right place
  public void placeMark (int row, int col, char player){
    board[row][col] = player;
    count++;
  }



}

