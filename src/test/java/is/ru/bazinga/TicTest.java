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
        assertEquals('e', tic.board[i][j]);
      }
    }  
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
}


