package collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Find the Key with the Highest Value
 * Given a Map<String, Integer>, find the key with the maximum value.
 * Example: Input: {A=10, B=20, C=15} -> Output: B.
 */
public class MaxValueKey {

    public static String getKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty())
            return null;

        // Using Collections.max with custom comparator on entry set
        // Or simple iteration

        // Simple iteration approach
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry != null ? maxEntry.getKey() : null;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println("Input: " + map);
        System.out.println("Key with max value: " + getKeyWithMaxValue(map));
    }
}
