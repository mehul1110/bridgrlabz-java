package stacksandhash.hashing;

import java.util.HashMap;
import java.util.Arrays;

/**
 * TwoSum - Finds indices of two elements that add up to a target sum.
 * Returns the indices using a Hash Map for O(n) lookups.
 */
public class TwoSum {

    public int[] findIndices(int[] arr, int target) {
        // Map stores: value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement already exists in map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current value and index
            map.put(arr[i], i);
        }

        return new int[] { -1, -1 }; // Not found
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println("Target " + target + " found at indices: " +
                Arrays.toString(ts.findIndices(arr, target)));
    }
}
