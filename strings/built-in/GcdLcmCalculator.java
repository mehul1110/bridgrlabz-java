import java.util.Scanner;

public class GcdLcmCalculator {
    public static int gcd(int a, int b) { return b==0?Math.abs(a):gcd(b, a%b); }
    public static int lcm(int a, int b) { return Math.abs(a / gcd(a,b) * b); }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter two integers: ");
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println("GCD: " + gcd(a,b));
            System.out.println("LCM: " + lcm(a,b));
        }
    }
}
