package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class GooglePage extends AbstractPage {

  private final By searchBar = By.name("q");
  private final By searchButton = By.xpath("(//center/input[@value='Hledat Googlem'])[1]");

  private static final Logger LOG = LogManager.getLogger(GooglePage.class);

  public GooglePage navigateToGoogle() {
    LOG.debug("Opening Google in browser");
    getDriver().get("https://www.google.cz");
    waitForElementVisibility(getDriver().findElement(searchBar), 20);
    return this;
  }

  public GoogleSearchResultPage typeAndSearch(String searchPhrase) {
    LOG.debug("Typing search phrase on Google");
    getDriver().findElement(searchBar).sendKeys(searchPhrase);
    LOG.debug("Search for phrase");
    button.performClickBy(searchButton);
    return new GoogleSearchResultPage();
  }
}
