import java.util.Scanner;

/*
 * Program to find and print the factors of a positive integer
 */
public class FactorPrinter {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        // Validate input
        if (number < 1) {
            System.out.println("The number " + number + " is not a positive integer");
        } else {
            System.out.println("Factors of " + number + " are:");
            // Find factors
            for (int i = 1; i < number; i++) {
                if (number % i == 0) System.out.println(i);
            }
        }
        
        // Close Scanner
        input.close();
    }
}