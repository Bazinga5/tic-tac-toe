package is.ru.bazinga;

public class Tic {
  private static int ROWS = 3;
  private static int COLUMNS = 3;
  public char[][] board;
  public char player;
  public int count;
  protected int currentMove;

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

  protected void greet() {}
  protected void display() {}
  protected void gameOver() {}

  protected int getCurrentMove() {
    return currentMove;
  }

  protected static void startGame() {
    Tic game = new Tic();
    game.greet();
    game.display();

    while (game.count < 9 && !game.isWinner()) {
      game.placeMark(game.getCurrentMove());
      game.switchPlayer();
      game.display();
    } 

    game.gameOver();
  }
}

