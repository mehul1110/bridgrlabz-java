import java.util.Scanner;

/*
 * Program to calculate the sum of positive numbers entered by the user
 * Stops when 0 or a negative number is entered
 */
public class SumOfPositiveNumbers {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        double total = 0.0;
        
        // Input loop
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = input.nextDouble();
            
            // Exit condition
            if (value <= 0) break;
            
            // Accumulate sum
            total += value;
        }
        
        System.out.println("Total is " + total);
        
        // Close Scanner
        input.close();
    }
}