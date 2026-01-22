package runtimeanalysis;

import java.util.*;

/**
 * 6. Problem Statement: Comparing Different Data Structures for Searching
 * Objective: Compare Array/ArrayList (O(N)), HashSet (O(1)), and TreeSet (O(log
 * N)) for searching.
 */
public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int[] sizes = { 1000, 100000, 1000000 };

        System.out
                .println("==========================================================================================");
        System.out.println("PROBLEM 6: COLLECTION SEARCH PERFORMANCE (LIST vs HASHSET vs TREESET)");
        System.out
                .println("==========================================================================================");
        System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "Dataset Size", "ArrayList (ms)", "HashSet (ms)",
                "TreeSet (ms)");
        System.out
                .println("------------------------------------------------------------------------------------------");

        // Loop through different sizes to test search performance in various
        // collections
        for (int n : sizes) {
            List<Integer> list = new ArrayList<>(n);
            Set<Integer> hashSet = new HashSet<>(n);
            Set<Integer> treeSet = new TreeSet<>();

            // Populate all data structures with the same set of numbers
            for (int i = 0; i < n; i++) {
                list.add(i);
                hashSet.add(i);
                treeSet.add(i);
            }

            int target = n - 1; // Last element to force worst case for the indexed list

            // ArrayList.contains() (O(N)): Performs a sequential scan
            long startList = System.nanoTime();
            list.contains(target);
            long endList = System.nanoTime();

            // HashSet.contains() (O(1)): Uses bucket hashing for nearly instant retrieval
            long startHash = System.nanoTime();
            hashSet.contains(target);
            long endHash = System.nanoTime();

            // TreeSet.contains() (O(log N)): Navigates a Red-Black tree structure
            long startTree = System.nanoTime();
            treeSet.contains(target);
            long endTree = System.nanoTime();

            System.out.printf("%,-15d | %-15.4f | %-15.4f | %-15.4f\n",
                    n,
                    (endList - startList) / 1_000_000.0,
                    (endHash - startHash) / 1_000_000.0,
                    (endTree - startTree) / 1_000_000.0);
        }
        System.out.println(
                "==========================================================================================\n");
    }
}
