package stacksandhash.hashing;

import java.util.HashSet;

/**
 * PairSum - Checks if a pair of elements exists with a given target sum.
 * Uses a HashSet to achieve O(n) time complexity.
 */
public class PairSum {

    public boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            // Check if complement of current number was already visited
            if (set.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            // Add current number to visited set
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        PairSum ps = new PairSum();
        int[] arr = { 10, 15, 3, 7 };
        int target = 17;
        System.out.println("Has pair for " + target + "? " + ps.hasPair(arr, target));
    }
}
