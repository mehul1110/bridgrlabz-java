package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Rotate Elements in a List
 * Rotate the elements of a list by a given number of positions.
 * Example: Input: [10, 20, 30, 40, 50], rotate by 2 -> Output: [30, 40, 50, 10,
 * 20].
 */
public class RotateList {

    /**
     * Rotates the list by the given distance.
     * Uses Collections.rotate for efficiency and simplicity,
     * but also providing a manual implementation logic in comments if requested.
     * Here we will use a manual approach as it's often an interview question type.
     * 
     * However, the standard Collections.rotate matches the example behavior where
     * rotating by +2 typically means shifting right (moving end to front).
     * Wait, the example: [10, 20, 30, 40, 50], rotate by 2 -> [30, 40, 50, 10, 20].
     * This looks like a left rotation (shifting elements to the left).
     * 10 moves to index 3 (wraps around), 20 to index 4.
     * 30 moves to index 0, 40 to index 1, 50 to index 2.
     * A left rotation by 2.
     * 
     * @param list     The list to rotate
     * @param distance Number of positions to rotate left
     */
    public static <T> void rotateLeft(List<T> list, int distance) {
        if (list == null || list.isEmpty() || distance <= 0) {
            return;
        }
        int size = list.size();
        distance = distance % size; // Handle distance > size

        List<T> temp = new ArrayList<>(list);
        for (int i = 0; i < size; i++) {
            // New position for element at i being shifted left by distance
            // If we want [10, 20, 30, 40, 50] -> [30, 40, 50, 10, 20] (rotate left by 2)
            // Element at index 2 (30) moves to index 0.
            // Element at index i moves to (i - distance + size) % size ?
            // Let's trace: i=2 (30). (2 - 2 + 5) % 5 = 0. Correct.
            // i=0 (10). (0 - 2 + 5) % 5 = 3. Correct (placed at end).

            int newIndex = (i - distance + size) % size;
            // But we can't set directly if we are doing in-place swaps easily without temp
            // or juggling.
            // Since we created a temp copy of original list, we can just rewrite 'list'.
        }

        // Easier Manual Approach:
        // Remove first element and add to end, repeat 'distance' times.
        for (int i = 0; i < distance; i++) {
            T first = list.remove(0);
            list.add(first);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Original List: " + list);
        int rotateBy = 2;
        rotateLeft(list, rotateBy);
        System.out.println("After rotating left by " + rotateBy + ": " + list);
    }
}
