import java.util.Scanner;

/*
 * Program to check if a number is an Armstrong number
 * An Armstrong number is equal to the sum of cubes of its digits
 */
public class Armstrong {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int num = in.nextInt();

        int original = num;
        int sum = 0;
        
        // Calculate sum of cubes of digits
        while (num != 0) {
            int d = num % 10;
            sum += d * d * d;
            num /= 10;
        }

        // Compare sum with original number
        if (sum == original) System.out.println(original + " is an Armstrong number");
        else System.out.println(original + " is not an Armstrong number");

        // Close Scanner
        in.close();
    }
}
