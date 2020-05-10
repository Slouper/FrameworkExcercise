package pageObject;

import general.AbstractPage;
import org.openqa.selenium.By;

public class GoogleSearchResultPage extends AbstractPage {

  private final By firstSearchResult = By.xpath("(//div//a/h3)[1]");

  @Override
  public boolean isOpen() {
    return element().isDisplayed(firstSearchResult);
  }

  public void openFirstSearchResult() {
    button().click(firstSearchResult);
  }
}
