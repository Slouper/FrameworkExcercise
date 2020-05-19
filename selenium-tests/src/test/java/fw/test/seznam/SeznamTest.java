package fw.test.seznam;

import fw.general.AbstractTest;
import fw.pageObject.SeznamEmailPage;
import fw.pageObject.SeznamPage;
import fw.test.seznam.step.SeznamStep;
import fw.utils.Asserts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Component
public class SeznamTest extends AbstractTest {

  @Value("${searchedPhrase}")
  private String searchedPhrase;

  @Test
  public void searchOnSeznam() {

    SeznamStep seznamStep = createStep();
    SeznamPage seznamPage = createPage();

    seznamStep.searchPhrase(seznamPage, searchedPhrase);
    Asserts.assertUrlNotContains("search.seznam.cz");
  }

  @Test(dataProvider = "getTestLoginData")
  public void loginIntoSeznamEmail(String username, String password) {
    this.<SeznamStep>createStep().login(createPage(), username, password);
    Asserts.assertIsOpen(createPage(SeznamEmailPage.class));
  }

  @DataProvider
  private Object[][] getTestLoginData() {
    String loginName = applicationContext.getEnvironment().getProperty("loginName");
    String password = applicationContext.getEnvironment().getProperty("password");
    return new Object[][] {{loginName, password}};
  }
}
