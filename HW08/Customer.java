import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This class represents a customer that can order food at a restaurant
 * @author Linda Duong
 * @version 1.0
 */
public class Customer {
    private String name;
    private Location location;
    private Food[] orders;
    private Restaurant current;

    /**
     * Creates customer object with the following parameters
     * @param name name of customer
     * @param x x coordinate location of customer
     * @param y y coordinate location of customer
     */
    public Customer(String name, double x, double y) {
        this.name = name;
        this.location = new Location(x, y);
    }
    /**
     * This getter method gets the name of the customer
     * @return name of the customer
     */
    public String getName() {
        return name;
    }
    /**
     * This getter method gets the customer's orders
     * @return order(s) of the customer
     */
    public Food[] getOrders() {
        return orders;
    }
    /**
     * This getter method gets the current restaurant of the customer
     * @return current restaurant the customer is ordering from
     */
    public Restaurant getCurrent() {
        return current;
    }
    /**
     * This getter method gets the location of the customer
     * @return location of customer
     */
    public Location getLocation() {
        return location;
    }
    /**
     * This setter method sets the current restaurant
     * @param current current restaurant the customer is ordering from
     */
    public void setCurrent(Restaurant current) {
        this.current = current;
    }
    /**
     * This method allows a customer to order food from a restaurant
     * @param restaurant restaurant the customer wants to order from
     * @param food food the customer wants to order
     */
    public void order(Restaurant restaurant, String food) {
        // remember that if one item in food string is not on the menu then disregard the whole thing
        if (food == null) {
            System.out.println("null"); // testing
            return;
        }
        if (current == null) {
            current = restaurant;
        }
        // checks if the restaurant exists or if the restaurant equals the current one
        boolean attributesCheck = true;
        if (food == null || restaurant.getName().equals(current.getName())
            && restaurant.getLocation().getX() == current.getLocation().getX()
            && restaurant.getLocation().getY() == current.getLocation().getY()) {
            attributesCheck = true;
        }
        if (restaurant == null || !attributesCheck) {
            return;
        }
        // active order elsewhere check
        if (restaurant != current && orders != null) {
            System.out.println("You have an active order at " + current.getName() + "!");
            return;
        }
        // once we pass the stuff above, that means we need to put food into orders array
        // first step is splitting the food string into the separate food items and store into an array
        if (orders == null) {
            // this part stores items in the string food into tempArray
            String[] foodItems = food.split("\n");
            food = food.replaceAll("$", "");
            int foodCount = foodItems.length;
            int ordersCount = 0;
            Food[] restaurantMenu = restaurant.getMenu();
            Food[] tempArray = new Food[foodCount]; // use to check if food is in restaurant
            food = food.replace("$", "");
            for (int i = 0; i < foodCount; i++) {
                String[] tokens = foodItems[i].split(",");
                int quantity = 1;
                tempArray[i] = new Food(tokens[0].trim(), quantity, Double.parseDouble(tokens[1].replace("$", "")));
            }
            // reminder : tempArray holds all the foods the customer ordered even if not on the menu
            // we are using tempArray to check if the food is on the menu and if so then add it to orders array
            // remember if any item in string is not on menu then disregard the whole thing
            int count = 0;
            for (Food item : tempArray) {
                for (Food foodOffered : restaurantMenu) {
                    if (foodOffered.getName().contains(item.getName()) && foodOffered.getPrice() == item.getPrice()
                        && item != null) {
                        count++; // right now this is 1 which is correct
                    }
                }
            }
            // this means that there is an item in string not on the menu therefore make orders null
            if (count != tempArray.length) {
                orders = null;
                return;
            }
            orders = new Food[count];
            for (int j = 0; j < restaurantMenu.length; j++) {
                for (int k = 0; k < count; k++) {
                    boolean nameCheck = restaurantMenu[j].getName().equals(tempArray[k].getName());
                    boolean priceCheck = restaurantMenu[j].getPrice() == tempArray[k].getPrice();
                    if (nameCheck && priceCheck) {
                        if (restaurantMenu[j].getQuantity() == 0) {
                            throw new UnavailableException();
                        }
                        orders[k] = tempArray[k];
                        restaurantMenu[j].setQuantity(restaurantMenu[j].getQuantity() - 1);
                    }
                }
            }
        }  else {
            // remember if any part of string is not on menu then take only the previous order
            //putting previous orders into the new orders and updating the current orders array
            String[] line = food.split("\n");
            Food[] previousOrders = orders;
            for (int i = 0; i < previousOrders.length; i++) {
                orders[i] = previousOrders[i];
            }
            food = food.replaceAll("$", "");
            int foodCount = line.length;
            Food[] restaurantMenu = restaurant.getMenu();
            Food[] tempArray = new Food[foodCount];
            food = food.replace("$", "");
            // temp order array not including previous order meaning this is the second time the method is called
            for (int i = 0; i < foodCount; i++) {
                String[] tokens = line[i].split(",");
                int quantity = 1;
                int count = 0;
                tempArray[i] = new Food(tokens[0].trim(), quantity, Double.parseDouble(tokens[1].replace("$", "")));
            }
            int count1 = 0;
            for (Food item : tempArray) {
                for (Food foodOffered : restaurantMenu) {
                    if (foodOffered.getName().contains(item.getName()) && foodOffered.getPrice() == item.getPrice()
                        && item != null) {
                        count1++;
                    }
                }
            }
            // this means that there is an item in string not on menu so we want to make orders = to previous order
            if (count1 != tempArray.length) {
                previousOrders = orders;
                return;
            }
            // reminder : tempArray holds current order not previous order
            // this array is used to check if tempArray foods are on menu, if so then it becomes part of another array
            Food[] anotherArray = new Food[count1];
            for (int i = 0; i < restaurantMenu.length; i++) {
                for (int j = 0; j < count1; j++) {
                    boolean nameCheck = restaurantMenu[i].getName().equals(tempArray[j].getName());
                    boolean priceCheck = restaurantMenu[i].getPrice() == tempArray[j].getPrice();
                    if (nameCheck && priceCheck) {
                        //System.out.println(tempArray[j].getName()); // testing
                        if (restaurantMenu[i].getQuantity() == 0) {
                            throw new UnavailableException();
                        }
                        anotherArray[j] = tempArray[j];
                        restaurantMenu[i].setQuantity(restaurantMenu[i].getQuantity() - 1);
                        //System.out.println(restaurantMenu[i].getQuantity());
                    }
                }
            }
            //combining the previous array and the current array
            int counter = 0;
            Food[] finalArray = new Food[count1 + previousOrders.length];
            for (int i = 0; i < previousOrders.length; i++) {
                finalArray[i] = previousOrders[i];
                counter++;
            }
            for (int j = 0; j < anotherArray.length; j++) {
                finalArray[counter++] = anotherArray[j];
            }
            for (Food menu : restaurantMenu) {
                if (menu == null) {
                    return;
                }
            }
            // reminder : tempArray holds all the foods the customer ordered even if not on the menu
            // we are using tempArray to check if the food is on the menu and if so then add it to orders array
            // array needs to include previous order items
            // only want to set qaunitty of new orders not previous orders
            orders = new Food[finalArray.length];
            for (int j = 0; j < restaurantMenu.length; j++) {
                for (int k = 0; k < finalArray.length; k++) {
                    orders[k] = finalArray[k];
                }
            }
        }
    }
    /**
     * This method recommends the restaurant that is the closest to the customer by location
     */
    public void recommendation() {
        File fileIn = new File("restaurants.csv");
        Scanner scan = null; // scanner reads from the file
        String line = "";
        String[] tokens = null;
        Restaurant[] restaurant = new Restaurant[100]; // cannot be null here
        int restaurantCount = 0;
        String closestRestaurant = "";
        try {
            scan = new Scanner(fileIn);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.contains("RESTAURANT")) {
                    tokens = line.split(",");
                    String restaurantName = tokens[1].trim();
                    double xCoord = Double.parseDouble(tokens[2].trim());
                    double yCoord = Double.parseDouble(tokens[3].trim());
                    restaurant[restaurantCount] = new Restaurant(restaurantName, xCoord, yCoord);
                    restaurantCount++;
                }
            }
            // selection sort method to get the closest Restaurant
            double closestRest = Double.MAX_VALUE; //max value possible
            Restaurant rest = null;
            for (int i = 0; i < restaurantCount; i++) {
                //int currentMinIndex = 0;
                double currentMin = this.getLocation().calcDistance(restaurant[i].getLocation());
                //System.out.println(currentMin);
                //double temp = this.getLocation().calcDistance(restaurant[i].getLocation());
                //System.out.println(temp);
                if (currentMin < closestRest) {
                    closestRest = currentMin;
                    rest = restaurant[i];
                }
                //closestRestaurant = restaurant[currentMinIndex].getName();
            }
            System.out.println(rest.getName() + " is recommended for you!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }
}
