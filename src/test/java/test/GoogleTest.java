package test;

import general.AbstractTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import pageObject.GooglePage;
import utils.Asserts;

public class GoogleTest extends AbstractTest {

  @Value("${searchedPhrase}")
  private String searchedPhrase;

  @Test
  public void searchForSeleniumOnGoogle() {
    new GooglePage().openGooglePage().typeAndSearch(searchedPhrase).openFirstSearchResult();
    Asserts.assertUrlNotContains("google");
  }
}
