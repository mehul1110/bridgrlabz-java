import java.util.Scanner;
import java.util.Arrays;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        long num = Math.abs(in.nextLong());
        if (num == 0) {
            System.out.println("Digit 0: 1");
            in.close();
            return;
        }

        int countDigits = 0;
        long temp = num;
        while (temp != 0) { temp /= 10; countDigits++; }

        int[] digits = new int[countDigits];
        temp = num;
        int idx = 0;
        while (temp != 0) {
            digits[idx++] = (int)(temp % 10);
            temp /= 10;
        }

        int[] freq = new int[10];
        for (int i = 0; i < idx; i++) freq[digits[i]]++;

        for (int d = 0; d < 10; d++) System.out.println("Digit " + d + ": " + freq[d]);
        in.close();
    }
}
