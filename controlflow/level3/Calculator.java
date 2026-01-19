import java.util.Scanner;

/*
 * Program to perform simple arithmetic operations using switch case
 */
public class Calculator {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double a = in.nextDouble();
        System.out.print("Enter second number: ");
        double b = in.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        String op = in.next();

        // Perform operation based on operator
        switch (op) {
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                if (b == 0) System.out.println("Cannot divide by zero");
                else System.out.println("Result: " + (a / b));
                break;
            default:
                System.out.println("Invalid Operator");
        }

        // Close Scanner
        in.close();
    }
}
