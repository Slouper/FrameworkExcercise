package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.Asserts;

public class SeznamSearchResultPage extends AbstractPage {

  private final By firstSearchResult = By.xpath("(//div/h3/a/span)[1]");

  private static final Logger LOG = LogManager.getLogger(SeznamSearchResultPage.class);

  @Override
  public boolean isOpen() {
    return element().isDisplayed(firstSearchResult);
  }

  public void openFirstSearchResult() {
    Asserts.assertIsOpen(this);
    LOG.debug("Opening first search result");
    button().click(firstSearchResult);
  }
}
