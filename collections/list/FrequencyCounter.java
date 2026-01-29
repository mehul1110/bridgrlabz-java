package collections.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Find Frequency of Elements
 * Given a list of strings, count the frequency of each element and return the
 * results in a Map<String, Integer>.
 * Example: Input: ["apple", "banana", "apple", "orange"] -> Output: {apple=2,
 * banana=1, orange=1}.
 */
public class FrequencyCounter {

    /**
     * Counts the frequency of each element in the list.
     * 
     * @param list List of strings
     * @return Map containing frequency of each string
     */
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("apple");
        input.add("banana");
        input.add("apple");
        input.add("orange");

        System.out.println("Input: " + input);
        Map<String, Integer> result = countFrequency(input);
        System.out.println("Output: " + result);
    }
}
