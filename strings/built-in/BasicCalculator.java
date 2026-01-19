import java.util.Scanner;

/*
 * Program to implement a basic calculator with operations add, sub, mul, div
 */
public class BasicCalculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter op (+ - * /) and two numbers: ");
            String op = sc.next();
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            
            // Perform operation based on input
            switch(op) {
                case "+": 
                    // Addition operation
                    System.out.println(add(a,b)); 
                    break;
                case "-": 
                    // Subtraction operation
                    System.out.println(sub(a,b)); 
                    break;
                case "*": 
                    // Multiplication operation
                    System.out.println(mul(a,b)); 
                    break;
                case "/": 
                    // Division operation
                    System.out.println(div(a,b)); 
                    break;
                default: 
                    // Handle invalid operations
                    System.out.println("Unknown op");
            }
        }
    }
}
