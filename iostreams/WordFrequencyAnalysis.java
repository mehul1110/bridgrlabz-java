package iostreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * Problem 10: Count Words in a File
 * 
 * Writes a Java program that counts the number of words in a given text file
 * and displays the top 5 most frequently occurring words.
 * 
 * Requirements:
 * - Use FileReader and BufferedReader to read the file.
 * - Use a HashMap<String, Integer> to count word occurrences.
 * - Sort the words based on frequency and display the top 5.
 */
public class WordFrequencyAnalysis {

    private static final String TEXT_FILE = "story.txt";

    public static void main(String[] args) {
        createDummyTextFile();

        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by non-word characters (punctuation, whitespace)
                // regex: \\W+ matches any non-word character sequence
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.isEmpty())
                        continue;

                    String normalizedWord = word.toLowerCase();
                    wordCounts.put(normalizedWord, wordCounts.getOrDefault(normalizedWord, 0) + 1);
                }
            }

            // Processing top 5
            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());
            // Sort by value descending
            list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            System.out.println("Top 5 Most Frequent Words:");
            System.out.println("--------------------------");
            int count = 0;
            for (Map.Entry<String, Integer> entry : list) {
                if (count >= 5)
                    break;
                System.out.println((count + 1) + ". " + entry.getKey() + ": " + entry.getValue());
                count++;
            }

            System.out.println("\nTotal unique words: " + wordCounts.size());

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static void createDummyTextFile() {
        File file = new File(TEXT_FILE);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                String text = "Java is a powerful language. Java streams are useful. " +
                        "I love Java. Streams allow efficient data processing. " +
                        "Data processing is key. Java Java Java. Useful useful.";
                fw.write(text);
                System.out.println("Created dummy text file: " + TEXT_FILE);
            } catch (IOException e) {
                System.err.println("Error creating dummy file: " + e.getMessage());
            }
        }
    }
}
