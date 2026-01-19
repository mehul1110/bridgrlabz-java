import java.util.Scanner;
import java.util.Arrays;

/*
 * Program to implement the FizzBuzz game using an array
 * Stores results for numbers up to n
 */
public class FizzBuzz {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a positive number: ");
        int n = in.nextInt();
        
        // Validation check
        if (n < 0) {
            System.out.println("Not a positive integer");
            in.close();
            return;
        }

        String[] res = new String[n + 1];
        
        // Iterate to generate FizzBuzz sequence
        for (int i = 0; i <= n; i++) {
            if (i == 0) res[i] = "0";
            else if (i % 15 == 0) res[i] = "FizzBuzz";
            else if (i % 3 == 0) res[i] = "Fizz";
            else if (i % 5 == 0) res[i] = "Buzz";
            else res[i] = String.valueOf(i);
        }

        // Display results
        for (int i = 0; i <= n; i++) {
            System.out.println("Position " + i + " = " + res[i]);
        }

        // Close Scanner
        in.close();
    }
}
