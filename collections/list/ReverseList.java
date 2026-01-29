package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: Reverse a List
 * Write a program to reverse the elements of a given List without using
 * built-in reverse methods.
 * Implement it for both ArrayList and LinkedList.
 * Example: Input: [1, 2, 3, 4, 5] -> Output: [5, 4, 3, 2, 1].
 */
public class ReverseList {

    /**
     * Reverses the given list in place.
     * 
     * @param list The list to reverse
     * @param <T>  The type of elements in the list
     */
    public static <T> void reverseList(List<T> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Test with ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // Test with LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("\nOriginal LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
