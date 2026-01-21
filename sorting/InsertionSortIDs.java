package sorting;

import java.util.Scanner;

/**
 * Problem 2: Insertion Sort - Sort Employee IDs
 * A company stores employee IDs in an unsorted array.
 * Implement Insertion Sort to sort the employee IDs in ascending order.
 */
public class InsertionSortIDs {

    public static void insertionSort(int[] ids) {
        int n = ids.length;

        // Start from the second element as the first element is considered sorted
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            // Pick an element from the unsorted part (key)
            // and insert it into its correct position in the sorted part.
            // Move elements of ids[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        int[] ids = new int[n];
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }

        System.out.println("Original Employee IDs:");
        printArray(ids);

        insertionSort(ids);

        System.out.println("Sorted Employee IDs (Ascending Order):");
        printArray(ids);

        scanner.close();
    }
}
