package collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Check if Two Sets Are Equal
 * Compare two sets and determine if they contain the same elements, regardless
 * of order.
 * Example: Set1: {1, 2, 3}, Set2: {3, 2, 1} -> Output: true.
 */
public class SetEquality {

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            return set1 == set2;
        }
        // Set.equals() checks for equality of elements, ignoring order.
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Are sets equal? " + areSetsEqual(set1, set2));
    }
}
