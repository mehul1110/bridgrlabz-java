package collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Convert a Set to a Sorted List
 * Convert a HashSet of integers into a sorted list in ascending order.
 * Example: Input: {5, 3, 9, 1} -> Output: [1, 3, 5, 9].
 */
public class SetToSortedList {

    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        System.out.println("Input HashSet: " + set);
        List<Integer> sortedList = convertAndSort(set);
        System.out.println("Sorted List: " + sortedList);
    }
}
