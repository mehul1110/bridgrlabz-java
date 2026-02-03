package exceptions;

/**
 * Practice Problem 9: Nested try-catch
 * 
 * Problem: Array access and division.
 * Expected:
 * - Invalid Index -> "Invalid array index!"
 * - Div by zero -> "Cannot divide by zero!"
 */
public class NestedTryCatchDemo {

    public static void main(String[] args) {
        // Test 1: Invalid Index
        runTest(new int[] { 10 }, 1, 0);

        // Test 2: Div by Zero
        runTest(new int[] { 10 }, 0, 0);

        // Test 3: Valid
        runTest(new int[] { 10 }, 0, 2);
    }

    public static void runTest(int[] arr, int index, int divisor) {
        try {
            // Nested structure as requested
            try {
                int val = arr[index];
                try {
                    int res = val / divisor;
                    System.out.println("Result: " + res);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (Exception e) {
            System.out.println("General error");
        }
    }
}
