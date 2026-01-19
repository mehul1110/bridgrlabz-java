import java.util.Scanner;

/*
 * Program to convert string to lowercase manually and compare with built-in method
 */
public class ToLowerCompare {

    public static String toLowerManual(String s) {
        StringBuilder sb = new StringBuilder();
        // Iterate through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Check if character is uppercase and convert it to lowercase
            if (c >= 'A' && c <= 'Z') {
                // Add the ASCII difference to convert to lowercase
                sb.append((char)(c + ('a' - 'A')));
            } else {
                // Append non-uppercase characters as is
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean compare(String a, String b) {
        // Compare lengths first
        if (a.length() != b.length()) return false;
        
        // Iterate to compare characters at each position
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
            
            // Convert using manual logic
            String manual = toLowerManual(s);
            
            // Convert using built-in method
            String built = s.toLowerCase();
            
            // Display results
            System.out.println("Manual lower: " + manual);
            System.out.println("Built-in lower: " + built);
            System.out.println("Equal? " + compare(manual, built));
        }
    }
}
