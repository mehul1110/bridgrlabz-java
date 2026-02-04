package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 13: Extract Currency Values from a Text
 */
public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50. Another item costs $100.00.";

        // Regex Breakdown:
        // \\$? : Optional literal dollar sign
        // \\d+ : One or more digits
        // \\. : Literal dot
        // \\d{2} : Exactly two digits for cents
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.print("Extracted Currencies: ");
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
