package general;

import config.DriverFactory;
import element.Button;
import element.Element;
import element.Input;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AbstractPage {

  private static final Logger LOG = LogManager.getLogger(AbstractPage.class);

  private WebDriver driver;

  public WebDriver getDriver() {
    if (driver == null) {
      driver = DriverFactory.getInstance().getDriver();
    }
    return driver;
  }

  private FluentWait<WebDriver> fluentWait() {
    return new FluentWait<>(driver).pollingEvery(Duration.ofMillis(500));
  }

  protected void waitForElementVisibility(WebElement element, int waitTimeInSeconds) {
    LOG.debug("Waiting for element visibility: [{}]", element);
    fluentWait()
        .withTimeout(Duration.ofSeconds(waitTimeInSeconds))
        .until(ExpectedConditions.visibilityOf(element));
  }

  protected void waitForElementToBeClickable(WebElement element, int waitTimeInSeconds) {
    LOG.debug("Waiting for element to be clickable: [{}]", element);
    fluentWait()
        .withTimeout(Duration.ofSeconds(waitTimeInSeconds))
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  protected void waitForPageTitleContains(String phrase, int waitTimeInSeconds) {
    LOG.debug("Waiting for page title contains: [{}]", phrase);
    fluentWait()
        .withTimeout(Duration.ofSeconds(waitTimeInSeconds))
        .until(ExpectedConditions.titleContains(phrase));
  }

  private Element element;
  private Button button;
  private Input input;

  protected Element element() {
    if (element == null) {
      element = new Element(this);
    }
    return element;
  }

  protected Button button() {
    if (button == null) {
      button = new Button(this);
    }
    return button;
  }

  protected Input input() {
    if (input == null) {
      input = new Input(this);
    }
    return input;
  }
}
