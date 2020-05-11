package fw.test;

import fw.general.AbstractTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
import fw.pageObject.SeznamPage;
import fw.utils.Asserts;

@Component
public class SeznamTest extends AbstractTest {

  @Value("${searchedPhrase}")
  private String searchedPhrase;

  @Test
  public void searchForSeleniumOnSeznam() {
    SeznamPage seznamPage = createPage();
    seznamPage.openSeznamPage().typeAndSearch(searchedPhrase).openFirstSearchResult();
    Asserts.assertUrlNotContains("seznam");
  }
}
