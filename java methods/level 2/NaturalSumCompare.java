import java.util.*;

public class NaturalSumCompare {
    public static long recursiveSum(int n) {
        if (n <= 0) return 0;
        return n + recursiveSum(n - 1);
    }

    public static long formulaSum(int n) {
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Not a natural number. Exiting.");
            return;
        }
        long r = recursiveSum(n);
        long f = formulaSum(n);
        System.out.println("Recursive sum: " + r);
        System.out.println("Formula sum: " + f);
        System.out.println("Equal: " + (r == f));
    }
}
