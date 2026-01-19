import java.util.Scanner;

/*
 * Program to check if a number is prime
 */
public class PrimeChecker {

    public static boolean isPrime(int n) {
        // Numbers less than or equal to 1 are not prime
        if (n <= 1) return false;
        // 2 and 3 are prime
        if (n <= 3) return true;
        
        // Eliminate even numbers greater than 2
        if (n % 2 == 0) return false;
        
        // Loop to check divisibility by odd numbers starting from 3 up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number: ");
            int n = sc.nextInt();
            
            // Display result
            System.out.println("Prime? " + isPrime(n));
        }
    }
}
