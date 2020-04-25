package element;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends Element {

  private static final Logger LOG = LogManager.getLogger(Button.class);

  public Button(AbstractPage owner) {
    super(owner);
  }

  public void click(By by) {
    WebElement button = find(by);
    LOG.debug("Click on button: [{}]", button);
    button.click();
  }
}
