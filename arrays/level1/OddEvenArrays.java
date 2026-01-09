import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Error: not a natural number");
            in.close();
            return;
        }

        int size = n / 2 + 1;
        int[] evens = new int[size];
        int[] odds = new int[size];
        int ei = 0, oi = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) evens[ei++] = i;
            else odds[oi++] = i;
        }

        System.out.println("Even numbers:");
        for (int i = 0; i < ei; i++) System.out.print(evens[i] + " ");
        System.out.println();
        System.out.println("Odd numbers:");
        for (int i = 0; i < oi; i++) System.out.print(odds[i] + " ");
        System.out.println();
        in.close();
    }
}
