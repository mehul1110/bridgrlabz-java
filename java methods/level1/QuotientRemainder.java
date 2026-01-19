import java.util.Scanner;

/*
 * Program to find the quotient and remainder of two numbers
 * using a utility method for division and modulus operations
 */
public class QuotientRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        // Calculate the quotient by integer division
        int q = number / divisor;

        // Calculate the remainder using the modulus operator
        int r = number % divisor;

        // Return an array containing the remainder and quotient
        return new int[]{r, q};
    }

    public static void main(String[] args) {
        // Initialize scanner to read from console
        Scanner in = new Scanner(System.in);

        // Prompt user for the dividend
        System.out.print("Enter dividend: ");
        int n = in.nextInt();

        // Prompt user for the divisor
        System.out.print("Enter divisor: ");
        int d = in.nextInt();

        // Compute quotient and remainder
        int[] res = findRemainderAndQuotient(n, d);

        // Display the results: Quotient first (index 1), then Remainder (index 0)
        System.out.println("Quotient: " + res[1] + ", Remainder: " + res[0]);

        // Close the scanner resource
        in.close();
    }
}
