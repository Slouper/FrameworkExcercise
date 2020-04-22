package test;

import general.AbstractTest;
import org.testng.annotations.Test;
import pageObject.GooglePage;

public class GoogleTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnGoogle() {
    new GooglePage()
        .navigateToGoogle()
        .typeAndSearch("Selenium")
        .openFirstSearchResult();
    //todo assert test
  }
}
