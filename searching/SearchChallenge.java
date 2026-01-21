package searching;

import java.util.Arrays;

/**
 * Challenge Problem:
 * 1. Linear Search for first missing positive integer.
 * 2. Binary Search for target index (after sorting).
 */
public class SearchChallenge {
    public static void main(String[] args) {
        int[] numbers = { 3, 4, -1, 1 };
        int target = 4;

        // 1. First Missing Positive Integer (Linear Search)
        int missing = findFirstMissingPositive(numbers);
        System.out.println("First missing positive integer: " + missing);

        // 2. Binary Search for target (requires sorting)
        Arrays.sort(numbers);
        int index = binarySearch(numbers, target);
        System.out.println("Index of " + target + " after sorting: " + index);
    }

    /**
     * Finds the first missing positive integer (starting from 1).
     * 
     * @param arr Array of integers
     * @return First missing positive integer
     */
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 2]; // To track numbers up to n+1

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Standard iterative binary search.
     * 
     * @param arr    Sorted array
     * @param target Value to find
     * @return Index or -1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
