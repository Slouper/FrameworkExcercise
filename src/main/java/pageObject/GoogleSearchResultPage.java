package pageObject;

import general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class GoogleSearchResultPage extends AbstractPage {

  private final By firstSearchResult = By.xpath("(//div//a/h3)[1]");

  private static final Logger LOG = LogManager.getLogger(GoogleSearchResultPage.class);

  public void openFirstSearchResult() {
    waitForElementClickability(getDriver().findElement(firstSearchResult), 10);
    LOG.debug("Opening first search result");
    getDriver().findElement(firstSearchResult).click();
  }
}
