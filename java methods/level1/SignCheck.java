import java.util.Scanner;

/*
 * Program to check the sign of a number
 * It determines if a number is positive, negative, or zero
 */
public class SignCheck {

    public static int signOf(int n) {
        // Return -1 if the number is less than zero (negative)
        if (n < 0) return -1;

        // Return 1 if the number is greater than zero (positive)
        if (n > 0) return 1;

        // Return 0 if the number is exactly zero
        return 0;
    }

    public static void main(String[] args) {
        // Create a Scanner for input
        Scanner in = new Scanner(System.in);

        // Prompt user for an integer
        System.out.print("Enter integer: ");
        int v = in.nextInt();

        // Display the sign of the integer
        System.out.println("Sign: " + signOf(v));

        // Close the scanner
        in.close();
    }
}
