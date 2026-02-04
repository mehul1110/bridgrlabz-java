package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 11: Validate a Credit Card Number
 * - Visa: starts with 4, has 16 digits.
 * - MasterCard: starts with 5, has 16 digits.
 */
public class CreditCardValidator {
    public static void main(String[] args) {
        String[] cards = { "4123456789012345", "5123456789012345", "6123456789012345", "4123456789" };

        // Visa Regex: ^4\\d{15}$
        // MasterCard Regex: ^5\\d{15}$
        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5\\d{15}$";

        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterPattern = Pattern.compile(masterCardRegex);

        System.out.println("Credit Card Validation Results:");
        for (String card : cards) {
            if (visaPattern.matcher(card).matches()) {
                System.out.println(card + " \u2192 Valid Visa ✅");
            } else if (masterPattern.matcher(card).matches()) {
                System.out.println(card + " \u2192 Valid MasterCard ✅");
            } else {
                System.out.println(card + " \u2192 Invalid ❌");
            }
        }
    }
}
