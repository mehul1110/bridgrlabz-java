import java.util.Scanner;

public class FibonacciGenerator {
    public static void generate(int terms) {
        int a = 0, b = 1;
        for (int i = 0; i < terms; i++) {
            System.out.print(a + (i<terms-1?", ":"\n"));
            int n = a + b; a = b; b = n;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Terms: ");
            int t = sc.nextInt();
            generate(t);
        }
    }
}
