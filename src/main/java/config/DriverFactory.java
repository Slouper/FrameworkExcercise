package config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

  private static final int PAGE_LOAD_TIMEOUT = 120;
  private static final int IMPLICIT_WAIT_TIME = 25;

  public static WebDriver createDriver() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    return configDriver(driver);
  }

  private static WebDriver configDriver(WebDriver driver) {
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    return driver;
  }
}
