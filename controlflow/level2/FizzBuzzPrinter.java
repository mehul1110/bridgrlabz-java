import java.util.Scanner;

/*
 * Program to solve the FizzBuzz problem using a for loop
 * Prints Fizz, Buzz, or FizzBuzz based on divisibility
 */
public class FizzBuzzPrinter {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        
        // Validate input
        if (n < 1) {
            System.out.println("The number " + n + " is not a positive integer");
        } else {
            // FizzBuzz logic
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) System.out.println("FizzBuzz");
                else if (i % 3 == 0) System.out.println("Fizz");
                else if (i % 5 == 0) System.out.println("Buzz");
                else System.out.println(i);
            }
        }
        
        // Close Scanner
        input.close();
    }
}