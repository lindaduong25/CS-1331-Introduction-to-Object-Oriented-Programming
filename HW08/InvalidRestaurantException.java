/**
 * This class contains Exception that will throw when there is no restaurant in the CSV that matches
 * @author Linda Duong
 * @version 1.0
 */
public class InvalidRestaurantException extends RuntimeException {
    /**
     * Creates InvalidRestaurantException object
     * @param string string message
     */
    public InvalidRestaurantException(String string) {
        super(string);
    }
    /**
     * Creates InvalidRestaurantException object with own super unique message
     */
    public InvalidRestaurantException() {
        super("There is no restaurant with that name and location!");
    }
}