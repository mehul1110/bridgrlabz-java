package exceptions;

/**
 * Practice Problem 6: throw vs. throws
 * 
 * Problem: calculateInterest. Negative -> IllegalArgumentException.
 * Expected: Invalid -> "Invalid input: Amount and rate must be positive".
 */
public class ThrowVsThrowsDemo {

    public static void main(String[] args) {
        try {
            calculateInterest(-100, 5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            double res = calculateInterest(1000, 5, 2);
            System.out.println("Interest: " + res);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }
}
