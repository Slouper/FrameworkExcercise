package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SeznamSearchResultPage extends AbstractPage {

  private final By firstSearchResult = By.xpath("(//div/h3/a/span)[1]");

  private static final Logger LOG = LogManager.getLogger(SeznamSearchResultPage.class);

  public void openFirstSearchResult() {
    waitForElementClickability(getDriver().findElement(firstSearchResult), 15);
    LOG.debug("Opening first search result");
    getDriver().findElement(firstSearchResult).click();
  }
}
