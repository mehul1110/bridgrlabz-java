package collections.list;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Remove Duplicates While Preserving Order
 * Remove duplicate elements from a list while maintaining the original order of
 * elements.
 * Example: Input: [3, 1, 2, 2, 3, 4] -> Output: [3, 1, 2, 4].
 */
public class RemoveDuplicatesUtil {

    /**
     * Removes duplicates from the list while preserving insertion order.
     * 
     * @param list List with duplicates
     * @return New list without duplicates
     */
    public static <T> List<T> removeDuplicates(List<T> list) {
        // LinkedHashSet maintains insertion order and enforces uniqueness
        Set<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(3);
        input.add(4);

        System.out.println("Input: " + input);
        List<Integer> output = removeDuplicates(input);
        System.out.println("Output: " + output);
    }
}
