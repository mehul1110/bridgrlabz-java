import java.util.Scanner;

/*
 * Program to print numbers from 1 to n and check if they are even or odd
 */
public class EvenOddPrinter {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Check if number is natural
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number");
        } else {
            // Iterate and check even/odd
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) System.out.println(i + " is even");
                else System.out.println(i + " is odd");
            }
        }
        
        // Close Scanner
        input.close();
    }
}