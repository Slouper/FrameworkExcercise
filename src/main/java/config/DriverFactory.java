package config;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

  private static final int PAGE_LOAD_TIMEOUT = 120;
  private static final int IMPLICIT_WAIT_TIME = 25;

  private static final Logger LOG = LogManager.getLogger(DriverFactory.class);

  private DriverFactory() {}

  private static final DriverFactory instance = new DriverFactory();

  public static DriverFactory getInstance() {
    return instance;
  }

  ThreadLocal<WebDriver> driver =
      ThreadLocal.withInitial(() -> {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return configDriver(driver);
      });

  public WebDriver getDriver() {
    return driver.get();
  }

  public void quitDriver() {
    try {
      driver.get().close();
      driver.get().quit();
      driver.remove();
    } catch (Exception exception) {
      LOG.error("Exception on closing webdriver: ", exception);
    }
  }

  private static WebDriver configDriver(WebDriver driver) {
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    return driver;
  }
}
