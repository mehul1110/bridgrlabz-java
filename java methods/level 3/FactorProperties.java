import java.util.ArrayList;
import java.util.Scanner;

public class FactorProperties {
    // Q6: factors, sum, product, perfect, abundant, deficient, strong number etc.
    public static int[] factors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                int j = n / i;
                if (j != i) list.add(j);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int sumOfProperDivisors(int n) {
        int s = 1;
        if (n == 1) return 0;
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
        return sumOfProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumOfProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumOfProperDivisors(n) < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int[] f = factors(n);
        System.out.print("Factors: ");
        for (int x : f) System.out.print(x + " ");
        System.out.println();
        System.out.println("Sum of factors = " + java.util.Arrays.stream(f).sum());
        System.out.println("Sum of proper divisors = " + sumOfProperDivisors(n));
        System.out.println("Perfect? " + isPerfect(n));
        System.out.println("Abundant? " + isAbundant(n));
        System.out.println("Deficient? " + isDeficient(n));
        sc.close();
    }
}
