package collections.list;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem: Find the Nth Element from the End
 * Given a singly linked list (use LinkedList), find the Nth element from the
 * end without calculating its size.
 * Example: Input: [A, B, C, D, E], N=2 -> Output: D.
 */
public class NthElementFromEnd {

    /**
     * Finds the Nth element from the end of the list.
     * Note: Java's standard LinkedList is doubly linked, so we can use standard
     * methods or reverse iterator.
     * But the problem says "Given a singly linked list... without calculating its
     * size".
     * Since we are using java.util.LinkedList (which is doubly linked), we can
     * simulate the "singly linked" constraint if needed,
     * or use the efficient approach for standard API.
     * 
     * To strictly follow "without calculating size" and assuming singly-linked
     * behavior simulation:
     * Use two pointers (fast and slow).
     * 
     * @param list The LinkedList
     * @param n    The position from end (1-based)
     * @return The element at Nth position from end
     */
    public static <T> T getNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Two pointer approach simulation on a List interface (inefficient for get(i)
        // on LinkedList if real singly linked)
        // But java.util.LinkedList is doubly linked, so list.get(size - n) is O(N) or
        // O(1) depending on implementation details (usually traverses from closest
        // end).
        // However, the constraint "without calculating size" implies we should iterate.

        // Let's use an iterator-like approach or just temporary list logic?
        // Actually, we can just use the List interface and manual iteration.

        // Size is technically available via .size(), but we must pretend we don't know
        // it.
        // Fast/Slow pointer logic using iterators is best here.

        // Simulating the algorithm:
        // Move fast pointer n steps ahead.
        // Then move both slow and fast until fast reaches end.
        // Slow will be at the target.

        // Since we can't easily get "Pointer" objects from java.util.LinkedList without
        // Iterator,
        // We will use Iterators.

        var mainPtr = list.iterator();
        var refPtr = list.iterator();

        int count = 0;
        while (count < n) {
            if (refPtr.hasNext()) {
                refPtr.next();
                count++;
            } else {
                throw new IllegalArgumentException("List is shorter than N");
            }
        }

        while (refPtr.hasNext()) {
            mainPtr.next();
            refPtr.next();
        }

        return mainPtr.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("Input: " + list);
        int n = 2;
        String result = getNthFromEnd(list, n);
        System.out.println("N=" + n + " element from end: " + result);
    }
}
