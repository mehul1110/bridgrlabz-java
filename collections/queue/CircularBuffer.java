package collections.queue;

import java.util.Arrays;

/**
 * Problem: Circular Buffer Simulation
 * Implement a circular buffer (fixed-size queue) using an array-based queue.
 * When full, overwrite the oldest element.
 * Example: Buffer size=3: Insert 1, 2, 3 -> Insert 4 -> Buffer: [2, 3, 4]
 * (logically).
 */
public class CircularBuffer {
    private int[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public void add(int element) {
        if (size == capacity) {
            // Overwrite oldest (head)
            head = (head + 1) % capacity;
            size--;
        }
        buffer[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity]);
            if (i < size - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.printBuffer();

        System.out.println("Adding 4...");
        cb.add(4);
        cb.printBuffer();
    }
}
