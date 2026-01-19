/*
 * This program evaluates multiple arithmetic expressions
 * using integer values and operator precedence
 */
import java.util.Scanner;

public class IntegerArithmeticOperations {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Read integer values from the user
        System.out.print("Enter a: ");
        int a = input.nextInt();
        System.out.print("Enter b: ");
        int b = input.nextInt();
        System.out.print("Enter c: ");
        int c = input.nextInt();

        // Evaluate expression using multiplication before addition
        int op1 = a + b * c;

        // Evaluate expression using multiplication followed by addition
        int op2 = a * b + c;

        // Evaluate expression using integer division followed by addition
        int op3 = c + a / b;

        // Evaluate expression using modulus and addition
        int op4 = a % b + c;

        // Display results of all evaluated expressions
        System.out.println(
                "The results of Int Operations are " +
                        op1 + ", " + op2 + ", " + op3 + ", " + op4
        );

        // Close the input stream
        input.close();
    }
}
