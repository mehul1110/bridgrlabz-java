import java.util.Scanner;

/*
 * Program to store digits of a number in an array
 * Uses dynamic resizing for the array to accommodate all digits
 */
public class DigitsResizable {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = Math.abs(in.nextInt());

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int idx = 0;
        
        // Extract digits into array
        while (n != 0) {
            // Resize array logic
            if (idx == maxDigit) {
                maxDigit *= 2;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) temp[i] = digits[i];
                digits = temp;
            }
            digits[idx++] = n % 10;
            n /= 10;
        }

        // Display stored digits
        System.out.print("Digits stored: ");
        for (int i = 0; i < idx; i++) System.out.print(digits[i] + " ");
        System.out.println();
        
        // Close Scanner
        in.close();
    }
}
