import java.util.Scanner;

/*
 * Program to find the maximum of three numbers
 */
public class MaxOfThree {

    public static int max(int a, int b, int c) {
        // Use Math.max to compare a and b, then compare result with c
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter three integers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            // Find and display maximum
            System.out.println("Max: " + max(a, b, c));
        }
    }
}
