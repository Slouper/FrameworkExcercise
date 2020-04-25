package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SeznamPage extends AbstractPage {

  private final By searchBar = By.xpath("//div/label/input[@name='q']");
  private final By searchButton = By.xpath("//form/button[text()='Vyhledat']");

  private static final Logger LOG = LogManager.getLogger(SeznamPage.class);

  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public SeznamPage navigateToSeznam() {
    LOG.debug("Opening Seznam in browser");
    getDriver().get("https://www.seznam.cz");
    waitForElementVisibility(element().find(searchBar), 25);
    return this;
  }

  public SeznamSearchResultPage typeAndSearch(String searchPhrase) {
    LOG.debug("Typing search phrase on Seznam");
    input().setValue(searchBar, searchPhrase);
    LOG.debug("Search for phrase");
    button().click(searchButton);
    waitForPageTitleContains(searchPhrase, 20);
    return new SeznamSearchResultPage();
  }
}
