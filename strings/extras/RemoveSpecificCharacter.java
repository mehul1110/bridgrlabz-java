import java.util.Scanner;

/*
 * Program to remove all occurrences of a specific character from a string
 */
public class RemoveSpecificCharacter {

    public static String removeChar(String s, char rem) {
        StringBuilder sb = new StringBuilder();
        // Loop through string to filter out the target character
        for (int i = 0; i < s.length(); i++) {
            // Append character only if it doesn't match the one to remove
            if (s.charAt(i) != rem) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.print("Char to remove: ");
            char c = sc.nextLine().charAt(0);
            
            // Display modified string
            System.out.println("Modified String: " + removeChar(s, c));
        }
    }
}
