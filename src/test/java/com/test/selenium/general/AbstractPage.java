package com.test.selenium.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

  protected WebDriver driver;

  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
  }

  protected void waitForElementVisibility(WebElement element, int waitTimeInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected void waitForElementClickability(WebElement element, int waitTimeInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }
}
