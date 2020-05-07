package general;

import config.DriverFactory;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterMethod;

@Component
public class AbstractTest {

  @AfterMethod
  protected void teardown() {
    DriverFactory.quitDriver();
  }
}
