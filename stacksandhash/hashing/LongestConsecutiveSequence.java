package stacksandhash.hashing;

import java.util.HashSet;

/**
 * LongestConsecutiveSequence - Finds length of the longest consecutive elements
 * sequence.
 * Uses a HashSet to lookup elements in constant time.
 */
public class LongestConsecutiveSequence {

    public int findLongest(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr)
            set.add(num);

        int longest = 0;

        for (int num : arr) {
            // Check if this is the start of a sequence (no element smaller than this
            // exists)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand sequence forward
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Longest streak: " + lcs.findLongest(arr)); // Output: 4 (1, 2, 3, 4)
    }
}
