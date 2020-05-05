package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.Asserts;

public class GooglePage extends AbstractPage {

  private final By searchBar = By.name("q");
  private final By searchButton = By.xpath("(//center/input[@value='Hledat Googlem'])[1]");

  private static final Logger LOG = LogManager.getLogger(GooglePage.class);

  @Override
  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public GooglePage openGooglePage() {
    LOG.debug("Opening Google in browser");
    getDriver().get("https://www.google.cz");
    Asserts.assertIsOpen(this);
    return this;
  }

  public GoogleSearchResultPage typeAndSearch(String searchPhrase) {
    LOG.debug("Typing search phrase on Google");
    input().setValue(searchBar, searchPhrase);
    LOG.debug("Search for phrase");
    button().click(searchButton);
    return new GoogleSearchResultPage();
  }
}
