package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import util.Asserts;

public class GoogleSearchResultPage extends AbstractPage {

  private final By firstSearchResult = By.xpath("(//div//a/h3)[1]");

  private static final Logger LOG = LogManager.getLogger(GoogleSearchResultPage.class);

  public GoogleSearchResultPage() {
    Asserts.assertPageIsOpen(isOpen());
  }

  private boolean isOpen() {
    return element().isDisplayed(firstSearchResult);
  }

  public void openFirstSearchResult() {
    LOG.debug("Opening first search result");
    button().click(firstSearchResult);
  }
}
