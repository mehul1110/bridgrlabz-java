package searching;

import java.util.Scanner;

/**
 * Problem: Reverse a string using StringBuilder.
 */
public class StringBuilderReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);

        scanner.close();
    }

    /**
     * Reverses a string using StringBuilder's reverse method.
     * 
     * @param str The original string
     * @return The reversed string
     */
    public static String reverseString(String str) {
        if (str == null)
            return null;

        // Create a new StringBuilder object and append the string
        StringBuilder sb = new StringBuilder(str);

        // Use the reverse() method and convert back to string
        return sb.reverse().toString();
    }
}
