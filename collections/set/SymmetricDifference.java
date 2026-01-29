package collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Symmetric Difference
 * Find the symmetric difference (elements present in either set but not in
 * both) of two sets.
 * Example: Set1: {1, 2, 3}, Set2: {3, 4, 5} -> Output: {1, 2, 4, 5}.
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        // (A - B) U (B - A)
        // Or (A U B) - (A n B)

        Set<T> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2); // Elements in 1 but not in 2

        Set<T> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1); // Elements in 2 but not in 1

        diff1.addAll(diff2);
        return diff1;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}
