package test;

import general.AbstractTest;
import org.testng.annotations.Test;
import pageObject.SeznamPage;
import utils.Asserts;

public class SeznamTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnSeznam() {
    new SeznamPage().openSeznamPage().typeAndSearch("Selenium").openFirstSearchResult();
    new Asserts().assertUrlNotContains("seznam");
  }
}
