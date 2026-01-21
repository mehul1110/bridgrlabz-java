package stacksandhash.hashing;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * ZeroSumSubarrays - Finds all subarrays whose elements sum to zero.
 * Uses a Hash Map to store cumulative sums and their indices.
 */
public class ZeroSumSubarrays {

    // Internal class to represent result pairs
    private static class Pair {
        int start, end;

        Pair(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public ArrayList<Pair> findAll(int[] arr) {
        ArrayList<Pair> result = new ArrayList<>();
        // Map sum to list of indices where this sum occurred
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // If current sum is zero, a subarray from index 0 to i is found
            if (currentSum == 0) {
                result.add(new Pair(0, i));
            }

            // If sum repeats, subarrays between previous occurrences and current index sum
            // to zero
            if (map.containsKey(currentSum)) {
                ArrayList<Integer> indices = map.get(currentSum);
                for (int startIdx : indices) {
                    result.add(new Pair(startIdx + 1, i));
                }
            }

            // Store index in map for current sum
            map.putIfAbsent(currentSum, new ArrayList<>());
            map.get(currentSum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ZeroSumSubarrays zss = new ZeroSumSubarrays();
        int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        ArrayList<Pair> pairs = zss.findAll(arr);

        System.out.println("Zero-sum Subarrays found:");
        for (Pair p : pairs) {
            System.out.println("From index " + p.start + " to " + p.end);
        }
    }
}
