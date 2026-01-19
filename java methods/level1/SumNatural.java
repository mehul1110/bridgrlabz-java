import java.util.Scanner;

/*
 * Program to calculate the sum of the first N natural numbers
 * This class implements a method to compute the sum using a loop
 */
public class SumNatural {

    public static long sumN(long n) {
        long sum = 0;
        // Iterate from 1 to n to accumulate the sum
        for (long i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);

        // Read the value of n
        System.out.print("Enter n: ");
        long n = in.nextLong();

        // Calculate and display the sum
        System.out.println("Sum: " + sumN(n));

        // Close the scanner
        in.close();
    }
}
