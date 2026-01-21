package sorting;

import java.util.Scanner;

/**
 * Problem 1: Bubble Sort - Sort Student Marks
 * A school maintains student marks in an array.
 * Implement Bubble Sort to sort the student marks in ascending order.
 */
public class BubbleSortMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse through the array multiple times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements and swap if needed
            // The last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            // This optimizes the algorithm for already sorted arrays
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];
        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        System.out.println("Original Marks:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("Sorted Marks (Ascending Order):");
        printArray(marks);

        scanner.close();
    }
}
