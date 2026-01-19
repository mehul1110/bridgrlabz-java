import java.util.Scanner;

/*
 * Program to toggle the case of characters in a string
 */
public class ToggleCase {

    public static String toggle(String s) {
        StringBuilder sb = new StringBuilder();
        
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Toggle case based on current case
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                // Keep non-alphabetic characters unchanged
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Display toggled string
            System.out.println("Toggled: " + toggle(s));
        }
    }
}
