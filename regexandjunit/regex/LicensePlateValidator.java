package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 2: Validate a License Plate Number
 * Format: Starts with two uppercase letters, followed by four digits.
 * Example: "AB1234" is valid.
 */
public class LicensePlateValidator {
    public static void main(String[] args) {
        String[] plates = { "AB1234", "A12345", "XY9999", "abc1234", "12ABCD" };

        // Regex Breakdown:
        // ^ : Start of string
        // [A-Z]{2}: Exactly two uppercase letters
        // \\d{4} : Exactly four digits
        // $ : End of string
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("License Plate Validation Results:");
        for (String plate : plates) {
            Matcher matcher = pattern.matcher(plate);
            System.out.println(plate + " \u2192 " + (matcher.matches() ? "Valid ✅" : "Invalid ❌"));
        }
    }
}
