import java.util.Scanner;

/*
 * Program to calculate GCD and LCM of two numbers
 */
public class GcdLcmCalculator {

    public static int gcd(int a, int b) {
        // Recursive GCD calculation using Euclidean algorithm
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        // LCM formula: |a*b| / gcd(a,b)
        // Ensure no division by zero implicitly handled by gcd returning non-zero if inputs valid
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter two integers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            System.out.println("GCD: " + gcd(a, b));
            System.out.println("LCM: " + lcm(a, b));
        }
    }
}
