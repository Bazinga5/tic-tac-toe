package is.ru.bazinga;

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTest {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("is.ru.bazinga.TicTest");
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

  @Test
  public void testIsEmpty() {
    Tic tic = new Tic();
    tic.board[1][1] = 'x';
  
    assertEquals(false, tic.isEmpty(1,1));
    assertEquals(true, tic.isEmpty(2,1));
  }

  @Test
  public void testPlaceMark() {
    Tic tic = new Tic();
    tic.placeMark(1);

    assertEquals(false, tic.isEmpty(0,0));
    assertEquals(true, tic.isEmpty(2,1));
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
  
  @Test
  public void getBoardPos() {
    assertArrayEquals(new int[]{0,0}, Tic.getBoardPosition(1));
    assertArrayEquals(new int[]{2,2}, Tic.getBoardPosition(9));
  }

  @Test
  public void testInBounds() {
    int position[] = new int[2];

    position[0] = 0;
    position[1] = 1;
    assertEquals(true, Tic.inBounds(position));
    
    position[0] = 4;
    position[1] = 4;
    assertEquals(false, Tic.inBounds(position));
  }
}

