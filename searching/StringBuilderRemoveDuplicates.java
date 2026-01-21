package searching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem: Remove all duplicate characters from a string while maintaining
 * order.
 */
public class StringBuilderRemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);

        scanner.close();
    }

    /**
     * Removes duplicate characters using StringBuilder and HashSet.
     * 
     * @param str The original string
     * @return String with unique characters
     */
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty())
            return str;

        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // If the character is not in the HashSet, append it and add to HashSet
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }

        return sb.toString();
    }
}
