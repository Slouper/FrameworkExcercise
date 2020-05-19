package fw.utils;

import static java.lang.String.format;

import fw.config.DriverFactory;
import fw.exceptions.PageIsNotOpenException;
import fw.general.AbstractPage;
import org.testng.Assert;

public class Asserts {

  public static void assertUrlContains(String phrase) {
    Assert.assertTrue(
        DriverFactory.getDriver().getCurrentUrl().contains(phrase),
        "Current URL does not contain [" + phrase + "]");
  }

  public static void assertUrlNotContains(String phrase) {
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
