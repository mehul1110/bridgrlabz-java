import java.util.Scanner;

public class TemperatureConverter {
    public static double fToC(double f) { return (f - 32) * 5/9; }
    public static double cToF(double c) { return c * 9/5 + 32; }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter F or C and value (e.g. F 98.6): ");
            String t = sc.next(); double v = sc.nextDouble();
            if (t.equalsIgnoreCase("F")) System.out.println("C: " + fToC(v)); else System.out.println("F: " + cToF(v));
        }
    }
}
