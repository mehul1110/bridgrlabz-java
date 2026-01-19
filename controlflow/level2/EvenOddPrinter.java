import java.util.Scanner;

/*
 * Program to print valid natural numbers up to n and check if they are even or odd
 */
public class EvenOddPrinter {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Validate input
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number");
        } else {
            // Loop through numbers
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) System.out.println(i + " is even");
                else System.out.println(i + " is odd");
            }
        }
        
        // Close Scanner
        input.close();
    }
}