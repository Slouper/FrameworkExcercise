package general;

import org.testng.annotations.AfterMethod;

public class AbstractTest {

  @AfterMethod
  protected void afterMethod() {
    new AbstractPage().quitDriver();
  }
}
