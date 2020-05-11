package fw.test.seznam;

import fw.general.AbstractTest;
import fw.pageObject.SeznamPage;
import fw.test.seznam.step.SeznamStep;
import fw.utils.Asserts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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
}
