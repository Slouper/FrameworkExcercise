package element;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Input extends Element {

  private static final Logger LOG = LogManager.getLogger(Input.class);

  public Input(AbstractPage owner) {
    super(owner);
  }

  public void setValue(By by, String insertedValue) {
    LOG.debug("Set value: [{}] to input: [{}]", insertedValue, by);
    find(by).sendKeys(insertedValue);
  }
}
