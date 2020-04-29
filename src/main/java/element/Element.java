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

  public WebElement waitForElementVisibility(By by) {
    LOG.debug("Waiting for element visibility: [{}]", by);
    WebElement element = find(by);
    getOwner().fluentWait().until(ExpectedConditions.visibilityOf(element));
    return element;
  }

  public WebElement waitForElementToBeClickable(By by) {
    LOG.debug("Waiting for element to be clickable: [{}]", by);
    WebElement element = find(by);
    getOwner().fluentWait().until(ExpectedConditions.elementToBeClickable(element));
    return element;
  }

  public void waitForPageTitleContains(String phrase) {
    LOG.debug("Waiting for page title contains: [{}]", phrase);
    getOwner().fluentWait().until(ExpectedConditions.titleContains(phrase));
  }
}
