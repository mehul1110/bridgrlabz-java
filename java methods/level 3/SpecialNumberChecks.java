import java.util.Scanner;

public class SpecialNumberChecks {
    // Q5: prime, neon, spy, automorphic, buzz
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) if (n % i == 0) return false;
        return true;
    }

    public static boolean isNeon(int n) {
        int sq = n * n;
        return NumberCheckerUtils.sumDigits(sq) == n;
    }

    public static boolean isSpy(int n) {
        int[] d = NumberCheckerUtils.digitsArray(n);
        int s = 0; int p = 1;
        for (int x : d) { s += x; p *= x; }
        return s == p;
    }

    public static boolean isAutomorphic(int n) {
        int sq = n * n;
        String s = String.valueOf(sq);
        String t = String.valueOf(n);
        return s.endsWith(t);
    }

    public static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Prime? " + isPrime(n));
        System.out.println("Neon? " + isNeon(n));
        System.out.println("Spy? " + isSpy(n));
        System.out.println("Automorphic? " + isAutomorphic(n));
        System.out.println("Buzz? " + isBuzz(n));
        sc.close();
    }
}
