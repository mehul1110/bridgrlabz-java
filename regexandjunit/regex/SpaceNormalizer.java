package regexandjunit.regex;

/**
 * Problem 8: Replace Multiple Spaces with a Single Space
 */
public class SpaceNormalizer {
    public static void main(String[] args) {
        String input = "This   is  an   example  with multiple    spaces.";

        // Regex Breakdown:
        // \\s+ : Match one or more whitespace characters
        String regex = "\\s+";
        String output = input.replaceAll(regex, " ");

        System.out.println("Input:  \"" + input + "\"");
        System.out.println("Output: \"" + output + "\"");
    }
}
