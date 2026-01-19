/*
 * This program calculates the quotient and remainder
 * using division and modulus operations
 */
import java.util.Scanner;

public class QuotientAndRemainderCalculator {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Read integer values required for calculation
        System.out.print("Enter number1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number2: ");
        int number2 = input.nextInt();

        // Calculate quotient using division
        int quotient = number1 / number2;

        // Calculate remainder using modulus
        int remainder = number1 % number2;

        // Display the calculated quotient and remainder
        System.out.println(
                "The Quotient is " + quotient +
                        " and Reminder is " + remainder +
                        " of two number " + number1 +
                        " and " + number2
        );

        // Close the input stream
        input.close();
    }
}
