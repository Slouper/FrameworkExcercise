package test;

import general.AbstractTest;
import org.testng.annotations.Test;
import pageObject.GooglePage;
import utils.Asserts;
import exceptions.PageIsNotOpenException;

public class GoogleTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnGoogle() throws PageIsNotOpenException {
    new GooglePage().openGooglePage().typeAndSearch("Selenium").openFirstSearchResult();
    new Asserts().assertUrlNotContains("google");
  }
}
