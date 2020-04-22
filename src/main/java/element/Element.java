package element;

import general.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

  public WebElement findElementBy(By by) {
    WebDriver driver = new AbstractPage().getDriver();
    return driver.findElement(by);
  }
}
