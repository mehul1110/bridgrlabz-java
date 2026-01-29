package collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Union and Intersection of Two Sets
 * Given two sets, compute their union and intersection.
 * Example: Set1: {1, 2, 3}, Set2: {3, 4, 5} -> Union: {1, 2, 3, 4, 5},
 * Intersection: {3}.
 */
public class SetOperations {

    public static <T> Set<T> untion(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
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

        System.out.println("Union: " + untion(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
}
