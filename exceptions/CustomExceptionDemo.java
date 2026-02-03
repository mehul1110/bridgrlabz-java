package exceptions;

import java.util.Scanner;

/**
 * Practice Problem 3: Custom Exception (User-defined Exception)
 * 
 * Problem: validateAge(int age) throws InvalidAgeException if < 18.
 * Expected: >=18 -> "Access granted!". <18 -> "Age must be 18 or above".
 */

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");

        try {
            int age = scanner.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
