import java.util.Scanner;
import java.util.Arrays;

public class SmallestLargest {
    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int n1 = in.nextInt();
        System.out.print("Enter number2: ");
        int n2 = in.nextInt();
        System.out.print("Enter number3: ");
        int n3 = in.nextInt();
        int[] res = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + res[0] + ", Largest: " + res[1]);
        in.close();
    }
}
