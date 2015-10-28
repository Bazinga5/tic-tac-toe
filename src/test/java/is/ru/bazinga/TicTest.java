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

   @Test
  public void testSwitchPlayer() {
    Tic tic = new Tic();

    assertEquals('o', tic.switchPlayer());
    assertEquals('x', tic.switchPlayer());
  }
}


