import java.util.*;

/*
 * Program to calculate factors of a number and their properties
 * such as sum, product, and sum of squares
 */
public class FactorsCalculator {

    public static int[] findFactors(int n) {
        // Use absolute value
        int absN = Math.abs(n);
        if (absN == 0) return new int[0];
        
        int count = 0;
        // Count factors first to initialize array of correct size
        for (int i = 1; i <= absN; i++) {
            if (absN % i == 0) count++;
        }
        
        int[] factors = new int[count];
        int idx = 0;
        // Populate array with factors
        for (int i = 1; i <= absN; i++) {
            if (absN % i == 0) factors[idx++] = i;
        }
        return factors;
    }

    public static int sumFactors(int[] factors) {
        int s = 0;
        // Iterate through factors to calculate sum
        for (int f : factors) s += f;
        return s;
    }

    public static long productFactors(int[] factors) {
        long p = 1;
        // Iterate through factors to calculate product
        for (int f : factors) p *= f;
        return p;
    }

    public static double sumSquareFactors(int[] factors) {
        double s = 0;
        // Iterate through factors to calculate sum of squares
        for (int f : factors) s += Math.pow(f, 2);
        return s;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter an integer to find its factors: ");
        int n = sc.nextInt();
        
        // Find factors
        int[] factors = findFactors(n);
        
        if (factors.length == 0) {
            System.out.println("No factors for 0 or invalid input.");
            return;
        }
        
        // Display results
        System.out.println("Factors of " + Math.abs(n) + ": " + Arrays.toString(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Sum of squares of factors: " + sumSquareFactors(factors));
    }
}
