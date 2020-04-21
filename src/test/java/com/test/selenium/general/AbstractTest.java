package com.test.selenium.general;

import com.test.selenium.config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

  protected WebDriver driver;

  private static final int PAGE_LOAD_TIMEOUT = 120;
  private static final int IMPLICIT_WAIT_TIME = 25;

  @BeforeMethod
  protected void beforeMethod() {
    this.driver = new DriverFactory().getDriver();
    this.driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    this.driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    this.driver.manage().window().maximize();
  }

  @AfterMethod
  protected void afterMethod() {
    this.driver.close();
    this.driver.quit();
  }
}
