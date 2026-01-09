import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = in.nextDouble();
        System.out.print("Enter second number: ");
        double b = in.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        String op = in.next();

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

        in.close();
    }
}
