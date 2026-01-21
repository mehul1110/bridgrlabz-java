package searching;

/**
 * Problem: Binary Search to find the index of the smallest element in a rotated
 * sorted array.
 */
public class RotationPoint {
    public static void main(String[] args) {
        int[] rotatedArray = { 4, 5, 6, 7, 0, 1, 2 };

        int rotationIndex = findRotationPoint(rotatedArray);
        System.out.println("The smallest element is " + rotatedArray[rotationIndex] + " at index: " + rotationIndex);
    }

    /**
     * Finds the index of the smallest element using binary search.
     * 
     * @param arr Rotated sorted array
     * @return Index of the rotation point
     */
    public static int findRotationPoint(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Avoid overflow using mid = left + (right - left) / 2
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }
        return left;
    }
}
