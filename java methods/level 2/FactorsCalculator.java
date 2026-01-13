import java.util.*;

public class FactorsCalculator {
    public static int[] findFactors(int n) {
        int absN = Math.abs(n);
        if (absN == 0) return new int[0];
        int count = 0;
        for (int i = 1; i <= absN; i++) {
            if (absN % i == 0) count++;
        }
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= absN; i++) {
            if (absN % i == 0) factors[idx++] = i;
        }
        return factors;
    }

    public static int sumFactors(int[] factors) {
        int s = 0;
        for (int f : factors) s += f;
        return s;
    }

    public static long productFactors(int[] factors) {
        long p = 1;
        for (int f : factors) p *= f;
        return p;
    }

    public static double sumSquareFactors(int[] factors) {
        double s = 0;
        for (int f : factors) s += Math.pow(f, 2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer to find its factors: ");
        int n = sc.nextInt();
        int[] factors = findFactors(n);
        if (factors.length == 0) {
            System.out.println("No factors for 0 or invalid input.");
            return;
        }
        System.out.println("Factors of " + Math.abs(n) + ": " + Arrays.toString(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Sum of squares of factors: " + sumSquareFactors(factors));
    }
}
