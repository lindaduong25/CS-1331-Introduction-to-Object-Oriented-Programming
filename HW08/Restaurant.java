// I worked on the homework assignment alone, using only course materials.
// notes for me :
// - go back and make sure visbility on methods are correct
// - make sure you used the exception classes you had to make

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class represents a Restaurant that can print out a receipt
 * @author Linda Duong
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private Location location;
    public static final double DELIVERY_FEE = 0.2;
    private Food[] menu;

    /**
     * Creates a Restaurant object with the following parameters and parse CSV file to set the instance variables
     * @param name name of restaurant
     * @param location location of restaurant
     */
    public Restaurant(String name, Location location) {
        this.name = name;
        this.location = location;
        // parsing starts here
        File fileIn = new File("restaurants.csv");
        Scanner scan = null; // scanner reads from the file
        String line = "";
        int lines = 0;
        String[] tokens = null;
        boolean restaurantExists = false;
        try {
            scan = new Scanner(fileIn);
            while (scan.hasNextLine() && !restaurantExists) {
                lines++;
                line = scan.nextLine();
                tokens = line.split(",");
                // tokens[1] will be the name of the restaurant
                if (line.contains("RESTAURANT") && tokens[1].trim().equals(name)) {
                    Location checkLocation = new Location(Double.parseDouble(tokens[2].trim()),
                        Double.parseDouble(tokens[3].trim()));
                    Double checkLocationX = checkLocation.getX();
                    Double checkLocationY = checkLocation.getY();
                    // checks to see if the location inputted equals the location in the csv file
                    // if so then it instantiates the instance variables
                    if (checkLocationX == location.getX() && checkLocationY == location.getY()) {
                        name = tokens[1].trim();
                        location = new Location(Double.parseDouble(tokens[2].trim()),
                        Double.parseDouble(tokens[3].trim()));
                        restaurantExists = true;
                    }
                }
            }
            if (restaurantExists) {
                int foodCount = 0;
                line = scan.nextLine();
                tokens = line.split(",");
                while (scan.hasNextLine() & !(line.contains("RESTAURANT"))) {
                    line = scan.nextLine();
                    tokens = line.split(",");
                    foodCount++;
                }
                Scanner foods = new Scanner(fileIn);
                menu = new Food[foodCount];
                restaurantExists = false;
                while (foods.hasNextLine() && !restaurantExists) {
                    line = foods.nextLine();
                    tokens = line.split(",");
                    // tokens[1] will be the name of the restaurant
                    if (line.contains("RESTAURANT") && tokens[1].trim().equals(name)) {
                        Location checkLocation = new Location(Double.parseDouble(tokens[2].trim()),
                            Double.parseDouble(tokens[3].trim()));
                        Double checkLocationX = checkLocation.getX();
                        Double checkLocationY = checkLocation.getY();
                        // checks to see if the location inputted equals the location in the csv file
                        // if so then it instantiates the instance variables
                        if (checkLocationX == location.getX() && checkLocationY == location.getY()) {
                            restaurantExists = true;
                        }
                    }
                }
                for (int i = 0; i < foodCount; i++) {
                    line = foods.nextLine();
                    tokens = line.split(",");
                    menu[i] = new Food(tokens[0].trim(),
                        Integer.parseInt(tokens[1].trim()),
                        Double.parseDouble(tokens[2].trim()));
                }
                if (foods != null) {
                    foods.close();
                }
            }
            if (!restaurantExists) {
                throw new InvalidRestaurantException();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }

    /**
     * Creates a Restaurant object with the following parameters
     * @param name name of restaurant
     * @param x x coordinate of location
     * @param y y coordinate of location
     */
    public Restaurant(String name, double x, double y) {
        this(name, new Location(x, y));
    }

    // getter methods
    /**
     * This getter method gets name of the restaurant
     * @return name of the restaurant
     */
    public String getName() {
        return name;
    }
    /**
     * This getter method gets the menu of the restaurant
     * @return menu of the restaurant
     */
    public Food[] getMenu() {
        return menu;
    }
    /**
     * This getter method gets the location of the restaurant
     * @return location of the restaurant
     */
    public Location getLocation() {
        return location;
    }

    // printReceipt method
    /**
     * This method prints a receipt for a customer
     * @param customer customer object
     * @param delivery boolean value that indicates of the customer had food delivered
     */
    public void printReceipt(Customer customer, boolean delivery) {
        boolean foodExists = false;

        // if the customer has no order then do nothing
        if (customer.getOrders() == null) {
            System.out.println("null1"); // test
            return;
        }

        // issue lies here becuase the order equals null but why?
        for (Food order : customer.getOrders()) {
            if (order == null) {
                System.out.println("null2"); //test
                return;
            } else {
                for (Food food : menu) {
                    System.out.println(food);
                    boolean checkEquals = order.getName().equals(food.getName()) && order.getPrice() == food.getPrice();
                    if (food != null && checkEquals) {
                        foodExists = true;
                    }
                }
            }
            //if the order does exist this means the order is within this restaurant
            //so we want to print the receipt
            if (foodExists) {
                String receipt = customer.getName() + "_" + name;
                File receiptFile = new File(receipt + ".txt");
                PrintWriter filePrint = null;
                try {
                    double deliveryAmount = 0;
                    double subtotal = 0;
                    String receiptName = "";

                    // should this be a while loop?
                    if (receiptFile.exists()) {
                        receiptName = receipt + "-";
                        filePrint = new PrintWriter(new File(receiptName + ".txt"));
                    } else {
                        filePrint = new PrintWriter(new File(receipt + ".txt"));
                    }

                    filePrint.println("Receipt");
                    filePrint.println(name);
                    filePrint.println(location.getX() + ", " + location.getY());
                    for (Food orderItems : customer.getOrders()) {
                        if (orderItems != null) {
                            filePrint.println(orderItems.getName() + ", $" + orderItems.getPrice());
                            subtotal += orderItems.getPrice();
                        } else {
                            break;
                        }
                    }
                    if (delivery) {
                        filePrint.printf("Subtotal: $%.2f", subtotal);
                        filePrint.println();
                        Double distance = location.calcDistance(customer.getLocation());
                        deliveryAmount = DELIVERY_FEE * distance;
                        filePrint.printf("Delivery: $%.2f\n", deliveryAmount);
                    }
                    double total = subtotal + deliveryAmount;
                    filePrint.printf("Total: $%.2f", total);
                    filePrint.println();
                    filePrint.printf("Thank you for dining with us!");
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } finally {
                    if (filePrint != null) {
                        filePrint.close();
                    }
                }

                // sets everything to null once receipt is printed
                for (Food item : customer.getOrders()) {
                    if (item != null) {
                        item = null;
                    }
                }
                customer.setCurrent(null);

            // if the order does not exist in the restaurant then do nothing
            } else {
                return;
            }
        }
    }
}