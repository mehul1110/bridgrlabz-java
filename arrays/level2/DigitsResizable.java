import java.util.Scanner;

public class DigitsResizable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = Math.abs(in.nextInt());

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int idx = 0;
        while (n != 0) {
            if (idx == maxDigit) {
                maxDigit *= 2;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) temp[i] = digits[i];
                digits = temp;
            }
            digits[idx++] = n % 10;
            n /= 10;
        }

        System.out.print("Digits stored: ");
        for (int i = 0; i < idx; i++) System.out.print(digits[i] + " ");
        System.out.println();
        in.close();
    }
}
