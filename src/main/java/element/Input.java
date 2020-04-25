package element;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Input extends Element {

  private static final Logger LOG = LogManager.getLogger(Input.class);

  public Input(AbstractPage owner) {
    super(owner);
  }

  public void setValue(By by, String insertedValue) {
    WebElement input = find(by);
    LOG.debug("Set value: [{}] to input: [{}]", insertedValue, input);
    input.sendKeys(insertedValue);
  }
}
