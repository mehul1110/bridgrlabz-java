import java.util.Scanner;

/*
 * Program to perform checks for special numbers (Prime, Neon, Spy, Automorphic, Buzz)
 */
public class SpecialNumberChecks {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        // Eliminate even numbers > 2
        if (n % 2 == 0) return false;
        // Check for odd factors
        for (int i = 3; i <= Math.sqrt(n); i += 2) if (n % i == 0) return false;
        return true;
    }

    public static boolean isNeon(int n) {
        // Calculate square
        int sq = n * n;
        // Check if sum of digits of square equals the number
        return NumberCheckerUtils.sumDigits(sq) == n;
    }

    public static boolean isSpy(int n) {
        int[] d = NumberCheckerUtils.digitsArray(n);
        int s = 0; int p = 1;
        // Calculate sum and product of digits
        for (int x : d) { s += x; p *= x; }
        // Spy number has sum of digits equal to product of digits
        return s == p;
    }

    public static boolean isAutomorphic(int n) {
        int sq = n * n;
        String s = String.valueOf(sq);
        String t = String.valueOf(n);
        // Check if square ends with the number itself
        return s.endsWith(t);
    }

    public static boolean isBuzz(int n) {
        // Buzz number is divisible by 7 or ends with 7
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        // Perform checks and display results
        System.out.println("Prime? " + isPrime(n));
        System.out.println("Neon? " + isNeon(n));
        System.out.println("Spy? " + isSpy(n));
        System.out.println("Automorphic? " + isAutomorphic(n));
        System.out.println("Buzz? " + isBuzz(n));
        
        // Close Scanner
        sc.close();
    }
}
