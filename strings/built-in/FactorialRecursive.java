import java.util.Scanner;

/*
 * Program to calculate factorial recursively
 */
public class FactorialRecursive {

    public static long fact(int n) {
        // Base case: for 0 or 1, factorial is 1
        if (n <= 1) return 1;
        // Recursive step: n * factorial of (n-1)
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            
            // Display result
            System.out.println("Fact: " + fact(n));
        }
    }
}
