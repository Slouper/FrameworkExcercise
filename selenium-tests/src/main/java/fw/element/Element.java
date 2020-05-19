package fw.element;

import fw.general.AbstractPage;
import fw.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Element {

  private static final Logger LOG = LogManager.getLogger(Element.class);

  private final AbstractPage owner;

  public Element(AbstractPage owner) {
    this.owner = owner;
  }

  public AbstractPage getOwner() {
    return owner;
  }

  public WebElement find(By by) {
    return getOwner().getDriver().findElement(by);
  }

  public boolean isDisplayed(By by) {

    try {
      find(by).isDisplayed();
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void waitForElementVisibility(By by) {
    LOG.debug("Waiting for element visibility: [{}]", by);
    Utils.repeatUntilSuccess(
        () -> getOwner().getFluentWait().until(ExpectedConditions.visibilityOf(find(by))));
  }

  public void waitForElementToBeClickable(By by) {
    LOG.debug("Waiting for element to be clickable: [{}]", by);
    Utils.repeatUntilSuccess(
        () -> getOwner().getFluentWait().until(ExpectedConditions.elementToBeClickable(find(by))));
  }

  public void waitForPageTitleContains(String phrase) {
    LOG.debug("Waiting for page title contains: [{}]", phrase);
    getOwner().getFluentWait().until(ExpectedConditions.titleContains(phrase));
  }

  public void waitForPageToLoad() {
    LOG.debug("Waiting for complete load of the current page");
    getOwner()
        .getFluentWait()
        .until(
            driver ->
                String.valueOf(
                        ((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete"));
  }
}
