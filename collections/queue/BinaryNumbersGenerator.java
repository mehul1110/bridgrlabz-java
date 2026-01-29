package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Generate Binary Numbers Using a Queue
 * Generate the first N binary numbers (as strings) using a queue.
 * Example: N=5 -> Output: ["1", "10", "11", "100", "101"].
 */
public class BinaryNumbersGenerator {

    public static void generateBinaryNumbers(int n) {
        if (n <= 0)
            return;

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            System.out.print("\"" + current + "\"");
            if (i < n - 1) {
                System.out.print(", ");
            }

            queue.add(current + "0");
            queue.add(current + "1");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Generating first " + n + " binary numbers:");
        generateBinaryNumbers(n);
    }
}
