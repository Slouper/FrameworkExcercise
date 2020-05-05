package utils;

import static java.lang.String.format;

import config.DriverFactory;
import exceptions.PageIsNotOpenException;
import general.AbstractPage;
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

  public static <P extends AbstractPage> void assertIsOpen(P page) {
    if (!page.isOpen()) {
      throw new PageIsNotOpenException(format("[%s] is not open", page.getClass().getSimpleName()));
    }
  }
}
