package fw.pageObject;

import fw.general.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

public class SeznamPage extends AbstractPage {

  private final By searchBar = By.xpath("//div/label/input[@name='q']");
  private final By searchButton = By.xpath("//form/button[text()='Vyhledat']");
  private final By usernameInput = By.xpath("//input[@name='username']");
  private final By passwordInput = By.xpath("//input[@name='password']");
  private final By loginButton = By.xpath("//button[text()='Přejít do Emailu']");

  private static final Logger LOG = LogManager.getLogger(SeznamPage.class);

  @Value("${seznamHomePageUrl}")
  private String seznamHomePageUrl;

  @Override
  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public SeznamPage openSeznamPage() {
    getDriver().get(seznamHomePageUrl);
    return this;
  }

  public SeznamSearchResultPage typeAndSearch(String searchPhrase) {
    input().setValue(searchBar, searchPhrase);
    button().click(searchButton);
    return new SeznamSearchResultPage();
  }

  public SeznamEmailPage fillLoginForm(String loginName, String password) {
    input().setValue(usernameInput, loginName);
    input().setValue(passwordInput, password);
    button().click(loginButton);
    return new SeznamEmailPage();
  }
}
