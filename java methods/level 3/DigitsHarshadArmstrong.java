import java.util.Scanner;

/*
 * Program to perform various digit-based checks on a number
 * Checks include counting digits, Harshad number, and digit frequency
 */
public class DigitsHarshadArmstrong {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        // Perform various checks using utility class
        System.out.println("Digit count = " + NumberCheckerUtils.countDigits(n));
        System.out.println("Digits array = java.util.Arrays.toString(" + java.util.Arrays.toString(NumberCheckerUtils.digitsArray(n)) + ")");
        System.out.println("Sum of digits = " + NumberCheckerUtils.sumDigits(n));
        System.out.println("Sum of squares of digits = " + NumberCheckerUtils.sumSquaresDigits(n));
        
        // Check for Harshad number
        boolean harshad = (n % NumberCheckerUtils.sumDigits(n)) == 0;
        System.out.println("Is Harshad (N divisible by sum of digits)? " + harshad);

        // Calculate and display digit frequencies
        int[] freq = digitFrequency(n);
        System.out.print("Digit frequencies: ");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) System.out.print(i + ":" + freq[i] + " ");
        }
        System.out.println();
        
        // Close Scanner
        sc.close();
    }

    public static int[] digitFrequency(int n) {
        // Handle negative numbers
        n = Math.abs(n);
        int[] f = new int[10];
        
        // Handle case for 0
        if (n == 0) {
            f[0] = 1;
            return f;
        }
        
        // Iterate through digits to count frequency
        while (n > 0) {
            f[n % 10]++;
            n /= 10;
        }
        return f;
    }
}
