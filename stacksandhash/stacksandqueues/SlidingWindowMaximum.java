package stacksandhash.stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * SlidingWindowMaximum - Finds max in windows of size k.
 * Simulation: Visualizes the window and the Deque indices.
 */
public class SlidingWindowMaximum {

    public ArrayList<Integer> findMax(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        System.out.println("Input Array: " + Arrays.toString(arr) + " (k=" + k + ")");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < arr.length; i++) {
            // Remove indices out of current window scope
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.removeFirst();
            }

            // Remove smaller elements as they won't be max in current/future windows
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            // Print simulation state
            if (i >= k - 1) {
                int[] window = Arrays.copyOfRange(arr, i - k + 1, i + 1);
                int maxVal = arr[dq.peekFirst()];
                System.out.println(
                        "Window " + Arrays.toString(window) + " | Deque(indices): " + dq + " | Max: " + maxVal);
                result.add(maxVal);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Sliding Window Maximum Simulation ===");
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        swm.findMax(arr, 3);
    }
}
