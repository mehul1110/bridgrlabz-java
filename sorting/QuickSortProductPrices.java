package sorting;

import java.util.Scanner;

/**
 * Problem 4: Quick Sort - Sort Product Prices
 * An e-commerce company wants to display product prices in ascending order.
 * Implement Quick Sort to sort the product prices.
 */
public class QuickSortProductPrices {

    // Main function that implements QuickSort
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, prices[pi] is now at right place */
            int pi = partition(prices, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    /*
     * This function takes last element as pivot, places the pivot element at its
     * correct
     * position in sorted array, and places all smaller (smaller than pivot) to left
     * of pivot and all greater elements to right of pivot
     */
    public static int partition(double[] prices, int low, int high) {
        // Pick the last element as pivot
        double pivot = prices[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;

                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i+1] and prices[high] (or pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.printf("%.2f ", price);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        System.out.println("Original Product Prices:");
        printArray(prices);

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Product Prices (Ascending Order):");
        printArray(prices);

        scanner.close();
    }
}
