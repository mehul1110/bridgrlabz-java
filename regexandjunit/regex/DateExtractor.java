package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 6: Extract Dates in dd/mm/yyyy Format
 */
public class DateExtractor {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Regex Breakdown:
        // \\b : Word boundary
        // \\d{2} : Day (2 digits)
        // / : Slash
        // \\d{2} : Month (2 digits)
        // / : Slash
        // \\d{4} : Year (4 digits)
        // \\b : Word boundary
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.print("Extracted Dates: ");
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
