package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 14: Find Repeating Words in a Sentence
 */
public class RepeatingWordFinder {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";

        // Regex Breakdown:
        // \\b : Word boundary
        // (\\w+) : Capture group 1: one or more word characters
        // \\s+ : One or more whitespace characters
        // \\1 : Backreference to the first capture group (the same word)
        // \\b : Word boundary
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        System.out.print("Repeating words found: ");
        boolean first = true;
        while (matcher.find()) {
            if (!first)
                System.out.print(", ");
            // group(1) gives the word itself, group() gives the pair
            System.out.print(matcher.group(1));
            first = false;
        }
        System.out.println();
    }
}
