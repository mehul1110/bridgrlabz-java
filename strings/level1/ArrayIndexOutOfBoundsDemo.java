import java.util.Scanner;

/*
 * Program to demonstrate handling of ArrayIndexOutOfBoundsException
 */
public class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] arr) {
        // Attempt to access an index equal to the array length, which is out of bounds
        System.out.println(arr[arr.length]);
    }

    public static void handleException(String[] arr) {
        try {
            // Try accessing an invalid index to trigger the exception
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Catch and handle the ArrayIndexOutOfBoundsException to prevent program crash
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner for user input
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many names? ");
            int n = sc.nextInt();
            // Consume the newline character left after nextInt()
            sc.nextLine();
            
            // Create an array to store identifiers
            String[] names = new String[n];
            
            // Loop to read 'n' names from the user input
            for (int i = 0; i < n; i++) {
                System.out.print("Enter name " + (i+1) + ": ");
                names[i] = sc.nextLine();
            }
            
            // Demonstrate exception generation inside a try-catch block for safety
            try {
                generateException(names);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            
            // Demonstrate the method that handles the exception internally
            handleException(names);
        }
    }
}
