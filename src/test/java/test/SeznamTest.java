package test;

import general.AbstractTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import pageObject.SeznamPage;
import utils.Asserts;

public class SeznamTest extends AbstractTest {

  @Value("${searchedPhrase}")
  private String searchedPhrase;

  @Test
  public void searchForSeleniumOnSeznam() {
    new SeznamPage().openSeznamPage().typeAndSearch(searchedPhrase).openFirstSearchResult();
    Asserts.assertUrlNotContains("seznam");
  }
}
