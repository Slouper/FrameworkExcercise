package element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.SeznamPage;

public class Button extends Element {

  private static final Logger LOG = LogManager.getLogger(SeznamPage.class);

  public void performClickBy(By by) {
    WebElement button = findElementBy(by);
    LOG.debug("Click on button [{}]", button);
    button.click();
  }
}
