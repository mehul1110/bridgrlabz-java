import java.util.Scanner;

public class FactorialRecursive {
    public static long fact(int n) { return n<=1?1:n*fact(n-1); }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            System.out.println("Fact: " + fact(n));
        }
    }
}
