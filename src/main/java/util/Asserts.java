package util;

import config.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Asserts {

  private static final Logger LOG = LogManager.getLogger(Asserts.class);

  public void assertUrlContains(String phrase) {
    LOG.debug("Asserting that current url contains phrase: [{}]", phrase);
    Assert.assertTrue(DriverFactory.getInstance().getDriver().getCurrentUrl().contains(phrase));
  }

  public void assertUrlNotContains(String phrase) {
    LOG.debug("Asserting that current url doesn't contain phrase: [{}]", phrase);
    Assert.assertFalse(DriverFactory.getInstance().getDriver().getCurrentUrl().contains(phrase));
  }
}
