package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Problem Statement 2: Producer-Consumer with Shared Resource
 * 
 * Background:
 * Implement a simple producer-consumer program where one thread generates
 * tasks (producers), and another thread processes these tasks (consumers)
 * using a shared queue.
 */
public class ProducerConsumerProgram {

    public static void main(String[] args) {
        System.out.println("=== Producer-Consumer Program ===\n");

        // Initialize the shared resource with a maximum capacity of 5
        TaskQueue sharedQueue = new TaskQueue(5);

        // Create Producer and Consumer threads
        Thread producerThread = new Thread(new Producer(sharedQueue), "Producer-Thread");
        Thread consumerThread = new Thread(new Consumer(sharedQueue), "Consumer-Thread");

        // Start the threads
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\nProgram execution completed successfully.");
    }
}

/**
 * Shared Resource Class that handles synchronization
 */
class TaskQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public TaskQueue(int capacity) {
        this.capacity = capacity;
    }

    // Synchronized method for producing tasks
    public synchronized void produceTask(int task) throws InterruptedException {
        // Wait if the queue is full
        while (queue.size() == capacity) {
            System.out.println(Thread.currentThread().getName() + " is waiting. Queue is full...");
            wait();
        }

        // Add task to queue and notify waiting threads
        queue.add(task);
        System.out.println(Thread.currentThread().getName() + " [+] Produced task: " + task);
        notifyAll(); // Notify consumer thread that there is a task to consume
    }

    // Synchronized method for consuming tasks
    public synchronized int consumeTask() throws InterruptedException {
        // Wait if the queue is empty
        while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " is waiting. Queue is empty...");
            wait();
        }

        // Retrieve and remove task, then notify waiting threads
        int task = queue.poll();
        System.out.println(Thread.currentThread().getName() + " [-] Consumed task: " + task);
        notifyAll(); // Notify producer thread that space freed up in the queue

        return task;
    }
}

/**
 * Producer Thread generates tasks asynchronously
 */
class Producer implements Runnable {
    private final TaskQueue sharedQueue;
    private final int TOTAL_TASKS = 10; // Number of tasks parameter

    public Producer(TaskQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 1; i <= TOTAL_TASKS; i++) {
                sharedQueue.produceTask(i);
                // Simulate production delay
                Thread.sleep(random.nextInt(400) + 100);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: Producer was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Consumer Thread processes tasks asynchronously
 */
class Consumer implements Runnable {
    private final TaskQueue sharedQueue;
    private final int TOTAL_TASKS = 10;

    public Consumer(TaskQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 1; i <= TOTAL_TASKS; i++) {
                sharedQueue.consumeTask();
                // Simulate consumption delay (slightly slower to simulate queue filling up)
                Thread.sleep(random.nextInt(600) + 200);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: Consumer was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
