import java.util.Scanner;
import java.util.Arrays;

/*
 * Program to find the smallest and largest among three numbers
 * using Math.min and Math.max functions
 */
public class SmallestLargest {

    public static int[] findSmallestAndLargest(int a, int b, int c) {
        // Determine the smallest number among the three inputs
        int min = Math.min(a, Math.min(b, c));

        // Determine the largest number among the three inputs
        int max = Math.max(a, Math.max(b, c));

        // Return the results as an array with min at index 0 and max at index 1
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        // Create Scanner object needed for user input
        Scanner in = new Scanner(System.in);

        // Read the first number
        System.out.print("Enter number1: ");
        int n1 = in.nextInt();

        // Read the second number
        System.out.print("Enter number2: ");
        int n2 = in.nextInt();

        // Read the third number
        System.out.print("Enter number3: ");
        int n3 = in.nextInt();

        // Find the smallest and largest numbers
        int[] res = findSmallestAndLargest(n1, n2, n3);

        // Print the results to the console
        System.out.println("Smallest: " + res[0] + ", Largest: " + res[1]);

        // Close Scanner
        in.close();
    }
}
