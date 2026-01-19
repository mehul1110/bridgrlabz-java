import java.util.ArrayList;
import java.util.Scanner;

/*
 * Program to determine properties of numbers based on their factors
 * Includes checks for Perfect, Abundant, and Deficient numbers
 */
public class FactorProperties {

    public static int[] factors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        // Iterate to find factors up to square root of n
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                int j = n / i;
                if (j != i) list.add(j);
            }
        }
        // Convert list to array
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int sumOfProperDivisors(int n) {
        int s = 1; // 1 is always a proper divisor for n > 1
        if (n == 1) return 0;
        
        // Iterate to sum proper divisors
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                s += i;
                int j = n / i;
                if (j != i) s += j;
            }
        }
        return s;
    }

    public static boolean isPerfect(int n) {
        // A perfect number is equal to the sum of its proper divisors
        return sumOfProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        // An abundant number's sum of proper divisors is greater than the number itself
        return sumOfProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        // A deficient number's sum of proper divisors is less than the number itself
        return sumOfProperDivisors(n) < n;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        // Find and display factors
        int[] f = factors(n);
        System.out.print("Factors: ");
        for (int x : f) System.out.print(x + " ");
        System.out.println();
        
        // Display factor properties
        System.out.println("Sum of factors = " + java.util.Arrays.stream(f).sum());
        System.out.println("Sum of proper divisors = " + sumOfProperDivisors(n));
        System.out.println("Perfect? " + isPerfect(n));
        System.out.println("Abundant? " + isAbundant(n));
        System.out.println("Deficient? " + isDeficient(n));
        
        // Close Scanner
        sc.close();
    }
}
