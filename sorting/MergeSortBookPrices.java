package sorting;

import java.util.Scanner;

/**
 * Problem 3: Merge Sort - Sort an Array of Book Prices
 * A bookstore maintains a list of book prices in an array.
 * Implement Merge Sort to sort the prices in ascending order.
 */
public class MergeSortBookPrices {

    // Main function that sorts prices[l..r] using merge()
    public static void sort(double[] prices, int l, int r) {
        if (l < r) {
            // Find the middle point to divide the array into two halves
            int m = l + (r - l) / 2;

            // Sort first and second halves recursively
            sort(prices, l, m);
            sort(prices, m + 1, r);

            // Merge the sorted halves
            merge(prices, l, m, r);
        }
    }

    // Merges two subarrays of prices[].
    // First subarray is prices[l..m]
    // Second subarray is prices[m+1..r]
    public static void merge(double[] prices, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        double[] L = new double[n1];
        double[] R = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = prices[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = prices[m + 1 + j];

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.printf("%.2f ", price);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        System.out.println("Original Book Prices:");
        printArray(prices);

        sort(prices, 0, prices.length - 1);

        System.out.println("Sorted Book Prices (Ascending Order):");
        printArray(prices);

        scanner.close();
    }
}
