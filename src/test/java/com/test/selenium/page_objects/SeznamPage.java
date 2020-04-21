package com.test.selenium.page_objects;

import com.test.selenium.general.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeznamPage extends AbstractPage {
  public SeznamPage(WebDriver driver) {
    super(driver);
  }

  private final By searchBar = By.xpath("//div/label/input[@name='q']");
  private final By searchButton = By.xpath("//form/button[text()='Vyhledat']");
  private final By firstSearchResult = By.xpath("(//div/h3/a/span)[1]");

  public void navigateToSeznam() {
    driver.get("https://www.seznam.cz");
    waitForElementVisibility(driver.findElement(searchBar), 25);
  }

  public void typeAndSearch(String searchPhrase) {
    driver.findElement(searchBar).sendKeys(searchPhrase);
    driver.findElement(searchButton).click();
  }

  public void openFirstSearchResult() {
    waitForElementClickability(driver.findElement(firstSearchResult), 15);
    driver.findElement(firstSearchResult).click();
  }
}
