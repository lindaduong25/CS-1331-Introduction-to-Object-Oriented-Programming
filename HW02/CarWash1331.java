// I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;

public class CarWash1331 {
    public static void main(String[] args) {
        System.out.println("Welcome to Car Wash 1331!");
        System.out.println("");
        System.out.println("Sedan/Coupe: $13.31");
        System.out.println("Truck: $21.10");
        System.out.println("SUV/Minivan: $35.10");
        System.out.println("");

        double carPrice = 0.00;
        double waxTotal = 0.00;
        double tirePolishTotal = 0.00;
        double interiorVacuumTotal = 0.00;
        double discount = 0.00;
        double tip = 0.00;
        Scanner input = new Scanner(System.in);

        // Vehicle Type
        double price1 = 13.31;
        double price2 = 21.10;
        double price3 = 35.10;
        System.out.print("Select the type of vehicle: ");
        String vehicleInput = input.next().toLowerCase();
        switch (vehicleInput) {
        case "sedan":
            carPrice = price1;
            break;
        case "coupe":
            carPrice = price1;
            break;
        case "truck":
            carPrice = price2;
            break;
        case "suv":
            carPrice = price3;
            break;
        case "minivan":
            carPrice = price3;
            break;
        default:
            return;
        }
        System.out.println("");

        // Wax
        double wax = 3.00;
        System.out.print("Would you like to add Wax for $3.00: ");
        String waxInput = input.next().toLowerCase();
        if (waxInput.equals("yes")) {
            waxTotal = wax;
        } else {
            waxTotal = 0;
        }

        // Tire Polish
        double tirePolish = 5.00;
        System.out.print("Would you like to add Tire Polish for $5.00: ");
        String tirePolishInput = input.next().toLowerCase();
        if (tirePolishInput.equals("yes")) {
            tirePolishTotal = tirePolish;
        } else {
            tirePolishTotal = 0;
        }

        // Interior Vacuum
        double interiorVacuum = 7.00;
        System.out.print("Would you like to add Interior Vacuum for $7.00: ");
        String interiorVacuumInput = input.next().toLowerCase();
        if (interiorVacuumInput.equals("yes")) {
            interiorVacuumTotal = interiorVacuum;
        } else {
            interiorVacuumTotal = 0;
        }
        System.out.println("");

        // Discount
        double subTotal = carPrice + waxTotal + tirePolishTotal + interiorVacuumTotal;
        System.out.print("Do you have a discount code/coupon? ");
        String hasDiscountCode = input.next().toLowerCase();
        if (hasDiscountCode.equals("yes")) {
            System.out.print("Please enter the discount code: ");
            input.nextLine();
            String discountCodeInput = input.nextLine().toLowerCase();
            System.out.println(discountCodeInput);
            if (discountCodeInput.equals("1331 wash!")) {
                discount = subTotal * 0.10;
                System.out.println("");
                System.out.println("Discount code is valid and accepted!");
            } else {
                System.out.println("");
                System.out.println("Discount code is invalid and not accepted!");
            }
        }
        System.out.println("");

        // Percentage
        System.out.print("What perecentage would you like to tip? ");
        double percentageInput = input.nextDouble();
        if (percentageInput < 0) {
            tip = subTotal * 0.18;
        } else {
            tip = subTotal * (percentageInput / 100);
        }
        System.out.println("");

        // Final Receipt
        System.out.printf("%s%.2f \n", "Subtotal: $", subTotal);
        System.out.printf("%s%.2f \n", "Discount: $", discount);
        System.out.printf("%s%.2f \n", "Tip: $", tip);
        System.out.printf("%s%.2f \n", "Total: $", subTotal - discount + tip);
    }
}

