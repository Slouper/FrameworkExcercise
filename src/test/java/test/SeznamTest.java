package test;

import general.AbstractTest;
import org.testng.annotations.Test;
import pageObject.SeznamPage;

public class SeznamTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnSeznam() {
    new SeznamPage().
        navigateToSeznam()
        .typeAndSearch("Selenium")
        .openFirstSearchResult();
    //todo assert test
  }
}
