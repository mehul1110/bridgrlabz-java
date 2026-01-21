package searching;

/**
 * Problem: Linear Search to find the first negative number in an array.
 */
public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] numbers = { 10, 5, 8, -3, 7, -1, 4 };

        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number " + numbers[index] + " found at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }

    /**
     * Performs linear search to find first negative number.
     * 
     * @param arr Array of integers
     * @return Index of first negative number, or -1 if none found.
     */
    public static int findFirstNegative(int[] arr) {
        if (arr == null)
            return -1;

        // Iterate through the array from the start
        for (int i = 0; i < arr.length; i++) {
            // Return early if element is found
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
