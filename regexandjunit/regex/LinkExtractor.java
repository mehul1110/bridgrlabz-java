package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 7: Extract Links from a Web Page
 */
public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Regex Breakdown:
        // https? : http with optional s
        // :// : Literal ://
        // [^\\s]+ : One or more non-whitespace characters
        String regex = "https?://[^\\s,.]+"; // Excluding trailing punctuation
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.print("Extracted Links: ");
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
