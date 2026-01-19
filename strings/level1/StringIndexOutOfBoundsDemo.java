import java.util.Scanner;

/*
 * Program to demonstrate handling of StringIndexOutOfBoundsException
 */
public class StringIndexOutOfBoundsDemo {

    public static void generateException(String s) {
        // Intentionally attempt to access the character at index equal to length (out of bounds)
        System.out.println(s.charAt(s.length()));
    }

    public static void handleException(String s) {
        try {
            // Try accessing an invalid index (length of string)
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException ex) {
            // Catch and handle the StringIndexOutOfBoundsException
            System.out.println("Caught StringIndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Demonstrate exception generation handled in main
            try {
                generateException(s);
            } catch (StringIndexOutOfBoundsException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            
            // Demonstrate method with internal exception handling
            handleException(s);
        }
    }
}
