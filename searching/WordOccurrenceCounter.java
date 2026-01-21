package searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem: Count the occurrence of a target word in a file using FileReader.
 */
public class WordOccurrenceCounter {
    public static void main(String[] args) {
        String fileName = "sample_text.txt"; // Reusing the file from previous example
        String targetWord = "FileReader";

        int count = countWordInFile(fileName, targetWord);
        System.out.println("The word \"" + targetWord + "\" appeared " + count + " times in " + fileName);
    }

    /**
     * Counts occurrences of a word in a file.
     * 
     * @param filePath Path to the file
     * @param target   The word to look for
     * @return Number of occurrences
     */
    public static int countWordInFile(String filePath, String target) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by whitespace and punctuation to extract words
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return count;
    }
}
