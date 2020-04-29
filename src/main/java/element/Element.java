package element;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
    return find(by).isDisplayed();
  }

  public void waitForElementVisibility(By by) {
    LOG.debug("Waiting for element visibility: [{}]", by);
    getOwner().fluentWait().until(ExpectedConditions.visibilityOf(find(by)));
  }

  public void waitForElementToBeClickable(By by) {
    LOG.debug("Waiting for element to be clickable: [{}]", by);
    try {
      getOwner().fluentWait().until(ExpectedConditions.elementToBeClickable(find(by)));
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      getOwner().fluentWait().until(ExpectedConditions.elementToBeClickable(find(by)));
    }
  }

  public void waitForPageTitleContains(String phrase) {
    LOG.debug("Waiting for page title contains: [{}]", phrase);
    getOwner().fluentWait().until(ExpectedConditions.titleContains(phrase));
  }
}
