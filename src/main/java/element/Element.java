package element;

import general.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element {

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
}
