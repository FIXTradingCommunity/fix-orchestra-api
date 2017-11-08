/**
 * 
 */
package io.fixprotocol.orchestraAPI.store;

/**
 * @author Don Mendelson
 *
 */
public class RepositoryStoreException extends Exception {

  private static final long serialVersionUID = -8041115372486614052L;

  /**
   * 
   */
  public RepositoryStoreException() {
  }

  /**
   * @param message
   */
  public RepositoryStoreException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public RepositoryStoreException(Throwable cause) {
    super(cause);
   }

  /**
   * @param message
   * @param cause
   */
  public RepositoryStoreException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public RepositoryStoreException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
   }

}
