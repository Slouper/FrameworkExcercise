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
    LOG.debug("Click on button: [{}]", by);
    find(by).click();
  }
}
