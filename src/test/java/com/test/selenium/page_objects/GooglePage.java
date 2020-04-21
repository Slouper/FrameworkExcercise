package com.test.selenium.page_objects;

import com.test.selenium.general.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage extends AbstractPage {
  public GooglePage(WebDriver driver) {
    super(driver);
  }

  private final By searchBar = By.name("q");
  private final By searchButton = By.xpath("(//center/input[@value='Hledat Googlem'])[1]");
  private final By firstSearchResult = By.xpath("(//div//a/h3)[1]");

  public void navigateToGoogle() {
    driver.get("https://www.google.cz");
    waitForElementVisibility(driver.findElement(searchBar), 20);
  }

  public void typeAndSearch(String searchPhrase) {
    driver.findElement(searchBar).sendKeys(searchPhrase);
    driver.findElement(searchButton).click();
  }

  public void openFirstSearchResult() {
    waitForElementClickability(driver.findElement(firstSearchResult), 10);
    driver.findElement(firstSearchResult).click();
  }
}
