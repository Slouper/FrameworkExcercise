package fw.pageObject;

import fw.general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SeznamEmailPage extends AbstractPage {

  private final By emailLogo = By.xpath("//a[@id='logo']");

  private static final Logger LOG = LogManager.getLogger(SeznamEmailPage.class);

  @Override
  public boolean isOpen() {
    return element().isDisplayed(emailLogo);
  }
}
