package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SeznamPage extends AbstractPage {

  private final By searchBar = By.xpath("//div/label/input[@name='q']");
  private final By searchButton = By.xpath("//form/button[text()='Vyhledat']");

  private static final Logger LOG = LogManager.getLogger(SeznamPage.class);

  public SeznamPage navigateToSeznam() {
    LOG.debug("Opening Seznam in browser");
    getDriver().get("https://www.seznam.cz");
    waitForElementVisibility(getDriver().findElement(searchBar), 25);
    return this;
  }

  public SeznamSearchResultPage typeAndSearch(String searchPhrase) {
    LOG.debug("Typing search phrase on Seznam");
    getDriver().findElement(searchBar).sendKeys(searchPhrase);
    LOG.debug("Search for phrase");
    button.performClickBy(searchButton);
    return new SeznamSearchResultPage();
  }
}
