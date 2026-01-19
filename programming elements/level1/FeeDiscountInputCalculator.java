/*
 * This program calculates a discount and final amount
 * using values provided at runtime through user input
 */
import java.util.Scanner;

public class FeeDiscountInputCalculator {

    public static void main(String[] args) {

        // Create an input stream to read user data
        Scanner input = new Scanner(System.in);

        // Read numeric input from the user
        System.out.print("Enter fee: ");
        double fee = input.nextDouble();

        // Read percentage value from the user
        System.out.print("Enter discount percent: ");
        double discountPercent = input.nextDouble();

        // Calculate discount using percentage formula
        double discount = fee * discountPercent / 100.0;

        // Compute final value after subtraction
        double finalFee = fee - discount;

        // Display the computed results
        System.out.println(
                "The discount amount is INR " + discount +
                        " and final discounted fee is INR " + finalFee
        );

        // Close the input stream after use
        input.close();
    }
}
