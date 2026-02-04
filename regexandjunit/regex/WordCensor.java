package regexandjunit.regex;

import java.util.regex.Pattern;

/**
 * Problem 9: Censor Bad Words in a Sentence
 */
public class WordCensor {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = { "This", "damn", "stupid" };

        String censoredOutput = input;
        for (String word : badWords) {
            // Regex Breakdown:
            // (?i) : Case-insensitive flag
            // \\b : Word boundary to avoid partial matches (e.g., "damnation")
            String regex = "(?i)\\b" + word + "\\b";
            censoredOutput = censoredOutput.replaceAll(regex, "****");
        }

        System.out.println("Input:  " + input);
        System.out.println("Output: " + censoredOutput);
    }
}
