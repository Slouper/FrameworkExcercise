package fw.test.google;

import fw.general.AbstractTest;
import fw.pageObject.GooglePage;
import fw.test.google.step.GoogleStep;
import fw.utils.Asserts;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class GoogleTest extends AbstractTest {

  @Value("${searchedPhrase}")
  private String searchedPhraseFromContext;

  @Test
  public void searchOnGoogle_parameterFromContext() {
    // Inicializujeme instance do promennych a pozdeji je pouzijeme
    GoogleStep googleStep = createStep();
    GooglePage googlePage = createPage();

    googleStep.searchPhrase(googlePage, searchedPhraseFromContext);
    Asserts.assertUrlNotContains("google.com/search");
  }

  @Test(dataProvider = "getTestLoginData")
  public void loginWithGoogleAccount(String email, String password) {
    this.<GoogleStep>createStep().login(createPage(), email, password);
    Asserts.assertIsOpen(createPage(GooglePage.class));
  }

  @DataProvider
  private Object[][] getTestLoginData() {
    String email = applicationContext.getEnvironment().getProperty("email");
    String password = applicationContext.getEnvironment().getProperty("password");
    return new Object[][] {{email, password}};
  }
}
