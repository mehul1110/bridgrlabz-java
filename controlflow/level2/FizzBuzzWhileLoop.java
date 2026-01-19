import java.util.Scanner;

/*
 * Program to solve the FizzBuzz problem using a while loop
 */
public class FizzBuzzWhileLoop {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        
        // Validate input
        if (n < 1) {
            System.out.println("The number " + n + " is not a positive integer");
        } else {
            int i = 1;
            // While loop for FizzBuzz
            while (i <= n) {
                if (i % 15 == 0) System.out.println("FizzBuzz");
                else if (i % 3 == 0) System.out.println("Fizz");
                else if (i % 5 == 0) System.out.println("Buzz");
                else System.out.println(i);
                i++;
            }
        }
        
        // Close Scanner
        input.close();
    }
}