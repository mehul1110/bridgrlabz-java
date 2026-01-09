import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();

        int original = n;
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        if (sum != 0 && original % sum == 0) System.out.println(original + " is a Harshad number");
        else System.out.println(original + " is not a Harshad number");

        in.close();
    }
}
