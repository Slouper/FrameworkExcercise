package test;

import general.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import pageObject.SeznamPage;
import utils.Asserts;

public class SeznamTest extends AbstractTest {

  @Autowired
  SeznamPage seznamPage;

  @Value("searchedPhrase")
  private String searchedPhrase;

  @Test
  public void searchForSeleniumOnSeznam() {
    seznamPage.openSeznamPage().typeAndSearch(searchedPhrase).openFirstSearchResult();
    new Asserts().assertUrlNotContains("seznam");
  }
}
