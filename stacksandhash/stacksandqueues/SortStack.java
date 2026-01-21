package stacksandhash.stacksandqueues;

import java.util.Stack;

/**
 * SortStack - Sorts a stack in ascending order using recursion.
 * Simulation: Displays stack states during unwinding and insertion.
 */
public class SortStack {

    // Main sort method
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove top
            int x = stack.pop();
            System.out.println("Popped " + x + " to sort remaining: " + stack);

            // Recursive call
            sort(stack);

            // Re-insert in sorted fashion
            System.out.println("Inserting " + x + " back into sorted: " + stack);
            sortedInsert(stack, x);
        }
    }

    // Helper to insert an element into sorted stack
    private void sortedInsert(Stack<Integer> stack, int val) {
        // Base case
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
        } else {
            // Unwind to find correct spot
            int temp = stack.pop();
            sortedInsert(stack, val);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Sort Stack recursion Simulation ===");
        SortStack ss = new SortStack();
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);

        System.out.println("Initial Stack: " + s);
        ss.sort(s);
        System.out.println("Final Sorted Stack: " + s);
    }
}
