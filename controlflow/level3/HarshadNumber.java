import java.util.Scanner;

/*
 * Program to check if a number is a Harshad number
 * A Harshad number is divisible by the sum of its digits
 */
public class HarshadNumber {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = in.nextInt();

        int original = n;
        int sum = 0;
        
        // Calculate sum of digits
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        // Check divisibility
        if (sum != 0 && original % sum == 0) System.out.println(original + " is a Harshad number");
        else System.out.println(original + " is not a Harshad number");

        // Close Scanner
        in.close();
    }
}
