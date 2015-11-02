package is.ru.bazinga;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ConsoleUiTest{
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("is.ru.bazinga.ConsoleUiTest");
  }
  
  @Test
  public void testPlayAgainFalse() {
    assertEquals(false, ConsoleUi.playAgain()); 
  }


  @Test
  public void testPlayAgainTrue() {
    ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
    System.setIn(in);

    ConsoleUi tac = new ConsoleUi();
    assertEquals(true, ConsoleUi.playAgain());
   }

   //checks if player puts int.
  @Test
  public void testGetInt() {
    ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
    System.setIn(in);

    ConsoleUi.in = new Scanner(in);
    assertEquals(1, ConsoleUi.getInt());
  }

  //checks if player puts in char
  @Test
  public void testGetChar() {
    ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
    System.setIn(in);

    ConsoleUi.in = new Scanner(in);
    assertEquals('y', ConsoleUi.getChar());
  }

  @Test
  public void testGetCharAgain() {
    ByteArrayInputStream in = new ByteArrayInputStream("c".getBytes());
    System.setIn(in);

    ConsoleUi.in = new Scanner(in);
    assertEquals('c', ConsoleUi.getChar());
  }
}
