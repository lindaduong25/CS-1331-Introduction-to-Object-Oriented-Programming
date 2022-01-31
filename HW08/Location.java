/**
 * This class represents a Restaurant that can print out a receipt
 * @author Linda Duong
 * @version 1.0
 */
public class Location {
    private double x;
    private double y;
    /**
     * Creates a Location object with the following parameters
     * @param x x coodinate of location
     * @param y y coordinate of location
     */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
        // if (x < 0) {
        //     this.x = -x;
        // } else {
        //     this.x = x;
        // }
        // if (y < 0) {
        //     this.y = y;
        // } else {
        //     this.y = y;
        // }
    }
    /**
     * This method calculates the distance between two locations
     * @param location location of a Location object
     * @return the distance between two locations
     */
    public double calcDistance(Location location) {

        return Math.sqrt(((y - location.y) * (y - location.y)) + ((x - location.x) * (x - location.x)));
    }

    // getter methods
    /**
     * This getter method gets the x coodinate of a location
     * @return x coordinate of location
     */
    public double getX() {
        return x;
    }
    /**
     * This getter method gets the y coodinate of a location
     * @return y coordinate of a location
     */
    public double getY() {
        return y;
    }
    // // setter methods
    // /**
    //  * This setter methods sets the x coordinate value to 0 if it's less than 0
    //  * @param x x coordinate of locationn
    //  */
    // public void setX(double x) {
    //     if (x < 0) {
    //         this.x = -1 * x;
    //     } else {
    //         this.x = x;
    //     }
    // }
    // /**
    //  * This setter methods sets the y coordinate value to 0 if it's less than 0
    //  * @param y y coordinate of locationn
    //  */
    // public void setY(double y) {
    //     if (y < 0) {
    //         this.y = -1 * y;
    //     } else {
    //         this.y = y;
    //     }
    // }
}