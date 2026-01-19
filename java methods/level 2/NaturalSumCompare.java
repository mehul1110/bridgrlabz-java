import java.util.*;

/*
 * Program to compare the sum of natural numbers calculated via recursion and formula
 */
public class NaturalSumCompare {

    public static long recursiveSum(int n) {
        // Base case: if n is 0 or less, sum is 0
        if (n <= 0) return 0;
        
        // Recursive step: n + sum of (n-1)
        return n + recursiveSum(n - 1);
    }

    public static long formulaSum(int n) {
        // Use mathematical formula n * (n + 1) / 2
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        
        // Validate input
        if (n <= 0) {
            System.out.println("Not a natural number. Exiting.");
            return;
        }
        
        // Calculate sums
        long r = recursiveSum(n);
        long f = formulaSum(n);
        
        // Display results and comparison
        System.out.println("Recursive sum: " + r);
        System.out.println("Formula sum: " + f);
        System.out.println("Equal: " + (r == f));
    }
}
