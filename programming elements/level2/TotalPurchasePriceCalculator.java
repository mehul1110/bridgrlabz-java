import java.util.Scanner;

/*
 * This program calculates the total purchase cost
 * using multiplication of price and quantity
 */
public class TotalPurchasePriceCalculator {
    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Read unit price and quantity values
        System.out.print("Enter unit price: ");
        double unitPrice = input.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        // Calculate total cost using multiplication
        double total = unitPrice * quantity;

        // Display the calculated total purchase price
        System.out.println(
                "The total purchase price is INR " + total +
                        " if the quantity " + quantity +
                        " and unit price is INR " + unitPrice
        );

        // Close the input stream
        input.close();
    }
}
