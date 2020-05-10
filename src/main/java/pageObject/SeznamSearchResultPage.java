package pageObject;

import general.AbstractPage;
import org.openqa.selenium.By;

public class SeznamSearchResultPage extends AbstractPage {

  private final By firstSearchResult = By.xpath("(//div/h3/a/span)[1]");

  @Override
  public boolean isOpen() {
    return element().isDisplayed(firstSearchResult);
  }

  public void openFirstSearchResult() {
    button().click(firstSearchResult);
  }
}
