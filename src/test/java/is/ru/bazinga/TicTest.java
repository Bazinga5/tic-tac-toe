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
}
