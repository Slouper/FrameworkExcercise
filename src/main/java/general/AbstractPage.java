package general;

import config.DriverFactory;
import element.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

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
    driver.close();
    driver.quit();
  }

  public Button button = new Button();
}
