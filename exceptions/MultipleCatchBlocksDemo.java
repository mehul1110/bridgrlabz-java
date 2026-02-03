package exceptions;

/**
 * Practice Problem 4: Multiple Catch Blocks
 * 
 * Problem: Array operations.
 * Expected:
 * - Valid -> "Value at index X: Y"
 * - Out of bounds -> "Invalid index!"
 * - Null -> "Array is not initialized!"
 */
public class MultipleCatchBlocksDemo {

    public static void main(String[] args) {
        // Test Case 1: Valid
        processArray(new int[] { 10, 20, 30 }, 1);

        // Test Case 2: Out of bounds
        processArray(new int[] { 10, 20, 30 }, 5);

        // Test Case 3: Null array
        processArray(null, 1);
    }

    public static void processArray(int[] arr, int index) {
        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
