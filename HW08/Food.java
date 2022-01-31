/**
 * This class represents a Restaurant that can print out a receipt
 * @author Linda Duong
 * @version 1.0
 */
public class Food {
    private String name;
    private int quantity;
    private double price;
    /**
     * Creates a Food object with the following parameters
     * @param name name of food
     * @param quantity quantity of food
     * @param price price of food
     */
    public Food(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // getter methods
    /**
     * This getter method gets the name of the food item
     * @return name of food item
     */
    public String getName() {
        return name;
    }
    /**
     * This getter method gets the quanity of the food item
     * @return quantity of food item
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * This getter method gets the price of the food item
     * @return price of the food item
     */
    public double getPrice() {
        return price;
    }

    // setter method
    /**
     * This setter method sets the quanity of the food item
     * @param quantity quantity of food item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This toString() method return a string about the food item
     * @return string about the food item
     */
    public String toString() {
        return name + " costs $" + price + ", and there are " + quantity + " remaining.";
    }

    // public static void main(String[] args) {
    //     //Food food = new Food("restaurants.csv");
    //     //System.out.println(Arrays.deepToString(food.inventory));
    // }
}