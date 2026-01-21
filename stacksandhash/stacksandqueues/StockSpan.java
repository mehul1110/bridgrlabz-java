package stacksandhash.stacksandqueues;

import java.util.Stack;
import java.util.Arrays;

/**
 * StockSpan - Calculates stock spans.
 * Simulation: Shows stack of indices during price processing.
 */
public class StockSpan {

    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        System.out.println("Processing Stock Prices...");
        for (int i = 0; i < n; i++) {
            System.out.print("Day " + i + " (Price: " + prices[i] + ") | ");

            // Pop indices while previous prices are smaller or equal
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate span
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
            System.out.println("Stack (Indices): " + stack + " | Span: " + span[i]);
        }
        return span;
    }

    public static void main(String[] args) {
        System.out.println("=== Stock Span Simulation ===");
        StockSpan ss = new StockSpan();
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] result = ss.calculateSpan(prices);
        System.out.println("\nFinal Spans: " + Arrays.toString(result));
    }
}
