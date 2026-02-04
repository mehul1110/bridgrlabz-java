package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 4: Extract All Email Addresses from a Text
 */
public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org. You can also reach me at john.doe@work-mail.net!";

        // Regex Breakdown:
        // [a-zA-Z0-9._%+-]+ : Username part
        // @ : Literal @
        // [a-zA-Z0-9.-]+ : Domain name
        // \\. : Literal dot
        // [a-zA-Z]{2,} : TLD (at least 2 letters)
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
