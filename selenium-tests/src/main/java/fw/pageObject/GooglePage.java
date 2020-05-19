package fw.pageObject;

import fw.general.AbstractPage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

public class GooglePage extends AbstractPage {

  private final By searchBar = By.name("q");
  private final By searchButton = By.xpath("(//center/input[@value='Hledat Googlem'])[1]");
  private final By loginButton = By.xpath("//a[text()='Přihlásit se']");

  @Value("${googleHomePageUrl}")
  private String googleHomePageUrl;

  @Override
  public boolean isOpen() {
    return element().isDisplayed(searchBar);
  }

  public GooglePage openGooglePage() {
    getDriver().get(googleHomePageUrl);
    return this;
  }

  public GoogleSearchResultPage typeAndSearch(String searchPhrase) {
    input().setValue(searchBar, searchPhrase);
    button().click(searchButton);
    return new GoogleSearchResultPage();
  }

  public GoogleLoginPage goToLoginPage() {
    button().click(loginButton);
    return new GoogleLoginPage();
  }
}
