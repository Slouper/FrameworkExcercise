package general;

import config.DriverFactory;
import org.testng.annotations.AfterMethod;

public class AbstractTest {

  @AfterMethod
  protected void teardown() {
    DriverFactory.getInstance().quitDriver();
  }
}
