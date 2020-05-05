package pageObject;

import exceptions.PageIsNotOpenException;
import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.Asserts;

public class SeznamPage extends AbstractPage {

  private final By searchBar = By.xpath("//div/label/input[@name='q']");
  private final By searchButton = By.xpath("//form/button[text()='Vyhledat']");

  private static final Logger LOG = LogManager.getLogger(SeznamPage.class);

  @Override
  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public SeznamPage openSeznamPage() throws PageIsNotOpenException {
    LOG.debug("Opening Seznam in browser");
    getDriver().get("https://www.seznam.cz");
    Asserts.assertIsOpen(this);
    return this;
  }

  public SeznamSearchResultPage typeAndSearch(String searchPhrase) {
    LOG.debug("Typing search phrase on Seznam");
    input().setValue(searchBar, searchPhrase);
    LOG.debug("Search for phrase");
    button().click(searchButton);
    return new SeznamSearchResultPage();
  }
}
