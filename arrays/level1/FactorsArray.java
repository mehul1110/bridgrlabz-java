import java.util.Scanner;
import java.util.Arrays;

/*
 * Program to find factors of a number and store them in an array
 * Dynamically resizes the array if needed
 */
public class FactorsArray {

    public static void main(String[] args) {
        // Initialize Scanner for input
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = in.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int idx = 0;

        // Iterate to find factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                // Resize array if full
                if (idx == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) temp[j] = factors[j];
                    factors = temp;
                }
                // Store factor
                factors[idx++] = i;
            }
        }

        // Display factors
        System.out.println("Factors:");
        for (int i = 0; i < idx; i++) System.out.print(factors[i] + " ");
        System.out.println();
        
        // Close Scanner
        in.close();
    }
}
