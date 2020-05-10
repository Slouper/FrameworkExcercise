package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SeznamPage extends AbstractPage {

  private final By searchBar = By.xpath("//div/label/input[@name='q']");
  private final By searchButton = By.xpath("//form/button[text()='Vyhledat']");

  private static final Logger LOG = LogManager.getLogger(SeznamPage.class);

  @Override
  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public SeznamPage openSeznamPage() {
    getDriver().get("https://www.seznam.cz");
    return this;
  }

  public SeznamSearchResultPage typeAndSearch(String searchPhrase) {
    input().setValue(searchBar, searchPhrase);
    button().click(searchButton);
    return new SeznamSearchResultPage();
  }
}
