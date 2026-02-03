package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Practice Problem 2: Unchecked Exception (Runtime Exception)
 * 
 * Problem: Divide two numbers from user.
 * Expected: Valid -> print result. Zero denominator -> ArithmeticException.
 * Non-numeric -> InputMismatchException.
 */
public class UncheckedExceptionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
            // Note: Prompt didn't specify exact string for this one, used reasonable
            // default.
        } catch (InputMismatchException e) {
            System.out.println("Error: Input mismatch.");
            // Note: Prompt didn't specify exact string for this one.
        } finally {
            scanner.close();
        }
    }
}
