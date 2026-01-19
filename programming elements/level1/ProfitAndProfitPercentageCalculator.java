/*
 * This program calculates profit and profit percentage
 * using basic arithmetic operations
 */
public class ProfitAndProfitPercentageCalculator {

    public static void main(String[] args) {

        // Store values required for calculation
        int costPrice = 129;
        int sellingPrice = 191;

        // Calculate profit using subtraction
        int profit = sellingPrice - costPrice;

        // Calculate profit percentage using division and multiplication
        double profitPercent = (profit / (double) costPrice) * 100;

        // Display the calculated profit and percentage
        System.out.println(
                "The Cost Price is INR " + costPrice +
                        " and Selling Price is INR " + sellingPrice +
                        "\nThe Profit is INR " + profit +
                        " and the Profit Percentage is " + profitPercent
        );
    }
}
