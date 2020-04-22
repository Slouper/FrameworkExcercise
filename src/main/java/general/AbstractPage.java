package general;

import config.DriverFactory;
import element.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.GooglePage;

public class AbstractPage {

  private static final Logger LOG = LogManager.getLogger(AbstractPage.class);

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      driver = DriverFactory.createDriver();
    }
    return driver;
  }

  protected void waitForElementVisibility(WebElement element, int waitTimeInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected void waitForElementClickability(WebElement element, int waitTimeInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void quitDriver() {
    try{
      driver.close();
      driver.quit();
    }
    catch (Exception exception) {
      LOG.error("Exception on closing webdriver: ", exception);
    }

  }

  public Button button = new Button();
}
