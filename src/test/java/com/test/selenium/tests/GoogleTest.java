package com.test.selenium.tests;

import com.test.selenium.general.AbstractTest;
import com.test.selenium.page_objects.GooglePage;
import org.testng.annotations.Test;

public class GoogleTest extends AbstractTest {

  @Test
  public void searchForSeleniumOnGoogle() {
    GooglePage googlePage = new GooglePage(driver);
    googlePage.navigateToGoogle();
    googlePage.typeAndSearch("Selenium");
    googlePage.openFirstSearchResult();
  }
}
