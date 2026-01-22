package runtimeanalysis;

/**
 * 5. Problem Statement: Recursive vs Iterative Fibonacci Computation
 * Objective: Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
 */
public class FibonacciComparison {

    public static void main(String[] args) {
        int[] ns = { 10, 30, 40 }; // Reduced 45 to 40 to ensure faster execution for users

        System.out.println("==========================================================================");
        System.out.println("PROBLEM 5: FIBONACCI PERFORMANCE (RECURSIVE vs ITERATIVE)");
        System.out.println("==========================================================================");
        System.out.printf("%-15s | %-20s | %-20s\n", "Fibonacci (N)", "Recursive (ms)", "Iterative (ms)");
        System.out.println("--------------------------------------------------------------------------");

        // Loop through values of N to calculate Fibonacci numbers
        for (int n : ns) {
            // Iterative approach (O(N)): Linear time and space
            long startIter = System.nanoTime();
            fibonacciIterative(n);
            long endIter = System.nanoTime();
            double timeIter = (endIter - startIter) / 1_000_000.0;

            // Recursive approach (O(2^N)): Exponential time complexity
            long startRecur = System.nanoTime();
            fibonacciRecursive(n);
            long endRecur = System.nanoTime();
            double timeRecur = (endRecur - startRecur) / 1_000_000.0;

            System.out.printf("%,-15d | %-20.4f | %-20.4f\n", n, timeRecur, timeIter);
        }
        System.out.println("==========================================================================\n");
    }

    public static long fibonacciRecursive(int n) {
        // Base cases
        if (n <= 1)
            return n;
        // Exponential branching recursion
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static long fibonacciIterative(int n) {
        // Base cases
        if (n <= 1)
            return n;
        long a = 0, b = 1;
        // Loop from 2 up to N to calculate sum iteratively
        for (int i = 2; i <= n; i++) {
            long sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
