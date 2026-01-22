package runtimeanalysis;

import java.util.Arrays;
import java.util.Random;

/**
 * 2. Problem Statement: Sorting Large Data Efficiently
 * Objective: Compare Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick
 * Sort (O(N log N)).
 */
public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 100000 };

        System.out
                .println("==========================================================================================");
        System.out.println("PROBLEM 2: SORTING PERFORMANCE (BUBBLE vs MERGE vs QUICK)");
        System.out
                .println("==========================================================================================");
        System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "Dataset Size", "Bubble Sort", "Merge Sort", "Quick Sort");
        System.out
                .println("------------------------------------------------------------------------------------------");

        // Loop through different sizes to measure various sorting algorithms
        for (int n : sizes) {
            int[] original = new Random().ints(n, 0, n * 10).toArray();

            // Bubble Sort (O(N^2)) - Extremely slow for large N
            String bubbleTimeStr = "N/A";
            if (n <= 10000) {
                int[] bubbleData = Arrays.copyOf(original, original.length);
                long start = System.currentTimeMillis();
                bubbleSort(bubbleData);
                bubbleTimeStr = (System.currentTimeMillis() - start) + "ms";
            } else {
                bubbleTimeStr = "Unfeasible (>1hr)";
            }

            // Merge Sort (O(N log N)) - Stable Divide & Conquer
            int[] mergeData = Arrays.copyOf(original, original.length);
            long startMerge = System.currentTimeMillis();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long endMerge = System.currentTimeMillis();

            // Quick Sort (O(N log N)) - Efficient Partition-based
            int[] quickData = Arrays.copyOf(original, original.length);
            long startQuick = System.currentTimeMillis();
            quickSort(quickData, 0, quickData.length - 1);
            long endQuick = System.currentTimeMillis();

            System.out.printf("%,-15d | %-15s | %-15d | %-15d\n", n, bubbleTimeStr, (endMerge - startMerge),
                    (endQuick - startQuick));
        }
        System.out.println(
                "==========================================================================================\n");
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for element comparison and swapping
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            // Recursive splitting of the array
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        // Loop to merge the two sorted halves back together
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        // Copy remaining elements of L[]
        while (i < n1)
            arr[k++] = L[i++];
        // Copy remaining elements of R[]
        while (j < n2)
            arr[k++] = R[j++];
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // Recursive partitioning
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        // Loop to rearrange segments around the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
