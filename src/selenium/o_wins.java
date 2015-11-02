package is.ru.bazinga;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class OWins {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://bazinga-tictactoe.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testOWins() throws Exception {
    // o_wins
    driver.get(baseUrl + "/");
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //table[@id='board']/tbody/tr[1]/td[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //table[@id='board']/tbody/tr[1]/td[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //table[@id='board']/tbody/tr[1]/td[3] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //table[@id='board']/tbody/tr[2]/td[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //table[@id='board']/tbody/tr[2]/td[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //table[@id='board']/tbody/tr[3]/td[2] | ]]
    try {
      assertEquals("o wins this game!", driver.findElement(By.id("game__message")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
