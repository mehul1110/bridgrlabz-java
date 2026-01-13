import java.util.*;

public class NumberAnalysis {
    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // return 1 if a>b, 0 if equal, -1 if a<b
    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < 5; i++) {
            int v = arr[i];
            if (!isPositive(v)) {
                System.out.println(v + " is negative");
            } else {
                System.out.println(v + " is positive and " + (isEven(v) ? "even" : "odd"));
            }
        }
        int cmp = compare(arr[0], arr[4]);
        String res = cmp == 1 ? "greater" : (cmp == 0 ? "equal" : "less");
        System.out.println("First element is " + res + " than last element.");
    }
}
