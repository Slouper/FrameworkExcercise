package pageObject;

import general.AbstractPage;
import org.openqa.selenium.By;

public class GooglePage extends AbstractPage {

  private final By searchBar = By.name("q");
  private final By searchButton = By.xpath("(//center/input[@value='Hledat Googlem'])[1]");

  @Override
  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public GooglePage openGooglePage() {
    getDriver().get("https://www.google.cz");
    return this;
  }

  public GoogleSearchResultPage typeAndSearch(String searchPhrase) {
    input().setValue(searchBar, searchPhrase);
    button().click(searchButton);
    return new GoogleSearchResultPage();
  }
}
