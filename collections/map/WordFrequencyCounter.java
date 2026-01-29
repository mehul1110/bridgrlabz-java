package collections.map;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Word Frequency Counter
 * Read a text file (simulated with string) and count the frequency of each word
 * using a HashMap.
 * Ignore case and punctuation.
 * Example: Input: "Hello world, hello Java!" -> Output: {hello=2, world=1,
 * java=1}
 */
public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        if (text == null || text.isEmpty())
            return frequencyMap;

        // Normalize text: lowercase and remove punctuation
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println("Input: " + input);
        System.out.println("Word Frequencies: " + countWordFrequency(input));
    }
}
