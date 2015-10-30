package is.ru.bazinga;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTest {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("is.ru.bazinga.TicTest");
  }

  @Test
  public void shouldBeZero() {
    assertEquals(0, 0);
  }

  @Test
  public void testInitializeBoard() {
    Tic tic = new Tic();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        assertEquals('-', tic.board[i][j]);
      }
    }
  }

   @Test
  public void testSwitchPlayer() {
    Tic tic = new Tic();

    assertEquals('o', tic.switchPlayer());
    assertEquals('x', tic.switchPlayer());
  }

  //test if a cell is empty or not. 
  @Test
  public void testIsEmpty() {

    Tic tic = new Tic();
    tic.board[1][1] = 'x';
  
    //testing false and true
    assertEquals(false, tic.isEmpty(1,1));
    assertEquals(true, tic.isEmpty(2,1));
  }

  @Test
  public void testPlaceMark() {

    Tic tic = new Tic();
    //place mark of current player
    tic.placeMark(1);

    assertEquals(false, tic.isEmpty(0,0));
    assertEquals(true, tic.isEmpty(2,1));
  }

  @Test
  public void testValidMove() {

    Tic tic = new Tic();
    assertEquals(true, tic.validMove(1,1));
    assertEquals(false, tic.validMove(3,5));
  }

  @Test
  public void testNoWinner() {

    Tic tic = new Tic();
    tic.board[0][0] = 'x';
    tic.board[0][1] = 'x';
    tic.board[0][2] = 'o';

    assertEquals(false, tic.isWinner());
  }

  @Test
  public void testIsWinner() {

    Tic tic = new Tic();
    tic.board[0][0] = 'x';
    tic.board[0][1] = 'x';
    tic.board[0][2] = 'x';

    assertEquals(true, tic.isWinner());
   }

}


