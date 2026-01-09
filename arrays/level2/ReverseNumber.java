import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();
        int original = n;
        n = Math.abs(n);
        int[] digits = new int[20];
        int idx = 0;
        while (n != 0) {
            digits[idx++] = n % 10;
            n /= 10;
        }
        System.out.print("Reversed: ");
        for (int i = 0; i < idx; i++) System.out.print(digits[i]);
        System.out.println();
        in.close();
    }
}
