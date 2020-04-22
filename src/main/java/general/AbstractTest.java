package general;

import org.testng.annotations.AfterMethod;

public class AbstractTest {

  @AfterMethod
  protected void afterMethod() {
    AbstractPage abstractPage = new AbstractPage();
    abstractPage.quitDriver();
  }
}
