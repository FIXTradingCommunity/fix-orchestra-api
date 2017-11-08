/**
 * 
 */
package io.fixprotocol.orchestraAPI.store;

/**
 * @author Don Mendelson
 *
 */
public class DuplicateKeyException extends RepositoryStoreException {

  private static final long serialVersionUID = 3186550085226621627L;

  /**
   * 
   */
  public DuplicateKeyException() {
  }

  /**
   * @param message
   */
  public DuplicateKeyException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public DuplicateKeyException(Throwable cause) {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public DuplicateKeyException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public DuplicateKeyException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
