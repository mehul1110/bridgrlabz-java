import java.util.Scanner;

/*
 * Program to find and print the factors of a positive integer using a while loop
 */
public class FactorPrinterWhileLoop {

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
            int i = 1;
            // Loop until number-1 to find factors
            while (i < number) {
                if (number % i == 0) System.out.println(i);
                i++;
            }
        }
        
        // Close Scanner
        input.close();
    }
}