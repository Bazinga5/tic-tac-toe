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
    driver.findElement(By.xpath("//table[@id='board']/tbody/tr[1]/td[1]")).click();
    driver.findElement(By.xpath("//table[@id='board']/tbody/tr[1]/td[2]")).click();
    driver.findElement(By.xpath("//table[@id='board']/tbody/tr[1]/td[3]")).click();
    driver.findElement(By.xpath("//table[@id='board']/tbody/tr[2]/td[2]")).click();
    driver.findElement(By.xpath("//table[@id='board']/tbody/tr[2]/td[1]")).click();
    driver.findElement(By.xpath("//table[@id='board']/tbody/tr[3]/td[2]")).click();
    driver.findElement(By.cssSelector("#game__restart")).click();
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
