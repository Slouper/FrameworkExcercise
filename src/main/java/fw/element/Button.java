package fw.element;

import fw.general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import fw.utils.Utils;

public class Button extends Element {

  private static final Logger LOG = LogManager.getLogger(Button.class);

  public Button(AbstractPage owner) {
    super(owner);
  }

  public void click(By by) {
    waitForElementToBeClickable(by);
    LOG.debug("Click on button: [{}]", by);
    new Utils()
        .repeatUntilSuccess(
            () -> {
              find(by).click();
            });
  }
}
