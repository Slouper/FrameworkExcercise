package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

  private static final Logger LOG = LogManager.getLogger(Utils.class);

  public void repeatUntilSuccess(CustomAction customAction) {
    int attempt = 0;
    while (attempt < 5) {
      try {
        customAction.perform();
        break;
      } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
      }
      sleep(100);
      attempt++;
    }
  }

  @FunctionalInterface
  public interface CustomAction {
    void perform();
  }

  public final void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
