package test;

import general.AbstractTest;
import org.testng.annotations.Test;
import pageObject.SeznamPage;
import utils.Asserts;
import exceptions.PageIsNotOpenException;

public class SeznamTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnSeznam() throws PageIsNotOpenException {
    new SeznamPage().openSeznamPage().typeAndSearch("Selenium").openFirstSearchResult();
    new Asserts().assertUrlNotContains("seznam");
  }
}
