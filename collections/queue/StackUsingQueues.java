package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Implement a Stack Using Queues
 * Implement a stack data structure using two queues and support push, pop, and
 * top operations.
 * Example: Push 1, 2, 3 -> Pop -> Output: 3.
 */
public class StackUsingQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return q1.remove();
    }

    public int top() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        return q1.toString();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        System.out.println("Top: " + stack.top());
    }
}
