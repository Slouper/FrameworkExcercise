package exceptions;

public class PageIsNotOpenException extends Exception {

  public PageIsNotOpenException(String errorMessage) {
    super(errorMessage);
  }

}
