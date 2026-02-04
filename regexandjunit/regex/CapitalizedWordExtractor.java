package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 5: Extract All Capitalized Words from a Sentence
 */
public class CapitalizedWordExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Regex Breakdown:
        // \\b : Word boundary
        // [A-Z] : First letter capitalized
        // [a-z]* : Zero or more lowercase letters
        // \\b : Word boundary
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.print("Extracted Capitalized Words: ");
        boolean first = true;
        while (matcher.find()) {
            if (!first)
                System.out.print(", ");
            System.out.print(matcher.group());
            first = false;
        }
        System.out.println();
    }
}
