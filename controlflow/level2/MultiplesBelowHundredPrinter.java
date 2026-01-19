import java.util.Scanner;

/*
 * Program to find multiples of a number below 100 using a backwards for loop
 */
public class MultiplesBelowHundredPrinter {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();
        
        // Validation
        if (number < 1 || number >= 100) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Multiples of " + number + " below 100 are:");
            // Iterate backwards from 100
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) System.out.println(i);
            }
        }
        
        // Close Scanner
        input.close();
    }
}