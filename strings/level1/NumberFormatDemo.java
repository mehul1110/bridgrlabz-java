import java.util.Scanner;

/*
 * Program to demonstrate handling of NumberFormatException
 */
public class NumberFormatDemo {

    public static int generateException(String text) {
        // Attempt to parse a non-numeric string to integer, which may throw exceptions
        return Integer.parseInt(text);
    }

    public static void handleException(String text) {
        try {
            // Try parsing the string to an integer
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException ex) {
            // Handle the case where the string does not contain a parsable integer
            System.out.println("Caught NumberFormatException: invalid integer");
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text to parse as int: ");
            String text = sc.nextLine();
            
            // Demonstrate exception generation with external handling
            try {
                int v = generateException(text);
                System.out.println("Parsed value: " + v);
            } catch (NumberFormatException ex) {
                System.out.println("generateException threw: " + ex.getClass().getSimpleName());
            }
            
            // Demonstrate exception handling within the method
            handleException(text);
        }
    }
}
