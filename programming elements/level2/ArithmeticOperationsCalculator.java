/*
 * This program performs basic arithmetic operations
 * on two numbers provided by the user
 */
import java.util.Scanner;

public class ArithmeticOperationsCalculator {

    public static void main(String[] args) {

        // Create an input stream to read user values
        Scanner input = new Scanner(System.in);

        // Accept two numeric values from the user
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        // Perform addition operation
        double add = number1 + number2;

        // Perform subtraction operation
        double sub = number1 - number2;

        // Perform multiplication operation
        double mul = number1 * number2;

        // Perform division with a conditional check
        double div = number2 != 0 ? number1 / number2 : Double.NaN;

        // Display results of all arithmetic operations
        System.out.println(
                "The addition, subtraction, multiplication, and division value of 2 numbers " +
                        number1 + " and " + number2 + " is " +
                        add + ", " + sub + ", " + mul + ", and " + div
        );

        // Close the input stream
        input.close();
    }
}
