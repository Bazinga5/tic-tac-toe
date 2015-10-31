package is.ru.bazinga;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

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
  public void testGetChar() {
    ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
    System.setIn(in);

    Tic.in = new Scanner(in);

    assertEquals('y', Tic.getChar());
  }

  @Test
  public void testGetCharAgain() {
    ByteArrayInputStream in = new ByteArrayInputStream("c".getBytes());
    System.setIn(in);

    Tic.in = new Scanner(in);

    assertEquals('c', Tic.getChar());
  }

  @Test
  public void testGetInt() {
    ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
    System.setIn(in);

    Tic.in = new Scanner(in);

    assertEquals(1, Tic.getInt());
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
