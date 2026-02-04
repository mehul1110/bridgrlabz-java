package regexandjunit.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Problem 10: Validate an IP Address
 * A valid IPv4 address consists of four groups of numbers (0-255) separated by
 * dots.
 */
public class IPAddressValidator {
    public static void main(String[] args) {
        String[] ipAddresses = { "192.168.1.1", "255.255.255.255", "256.0.0.1", "123.45.67", "0.0.0.0", "1.2.3.4.5" };

        // Regex Breakdown for 0-255:
        // 25[0-5] : 250-255
        // 2[0-4][0-9] : 200-249
        // [01]?[0-9][0-9]?: 0-199 (includes leading 0s or single digits)
        String octet = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        String regex = "^" + octet + "\\." + octet + "\\." + octet + "\\." + octet + "$";

        Pattern pattern = Pattern.compile(regex);

        System.out.println("IP Address Validation Results:");
        for (String ip : ipAddresses) {
            Matcher matcher = pattern.matcher(ip);
            System.out.println(ip + " \u2192 " + (matcher.matches() ? "Valid ✅" : "Invalid ❌"));
        }
    }
}
