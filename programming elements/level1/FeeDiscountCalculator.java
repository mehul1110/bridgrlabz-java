/*
 * This program calculates a discount
 * and determines the final payable amount
 */
public class FeeDiscountCalculator {

    public static void main(String[] args) {

        // Store the original amount
        double fee = 125000;

        // Define the percentage to be applied
        double discountPercent = 10;

        // Calculate the discount using percentage formula
        double discount = fee * discountPercent / 100.0;

        // Subtract discount from original amount
        double finalFee = fee - discount;

        // Display the calculated discount and final amount
        System.out.println(
                "The discount amount is INR " + discount +
                        " and final discounted fee is INR " + finalFee
        );
    }
}
