package exceptions;

import java.util.Scanner;

/**
 * Practice Problem 7: finally Block
 * 
 * Problem: Division. Finally -> "Operation completed".
 */
public class FinallyBlockDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter num 1: ");
            int a = scanner.nextInt();
            System.out.print("Enter num 2: ");
            int b = scanner.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            System.out.println("Operation completed");
        }
    }
}
