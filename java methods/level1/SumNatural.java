import java.util.Scanner;

public class SumNatural {
    public static long sumN(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        long n = in.nextLong();
        System.out.println("Sum: " + sumN(n));
        in.close();
    }
}
