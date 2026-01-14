import java.util.Scanner;

public class MaxOfThree {
    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter three integers: ");
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            System.out.println("Max: " + max(a,b,c));
        }
    }
}
