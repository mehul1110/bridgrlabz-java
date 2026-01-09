import java.util.Scanner;

public class PosNegZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = in.nextInt();
        }

        for (int x : arr) {
            if (x > 0) {
                System.out.print(x + " is positive and ");
                if (x % 2 == 0) System.out.println("even.");
                else System.out.println("odd.");
            } else if (x < 0) System.out.println(x + " is negative.");
            else System.out.println(x + " is zero.");
        }

        int first = arr[0];
        int last = arr[arr.length - 1];
        if (first == last) System.out.println("First and last are equal.");
        else if (first > last) System.out.println("First is greater than last.");
        else System.out.println("First is less than last.");

        in.close();
    }
}
