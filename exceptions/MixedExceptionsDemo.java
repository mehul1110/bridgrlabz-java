package exceptions;

import java.io.IOException;

/**
 * Problem Statement 6: Throwing and Handling Checked and Unchecked Exceptions
 * 
 * Problem: Method throws both types. Main handles both.
 */
public class MixedExceptionsDemo {

    public static void main(String[] args) {
        try {
            process(true); // Checked
            process(false); // Unchecked (won't reach here if first fails, just for logic)
        } catch (IOException e) {
            System.out.println("Caught Checked: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught Unchecked: " + e.getMessage());
        }
    }

    public static void process(boolean throwChecked) throws IOException {
        if (throwChecked) {
            throw new IOException("Checked Exception");
        } else {
            throw new RuntimeException("Unchecked Exception");
        }
    }
}
