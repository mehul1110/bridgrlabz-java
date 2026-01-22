package runtimeanalysis;

import java.util.Arrays;
import java.util.Random;

/**
 * 1. Problem Statement: Search a Target in a Large Dataset
 * Objective: Compare performance of Linear Search (O(N)) and Binary Search
 * (O(log N)).
 */
public class SearchComparison {

    public static void main(String[] args) {
        int[] datasetSizes = { 1000, 10000, 1000000 };

        System.out.println("==========================================================================");
        System.out.println("PROBLEM 1: SEARCH PERFORMANCE (LINEAR vs BINARY)");
        System.out.println("==========================================================================");
        System.out.printf("%-15s | %-20s | %-20s\n", "Dataset Size", "Linear Search (ns)", "Binary Search (ns)");
        System.out.println("--------------------------------------------------------------------------");

        // Loop through different dataset sizes to compare search performance
        for (int n : datasetSizes) {
            int[] data = new int[n];
            Random random = new Random();

            // Loop to populate the dataset with random integers
            for (int i = 0; i < n; i++) {
                data[i] = random.nextInt(n * 10);
            }

            int target = data[n - 1]; // Search for the last element for worst-case Linear Search

            // Linear Search (O(N)): Scans each element until target is found
            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();

            // Binary Search Requirement: Data must be sorted first (O(N log N))
            Arrays.sort(data);

            // Binary Search (O(log N)): Repeatedly cuts the search range in half
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();

            System.out.printf("%,-15d | %-20d | %-20d\n", n, (endLinear - startLinear), (endBinary - startBinary));
        }
        System.out.println("==========================================================================\n");
    }

    private static int linearSearch(int[] arr, int target) {
        // Sequential iteration through the entire array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        // Logarithmic search range reduction
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
