import java.util.*;

/*
 * Program to analyze numbers (check positive, even/odd, and compare)
 * Returns different values based on comparison
 */
public class NumberAnalysis {

    public static boolean isPositive(int n) {
        // Check if the number is greater than or equal to zero
        return n >= 0;
    }

    public static boolean isEven(int n) {
        // Check if the number is divisible by 2
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        // Return 1 if first number is greater
        if (a > b) return 1;
        // Return 0 if numbers are equal
        if (a == b) return 0;
        // Return -1 if first number is smaller
        return -1;
    }

    public static void main(String[] args) {
        // Initialize Scanner for reading input
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[5];
        System.out.println("Enter 5 numbers:");
        
        // Read 5 integers from user
        for (int i = 0; i < 5; i++) arr[i] = sc.nextInt();
        
        // Analyze each number
        for (int i = 0; i < 5; i++) {
            int v = arr[i];
            if (!isPositive(v)) {
                System.out.println(v + " is negative");
            } else {
                System.out.println(v + " is positive and " + (isEven(v) ? "even" : "odd"));
            }
        }
        
        // Compare first and last element
        int cmp = compare(arr[0], arr[4]);
        
        // Determine relationship string
        String res = cmp == 1 ? "greater" : (cmp == 0 ? "equal" : "less");
        
        // Display comparison result
        System.out.println("First element is " + res + " than last element.");
    }
}
