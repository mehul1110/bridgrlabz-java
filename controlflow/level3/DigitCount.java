import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = Math.abs(in.nextInt());

        if (n == 0) {
            System.out.println("Number of digits: 1");
        } else {
            int count = 0;
            while (n != 0) {
                n /= 10;
                count++;
            }
            System.out.println("Number of digits: " + count);
        }

        in.close();
    }
}
