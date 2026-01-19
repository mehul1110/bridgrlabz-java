import java.util.Scanner;

/*
 * Program to convert specific temperatures between Fahrenheit and Celsius
 */
public class TemperatureConverter {

    public static double fToC(double f) {
        // Formula: (F - 32) * 5/9
        return (f - 32) * 5 / 9;
    }

    public static double cToF(double c) {
        // Formula: C * 9/5 + 32
        return c * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter F or C and value (e.g. F 98.6): ");
            String t = sc.next();
            double v = sc.nextDouble();
            
            // Convert and display based on unit input
            if (t.equalsIgnoreCase("F")) {
                System.out.println("C: " + fToC(v));
            } else {
                System.out.println("F: " + cToF(v));
            }
        }
    }
}
