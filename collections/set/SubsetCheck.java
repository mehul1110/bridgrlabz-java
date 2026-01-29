package collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Find Subsets
 * Check if one set is a subset of another.
 * Example: Set1: {2, 3}, Set2: {1, 2, 3, 4} -> Output: true.
 * (Note: The example checks if Set1 is a subset of Set2)
 */
public class SubsetCheck {

    /**
     * Checks if setA is a subset of setB.
     */
    public static <T> boolean isSubset(Set<T> sub, Set<T> main) {
        return main.containsAll(sub);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(); // small
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>(); // big
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
    }
}
