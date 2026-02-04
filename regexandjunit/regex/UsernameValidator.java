package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 1: Validate a Username
 * A valid username:
 * - Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
 * - Must start with a letter
 * - Must be between 5 to 15 characters long
 */
public class UsernameValidator {
    public static void main(String[] args) {
        String[] usernames = { "user_123", "123user", "us", "validUsername_1", "tooLongUsername123" };

        // Regex Breakdown:
        // ^ : Start of string
        // [a-zA-Z] : Starts with a letter
        // [a-zA-Z0-9_]{4,14} : 4 to 14 characters (since first letter is already 1,
        // total 5-15)
        // $ : End of string
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Username Validation Results:");
        for (String username : usernames) {
            Matcher matcher = pattern.matcher(username);
            System.out.println(username + " \u2192 " + (matcher.matches() ? "Valid ✅" : "Invalid ❌"));
        }
    }
}
