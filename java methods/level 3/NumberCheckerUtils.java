public class NumberCheckerUtils {
    // Utility static methods for digit operations
    public static int countDigits(int n) {
        n = Math.abs(n);
        if (n == 0) return 1;
        int count = 0;
        while (n > 0) { n /= 10; count++; }
        return count;
    }

    public static int[] digitsArray(int n) {
        n = Math.abs(n);
        int c = countDigits(n);
        int[] d = new int[c];
        for (int i = c - 1; i >= 0; i--) {
            d[i] = n % 10;
            n /= 10;
        }
        return d;
    }

    public static int sumDigits(int n) {
        int s = 0; n = Math.abs(n);
        while (n > 0) { s += n % 10; n /= 10; }
        return s;
    }

    public static int sumSquaresDigits(int n) {
        int s = 0; n = Math.abs(n);
        while (n > 0) { int r = n % 10; s += r * r; n /= 10; }
        return s;
    }

    public static int reverseNumber(int n) {
        int rev = 0; int sign = n < 0 ? -1 : 1; n = Math.abs(n);
        while (n > 0) { rev = rev * 10 + n % 10; n /= 10; }
        return rev * sign;
    }

    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    public static boolean isDuck(int n) {
        int[] d = digitsArray(n);
        for (int i = 0; i < d.length; i++) if (d[i] == 0 && i != 0) return true;
        return false;
    }
}
