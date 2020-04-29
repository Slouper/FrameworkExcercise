package element;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Button extends Element {

  private static final Logger LOG = LogManager.getLogger(Button.class);

  public Button(AbstractPage owner) {
    super(owner);
  }

  public void click(By by) {
    waitForElementToBeClickable(by);
    LOG.debug("Click on button: [{}]", by);
    try {
      find(by).click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      find(by).click();
    }
  }
}
