package sorting;

import java.util.Scanner;

/**
 * Problem 5: Selection Sort - Sort Exam Scores
 * A university needs to sort students’ exam scores in ascending order.
 * Implement Selection Sort to achieve this.
 */
public class SelectionSortExamScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println("Original Exam Scores:");
        printArray(scores);

        selectionSort(scores);

        System.out.println("Sorted Exam Scores (Ascending Order):");
        printArray(scores);

        scanner.close();
    }
}
