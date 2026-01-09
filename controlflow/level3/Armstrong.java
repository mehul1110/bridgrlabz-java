import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = in.nextInt();

        int original = num;
        int sum = 0;
        while (num != 0) {
            int d = num % 10;
            sum += d * d * d;
            num /= 10;
        }

        if (sum == original) System.out.println(original + " is an Armstrong number");
        else System.out.println(original + " is not an Armstrong number");

        in.close();
    }
}
