import java.util.Scanner;
import java.util.Arrays;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int n = in.nextInt();
        if (n < 0) {
            System.out.println("Not a positive integer");
            in.close();
            return;
        }

        String[] res = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) res[i] = "0";
            else if (i % 15 == 0) res[i] = "FizzBuzz";
            else if (i % 3 == 0) res[i] = "Fizz";
            else if (i % 5 == 0) res[i] = "Buzz";
            else res[i] = String.valueOf(i);
        }

        for (int i = 0; i <= n; i++) {
            System.out.println("Position " + i + " = " + res[i]);
        }

        in.close();
    }
}
