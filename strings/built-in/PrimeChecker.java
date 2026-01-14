import java.util.Scanner;

public class PrimeChecker {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i*i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number: ");
            int n = sc.nextInt();
            System.out.println("Prime? " + isPrime(n));
        }
    }
}
