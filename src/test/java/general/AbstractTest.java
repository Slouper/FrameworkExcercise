package general;

import config.DriverFactory;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@Component
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

  @AfterMethod
  protected void teardown() {
    DriverFactory.quitDriver();
  }
}
