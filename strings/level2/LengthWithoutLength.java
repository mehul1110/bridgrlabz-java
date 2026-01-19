import java.util.Scanner;

/*
 * Program to calculate length of a string without using length() method
 */
public class LengthWithoutLength {

    public static int manualLength(String s) {
        int count = 0;
        try {
            // Loop indefinitely until an IndexOutOfBoundsException occurs
            // This effectively counts characters one by one
            while (true) {
                // Access character at current index 'count'
                s.charAt(count);
                // Increment counter if character access is successful
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception caught means we reached the end of the string
            // The loop terminates here
        }
        return count;
    }

    public static void main(String[] args) {
        // Initialize Scanner for user input
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text (no spaces): ");
            String input = sc.next();
            
            // Calculate and display length using manual method
            System.out.println("Manual length: " + manualLength(input));
            
            // Display length using built-in method for verification
            System.out.println("Built-in length: " + input.length());
        }
    }
}
