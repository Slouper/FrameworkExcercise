package util;

import config.DriverFactory;
import org.testng.Assert;

public class Asserts {

  public void assertUrlContains(String phrase) {
    Assert.assertTrue(
        DriverFactory.getDriver().getCurrentUrl().contains(phrase),
        "Current URL does not contain [" + phrase + "]");
  }

  public void assertUrlNotContains(String phrase) {
    Assert.assertFalse(
        DriverFactory.getDriver().getCurrentUrl().contains(phrase),
        "Current URL contains [" + phrase + "]");
  }

  public static void assertPageIsOpen(boolean open) {
    Assert.assertTrue(open, "Page is not open");
  }
}
