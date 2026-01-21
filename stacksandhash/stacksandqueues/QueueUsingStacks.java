package stacksandhash.stacksandqueues;

import java.util.Stack;

/**
 * QueueUsingStacks - Implements a FIFO queue using two LIFO stacks.
 * Optimized for frequent enqueue operations.
 * Simulation: Shows stack contents during operations.
 */
public class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue

    public QueueUsingStacks() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int val) {
        stack1.push(val);
        System.out.println("Enqueued [" + val + "] -> S1: " + stack1 + " | S2: " + stack2);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue Underflow - Empty stacks.");
            return -1;
        }

        // If stack2 is empty, move all from stack1 to simulate FIFO
        if (stack2.isEmpty()) {
            System.out.println("S2 empty, transferring from S1...");
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
                System.out.println("Transferring... S1: " + stack1 + " | S2: " + stack2);
            }
        }

        int removed = stack2.pop();
        System.out.println("Dequeued  [" + removed + "] -> S1: " + stack1 + " | S2: " + stack2);
        return removed;
    }

    public static void main(String[] args) {
        System.out.println("=== Queue Using Stacks Simulation ===");
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.enqueue(40);
        q.dequeue();
        q.dequeue();
    }
}
