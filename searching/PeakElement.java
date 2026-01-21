package searching;

/**
 * Problem: Binary Search to find a peak element (greater than its neighbors).
 */
public class PeakElement {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        int peakIndex = findPeak(arr);
        System.out.println("Peak element " + arr[peakIndex] + " found at index: " + peakIndex);
    }

    /**
     * Finds a peak element index using binary search.
     * 
     * @param arr Array of integers
     * @return Index of a peak element
     */
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is less than the next element, peak is on the right
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Peak is on the left (including mid)
                right = mid;
            }
        }
        return left;
    }
}
