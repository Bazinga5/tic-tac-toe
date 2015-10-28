package is.ru.bazinga;

public class Tic {
  private static int ROWS = 3;
  private static int COLUMNS = 3;
  public char[][] board;

  //Create a new instance of board and call a function to initialize it
  public Tic(){
    board = new char[ROWS][COLUMNS];
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

  //to check if the cell is empty or not
  public boolean isEmpty(int row, int col) {
    if (board[row][col] == 'e'){
      return true;
    }
    
    return false;
  }
}

