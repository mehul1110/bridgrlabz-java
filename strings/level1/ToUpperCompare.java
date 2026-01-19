import java.util.Scanner;

/*
 * Program to convert string to uppercase manually and compare with built-in method
 */
public class ToUpperCompare {

    public static String toUpperManual(String s) {
        StringBuilder sb = new StringBuilder();
        // Iterate through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Check if character is lowercase and convert it to uppercase
            if (c >= 'a' && c <= 'z') {
                // Subtract the ASCII difference to convert to uppercase
                sb.append((char)(c - ('a' - 'A')));
            } else {
                // Append non-lowercase characters as is
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean compare(String a, String b) {
        // Compare lengths match
        if (a.length() != b.length()) return false;
        
        // Iterate through string to compare individual characters
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Convert using manual method
            String manual = toUpperManual(s);
            
            // Convert using built-in method
            String built = s.toUpperCase();
            
            // Display results
            System.out.println("Manual upper: " + manual);
            System.out.println("Built-in upper: " + built);
            System.out.println("Equal? " + compare(manual, built));
        }
    }
}
