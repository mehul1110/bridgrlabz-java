import java.util.Scanner;

/*
 * Program to check if a number is a prime number
 */
public class PrimeCheck {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = in.nextInt();

        // Prime check logic
        if (n <= 1) {
            System.out.println(n + " is not a prime number");
        } else {
            boolean isPrime = true;
            // Check for factors from 2 up to sqrt(n)
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.println(n + (isPrime ? " is a prime number" : " is not a prime number"));
        }

        // Close Scanner
        in.close();
    }
}
