/*
 * Program to demonstrate handling of NullPointerException
 */
public class NullPointerDemo {

    public static void generateNullPointer() {
        String s = null;
        // Attempt to access a method on a null reference, which triggers NullPointerException
        System.out.println(s.length());
    }

    public static void handleNullPointer() {
        String s = null;
        try {
            // Attempt to access a method on a null object inside try block
            System.out.println(s.length());
        } catch (NullPointerException ex) {
            // Catch and handle the NullPointerException gracefully
            System.out.println("Caught NullPointerException: string is null");
        }
    }

    public static void main(String[] args) {
        // Call method that generates exception, wrapped in try-catch to prevent crash
        try {
            generateNullPointer();
        } catch (NullPointerException ex) {
            System.out.println("generateNullPointer threw: " + ex.getClass().getSimpleName());
        }
        
        // Call method that handles the exception internally
        handleNullPointer();
    }
}
