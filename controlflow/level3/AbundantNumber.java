import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive integer.");
            in.close();
            return;
        }

        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) sum += i;
        }

        if (sum > n) System.out.println(n + " is an Abundant number");
        else System.out.println(n + " is not an Abundant number");

        in.close();
    }
}
