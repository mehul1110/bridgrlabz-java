import java.util.Scanner;

/*
 * Program to find the greatest proper factor of a number using a for loop
 * A proper factor is a factor other than the number itself
 */
public class GreatestProperFactorFinder {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        // Check condition
        if (number <= 1) {
            System.out.println("No greatest factor besides itself for " + number);
        } else {
            int greatestFactor = 1;
            // Iterate backwards from number-1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
            System.out.println("The greatest factor besides itself is " + greatestFactor);
        }
        
        // Close Scanner
        input.close();
    }
}