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
  public void searchForSeleniumOnGoogle_parameterFromContext() {
    // Inicializujeme instance do promennych a pozdeji je pouzijeme
    GoogleStep googleStep = createStep();
    GooglePage googlePage = createPage();

    googleStep.searchPhrase(googlePage, searchedPhraseFromContext);
    Asserts.assertUrlNotContains("google.com/search");
  }

  @Test(dataProvider = "getTestData")
  public void searchForSeleniumOnGoogle_parameterFromProvider(String searchedPhraseFromProvider) {
    // Zde neukladame instance do promennych pro pozdejsi pouziti, ale hned je pouzijeme
    // <GoogleStep> tam musi byt takto, aby vedel, jaky typ stepu ma vytvorit. V prvnim testu to vi,
    // protoze to ukladame do promenne urciteho typu.
    this.<GoogleStep>createStep().searchPhrase(createPage(), searchedPhraseFromProvider);
    Asserts.assertUrlNotContains("google.com/search");
  }

  @DataProvider
  private Object[][] getTestData() {
    String searchedPhrase = applicationContext.getEnvironment().getProperty("searchedPhrase");
    return new Object[][] {{searchedPhrase}};
  }
}
