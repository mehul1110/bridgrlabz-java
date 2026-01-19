import java.util.Scanner;
import java.util.Arrays;

/*
 * Program to find the frequency of each digit in a given number
 * Handles large numbers using long
 */
public class DigitFrequency {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        long num = Math.abs(in.nextLong());
        
        // Handle case for 0 separately
        if (num == 0) {
            System.out.println("Digit 0: 1");
            in.close();
            return;
        }

        int countDigits = 0;
        long temp = num;
        
        // Count number of digits
        while (temp != 0) { temp /= 10; countDigits++; }

        int[] digits = new int[countDigits];
        temp = num;
        int idx = 0;
        
        // Extract digits into an array
        while (temp != 0) {
            digits[idx++] = (int)(temp % 10);
            temp /= 10;
        }

        int[] freq = new int[10];
        
        // Count frequency of each digit
        for (int i = 0; i < idx; i++) freq[digits[i]]++;

        // Display frequencies
        for (int d = 0; d < 10; d++) System.out.println("Digit " + d + ": " + freq[d]);
        
        // Close Scanner
        in.close();
    }
}
