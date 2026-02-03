package exceptions;

/**
 * Problem Statement 2: Rethrowing Exceptions
 * 
 * Problem: performDivision throws ArithmeticException. calculate catches and
 * rethrows. main handles.
 */
public class RethrowExceptionDemo {

    public static void main(String[] args) {
        try {
            calculate(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error handled in main: " + e.getMessage());
        }
    }

    public static void calculate(int numerator, int denominator) {
        try {
            performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            // Rethrow with additional context
            throw new ArithmeticException("Calculation error [" + e.getMessage() + "]");
        }
    }

    public static void performDivision(int numerator, int denominator) {
        int result = numerator / denominator;
    }
}
