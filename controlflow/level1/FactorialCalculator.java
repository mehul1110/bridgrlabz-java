import java.util.Scanner;

/*
 * Program to calculate the factorial of a positive integer
 */
public class FactorialCalculator {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        
        // Check for non-negative input
        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            long fact = 1;
            // Calculate factorial
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            System.out.println("The factorial of " + n + " is " + fact);
        }
        
        // Close Scanner
        input.close();
    }
}