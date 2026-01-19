/*
 * This program evaluates multiple arithmetic expressions
 * using double-precision values and operator precedence
 */
import java.util.Scanner;

public class DoubleArithmeticOperations {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Accept multiple numeric values from the user
        System.out.print("Enter a (double): ");
        double a = input.nextDouble();
        System.out.print("Enter b (double): ");
        double b = input.nextDouble();
        System.out.print("Enter c (double): ");
        double c = input.nextDouble();

        // Evaluate expression using multiplication before addition
        double op1 = a + b * c;

        // Evaluate expression using multiplication followed by addition
        double op2 = a * b + c;

        // Evaluate expression using division followed by addition
        double op3 = c + a / b;

        // Evaluate expression using modulus and addition
        double op4 = a % b + c;

        // Display results of all evaluated expressions
        System.out.println(
                "The results of Double Operations are " +
                        op1 + ", " + op2 + ", " + op3 + ", " + op4
        );

        // Close the input stream
        input.close();
    }
}
