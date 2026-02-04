package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 3: Validate a Hex Color Code
 * A valid hex color:
 * - Starts with a #
 * - Followed by 6 hexadecimal characters (0-9, A-F, a-f).
 */
public class HexColorValidator {
    public static void main(String[] args) {
        String[] hexCodes = { "#FFA500", "#ff4500", "#123", "#G0G0G0", "#ABCDEF12" };

        // Regex Breakdown:
        // ^ : Start of string
        // # : Literal hash character
        // [a-fA-F0-9]{6}: Exactly 6 hex digits
        // $ : End of string
        String regex = "^#[a-fA-F0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Hex Color Validation Results:");
        for (String hex : hexCodes) {
            Matcher matcher = pattern.matcher(hex);
            System.out.println(hex + " \u2192 " + (matcher.matches() ? "Valid ✅" : "Invalid ❌"));
        }
    }
}
