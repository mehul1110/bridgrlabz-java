package multithreading;

import java.util.Scanner;

/**
 * Problem Statement 1: Simple Threaded Counter
 * 
 * Background:
 * A simple threaded counter program that counts from 1 to a specified limit
 * concurrently using multiple threads. It demonstrates thread coordination and
 * synchronization.
 */
public class SimpleThreadedCounter {

    // Shared counter variable
    private static int counter = 1;
    // Number of threads to use for counting
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Simple Threaded Counter ===");
        System.out.print("Enter the counting limit (e.g., 20): ");

        int limit = 0;

        // Error handling for user input
        try {
            limit = Integer.parseInt(scanner.nextLine());
            if (limit <= 0) {
                System.out.println("Error: Please enter a positive integer greater than 0.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid numerical integer.");
            return;
        } finally {
            scanner.close(); // Close scanner to prevent memory leak
        }

        // Lock object for synchronization
        Object lock = new Object();

        System.out.println("\nStarting counting process with " + NUM_THREADS + " threads...\n");

        Thread[] threads = new Thread[NUM_THREADS];

        // Creating and starting threads
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            final int finalLimit = limit;

            threads[i] = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        // Break condition: if counter exceeds the limit
                        if (counter > finalLimit) {
                            lock.notifyAll(); // Notify other waiting threads to also exit
                            break;
                        }

                        // Condition to check whose turn it is
                        // Thread-1 prints 1, 4, 7... Thread-2 prints 2, 5, 8... Thread-3 prints 3, 6,
                        // 9...
                        int expectedRemainder = (threadId + 1) % NUM_THREADS;
                        if (counter % NUM_THREADS == expectedRemainder) {
                            System.out.println("Thread-" + (threadId + 1) + " counts: " + counter);
                            counter++;
                            lock.notifyAll(); // Wake up other threads to check the condition
                        } else {
                            try {
                                lock.wait(); // Wait for turn
                            } catch (InterruptedException e) {
                                System.out.println("Thread-" + (threadId + 1) + " was interrupted.");
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }, "Thread-" + (i + 1));

            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted while waiting for workers.");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nCounting completed successfully!");
    }
}
