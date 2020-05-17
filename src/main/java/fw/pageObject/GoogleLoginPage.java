package fw.pageObject;

import fw.general.AbstractPage;
import org.openqa.selenium.By;

public class GoogleLoginPage extends AbstractPage {

  private final By emailInput = By.xpath("//input[@id='identifierId']");
  private final By nextButton = By.xpath("//span[text()='Další']");
  private final By passwordInput = By.xpath("//input[@name='password']");

  @Override
  public boolean isOpen() {
    return element().isDisplayed(emailInput);
  }

  public void fillLoginForm(String email, String password) {
    input().setValue(emailInput, email);
    button().click(nextButton);
    input().setValue(passwordInput, password);
    button().click(nextButton);
  }
}
