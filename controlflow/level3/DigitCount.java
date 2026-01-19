import java.util.Scanner;

/*
 * Program to count the number of digits in an integer
 */
public class DigitCount {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = Math.abs(in.nextInt());

        // Check for zero
        if (n == 0) {
            System.out.println("Number of digits: 1");
        } else {
            int count = 0;
            // Count digits
            while (n != 0) {
                n /= 10;
                count++;
            }
            System.out.println("Number of digits: " + count);
        }

        // Close Scanner
        in.close();
    }
}
