package fw.utils;

public class Utils {

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
