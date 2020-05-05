package exceptions;

public class PageIsNotOpenException extends RuntimeException {

  public PageIsNotOpenException(String errorMessage) {
    super(errorMessage);
  }

}
