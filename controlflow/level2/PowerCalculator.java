import java.util.Scanner;

/*
 * Program to calculate the power of a number
 */
public class PowerCalculator {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base (positive integer): ");
        int number = input.nextInt();
        System.out.print("Enter power (non-negative integer): ");
        int power = input.nextInt();
        
        // Validate input
        if (number < 0 || power < 0) {
            System.out.println("Invalid input");
        } else {
            long result = 1;
            // Calculate power
            for (int i = 1; i <= power; i++) result *= number;
            System.out.println(number + "^" + power + " = " + result);
        }
        
        // Close Scanner
        input.close();
    }
}