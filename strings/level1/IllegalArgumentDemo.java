import java.util.Scanner;

/*
 * Program to demonstrate IllegalArgumentException
 */
public class IllegalArgumentDemo {

    public static String generateException(String s, int st, int en) {
        // Explicitly check for invalid arguments (start > end) and throw IllegalArgumentException
        if (st > en) {
            throw new IllegalArgumentException("Start index greater than end index");
        }
        // Return substring; this line might throw StringIndexOutOfBoundsException if indices are invalid
        return s.substring(st, en);
    }

    public static void handleException(String s, int st, int en) {
        try {
            // Attempt to create substring which may fail based on inputs
            System.out.println(s.substring(st, en));
        } catch (IllegalArgumentException ex) {
            // Handle logical argument errors
            System.out.println("Caught IllegalArgumentException: " + ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            // Handle array/string index out of bounds errors
            System.out.println("Caught IndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: "); String s = sc.nextLine();
            System.out.print("Enter start index: "); int st = sc.nextInt();
            System.out.print("Enter end index: "); int en = sc.nextInt();
            
            // Try generating exception and catch it in main
            try {
                String result = generateException(s, st, en);
                System.out.println(result);
            } catch (IllegalArgumentException ex) {
                // Catch the explicitly thrown IllegalArgumentException
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            } catch (IndexOutOfBoundsException ex) {
                // Catch potential StringIndexOutOfBoundsException
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            
            // Call method that handles exceptions internally
            handleException(s, st, en);
        }
    }
}
