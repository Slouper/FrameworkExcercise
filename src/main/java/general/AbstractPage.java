package general;

import config.DriverFactory;
import element.Button;
import element.Element;
import element.Input;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage {

  private static final int WAIT_TIME = 20;

  private WebDriver driver;

  private static FluentWait<WebDriver> fluentWait;

  public abstract boolean isOpen();

  public WebDriver getDriver() {
    if (driver == null) {
      driver = DriverFactory.getDriver();
    }
    return driver;
  }

  public FluentWait<WebDriver> getFluentWait() {
    if (fluentWait == null) {
      fluentWait =
          new FluentWait<>(getDriver())
              .pollingEvery(Duration.ofMillis(500))
              .withTimeout(Duration.ofSeconds(WAIT_TIME));
    }
    return fluentWait;
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
