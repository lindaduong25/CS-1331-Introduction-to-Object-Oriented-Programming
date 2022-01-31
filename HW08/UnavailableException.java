/**
 * This class contains Exception that will throw when food is out of stock
 * @author Linda Duong
 * @version 1.0
 */
public class UnavailableException extends RuntimeException {
    /**
     * Creates UnavailableException object with string message
     * @param string message
     */
    public UnavailableException(String string) {
        super(string);
    }
    /**
     * Creates UnavailableException object with super call
     */
    public UnavailableException() {
        super();
    }
}