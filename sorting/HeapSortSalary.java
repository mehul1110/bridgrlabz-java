package sorting;

import java.util.Scanner;

/**
 * Problem 6: Heap Sort - Sort Job Applicants by Salary
 * A company receives job applications with different expected salary demands.
 * Implement Heap Sort to sort these salary demands in ascending order.
 */
public class HeapSortSalary {

    public static void sort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build a Max Heap from the array
        // (Re-arrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: One by one extract the largest element (root) from heap
        // and place it at the end of the sorted part.
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Reheapify the remaining elements to maintain the max heap property
            heapify(salaries, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in salaries[]
    // n is size of heap
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && salaries[l] > salaries[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && salaries[r] > salaries[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(salaries, n, largest);
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of job applicants: ");
        int n = scanner.nextInt();

        int[] salaries = new int[n];
        System.out.println("Enter the expected salaries:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }

        System.out.println("Original Salaries:");
        printArray(salaries);

        sort(salaries);

        System.out.println("Sorted Salaries (Ascending Order):");
        printArray(salaries);

        scanner.close();
    }
}
