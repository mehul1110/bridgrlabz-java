import java.util.Scanner;

/*
 * Program to check if a number is an Abundant number
 * An abundant number is a number for which the sum of its proper divisors is greater than the number itself
 */
public class AbundantNumber {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = in.nextInt();

        // Validation
        if (n <= 0) {
            System.out.println("Enter a positive integer.");
            in.close();
            return;
        }

        int sum = 0;
        // Calculate sum of divisors
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) sum += i;
        }

        // Check abundant condition
        if (sum > n) System.out.println(n + " is an Abundant number");
        else System.out.println(n + " is not an Abundant number");

        // Close Scanner
        in.close();
    }
}
