package com.test.selenium.tests;

import com.test.selenium.general.AbstractTest;
import com.test.selenium.page_objects.SeznamPage;
import org.testng.annotations.Test;

public class SeznamTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnSeznam() {
    SeznamPage seznamPage = new SeznamPage(driver);
    seznamPage.navigateToSeznam();
    seznamPage.typeAndSearch("Selenium");
    seznamPage.openFirstSearchResult();
  }
}
