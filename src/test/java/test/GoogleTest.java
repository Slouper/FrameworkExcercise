package test;

import general.AbstractTest;
import org.testng.annotations.Test;
import pageObject.GooglePage;
import util.Asserts;

public class GoogleTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnGoogle() {
    new GooglePage().openGooglePage().typeAndSearch("Selenium").openFirstSearchResult();
    new Asserts().assertUrlNotContains("google");
  }
}
