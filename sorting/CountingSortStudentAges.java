package sorting;

import java.util.Scanner;

/**
 * Problem 7: Counting Sort - Sort Student Ages
 * A school collects students’ ages (ranging from 10 to 18) and wants them
 * sorted.
 * Implement Counting Sort for this task.
 */
public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int n = ages.length;
        if (n == 0)
            return;

        // Find the range of ages (given as 10 to 18, but we can detect it)
        int min = ages[0];
        int max = ages[0];
        for (int i = 1; i < n; i++) {
            if (ages[i] < min)
                min = ages[i];
            if (ages[i] > max)
                max = ages[i];
        }

        // Create a count array to store the frequency of each age
        int range = max - min + 1;
        int[] count = new int[range];

        // Store frequency of each element
        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }

        // Compute cumulative frequencies to determine positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in their correct positions in the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Copy the output array to the original array
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
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

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the students' ages (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("Original Ages:");
        printArray(ages);

        countingSort(ages);

        System.out.println("Sorted Student Ages (Ascending Order):");
        printArray(ages);

        scanner.close();
    }
}
