package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 15: Validate a Social Security Number (SSN)
 * Format: 123-45-6789
 */
public class SSNValidator {
    public static void main(String[] args) {
        String[] ssns = { "123-45-6789", "123456789", "123-4-6789", "abc-de-fghj" };

        // Regex Breakdown:
        // ^ : Start of string
        // \\d{3}: 3 digits
        // - : Dash
        // \\d{2}: 2 digits
        // - : Dash
        // \\d{4}: 4 digits
        // $ : End of string
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("SSN Validation Results:");
        for (String ssn : ssns) {
            Matcher matcher = pattern.matcher(ssn);
            System.out.println(ssn + " \u2192 " + (matcher.matches() ? "Valid ✅" : "Invalid ❌"));
        }
    }
}
