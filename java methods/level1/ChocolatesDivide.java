import java.util.Scanner;

/*
 * Program to divide chocolates among children and find
 * the number of chocolates each child gets and the remaining chocolates
 */
public class ChocolatesDivide {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        // Calculate the quotient which represents chocolates per child
        int q = number / divisor;

        // Calculate the remainder which represents remaining chocolates
        int r = number % divisor;

        // Return the results as an integer array
        return new int[]{q, r};
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter the total number of chocolates
        System.out.print("Enter numberOfChocolates: ");
        int chocolates = in.nextInt();

        // Prompt the user to enter the number of children
        System.out.print("Enter numberOfChildren: ");
        int children = in.nextInt();

        // Check if the number of children is valid (greater than zero)
        if (children <= 0) {
            System.out.println("Invalid number of children");
            in.close();
            return;
        }

        // Call the method to find quotient and remainder
        int[] res = findRemainderAndQuotient(chocolates, children);

        // Display the results to the user
        System.out.println("Each child gets: " + res[0] + ", Remaining: " + res[1]);

        // Close the scanner object
        in.close();
    }
}
