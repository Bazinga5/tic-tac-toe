package is.ru.bazinga;

public class Tic {
  private static int ROWS = 3;
  private static int COLUMNS = 3;
  public char[][] board;
  public char player; 

  //Create a new instance of board and call a function to initialize it
  public Tic(){
    board = new char[ROWS][COLUMNS];
    player = 'x';
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
}

