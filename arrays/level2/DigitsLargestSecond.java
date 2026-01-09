import java.util.Scanner;

public class DigitsLargestSecond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = Math.abs(in.nextInt());

        int maxDigit = 10; // initial capacity
        int[] digits = new int[maxDigit];
        int idx = 0;
        while (n != 0) {
            if (idx == maxDigit) {
                int[] temp = new int[maxDigit * 2];
                for (int i = 0; i < maxDigit; i++) temp[i] = digits[i];
                digits = temp;
                maxDigit *= 2;
            }
            digits[idx++] = n % 10;
            n /= 10;
        }

        int largest = -1, second = -1;
        for (int i = 0; i < idx; i++) {
            int d = digits[i];
            if (d > largest) { second = largest; largest = d; }
            else if (d > second && d != largest) second = d;
        }

        System.out.println("Largest: " + largest + ", Second largest: " + second);
        in.close();
    }
}
