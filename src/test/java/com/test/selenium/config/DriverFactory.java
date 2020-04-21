package com.test.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

  private WebDriver driver;

  private void createDriver() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    this.driver = new ChromeDriver();
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  private void initDriver() {
    if (this.driver == null) {
      createDriver();
    }
  }

  public DriverFactory() {
    initDriver();
  }
}
