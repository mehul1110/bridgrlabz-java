import java.util.Scanner;

/*
 * Program to generate Fibonacci sequence up to a given number of terms
 */
public class FibonacciGenerator {

    public static void generate(int terms) {
        int a = 0, b = 1;
        // Loop to generate 'terms' number of Fibonacci numbers
        for (int i = 0; i < terms; i++) {
            // Print current term with separator
            System.out.print(a + (i < terms - 1 ? ", " : "\n"));
            
            // Calculate next term
            int n = a + b;
            a = b;
            b = n;
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Terms: ");
            int t = sc.nextInt();
            
            // Generate sequence
            generate(t);
        }
    }
}
