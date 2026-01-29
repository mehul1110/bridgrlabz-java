package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem: Reverse a Queue
 * Reverse the elements of a queue using only queue operations (e.g., add,
 * remove, isEmpty).
 * Note: Often we use a Stack to help reverse a Queue.
 * Example: Input: [10, 20, 30] -> Output: [30, 20, 10].
 */
public class ReverseQueue {

    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
