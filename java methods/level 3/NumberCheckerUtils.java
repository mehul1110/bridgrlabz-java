/*
 * Utility class providing static methods for various number and digit operations
 */
public class NumberCheckerUtils {

    public static int countDigits(int n) {
        // Use absolute value to handle negative numbers
        n = Math.abs(n);
        if (n == 0) return 1;
        int count = 0;
        // Divide by 10 repeatedly to count digits
        while (n > 0) { n /= 10; count++; }
        return count;
    }

    public static int[] digitsArray(int n) {
        n = Math.abs(n);
        int c = countDigits(n);
        int[] d = new int[c];
        // Populate array with digits from last to first
        for (int i = c - 1; i >= 0; i--) {
            d[i] = n % 10;
            n /= 10;
        }
        return d;
    }

    public static int sumDigits(int n) {
        int s = 0; n = Math.abs(n);
        // Sum last digit and truncated number
        while (n > 0) { s += n % 10; n /= 10; }
        return s;
    }

    public static int sumSquaresDigits(int n) {
        int s = 0; n = Math.abs(n);
        // Sum squares of each digit
        while (n > 0) { int r = n % 10; s += r * r; n /= 10; }
        return s;
    }

    public static int reverseNumber(int n) {
        int rev = 0;
        // Preserve sign
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        // Reverse digits logic
        while (n > 0) { rev = rev * 10 + n % 10; n /= 10; }
        return rev * sign;
    }

    public static boolean isPalindrome(int n) {
        // Check if number equals its reverse
        return n == reverseNumber(n);
    }

    public static boolean isDuck(int n) {
        // Get digits array
        int[] d = digitsArray(n);
        // Check for zero presence, excluding leading zero (implicit in integer logic usually)
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 0 && i != 0) return true;
        }
        return false;
    }
}
