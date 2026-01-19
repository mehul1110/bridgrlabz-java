import java.util.Scanner;

/*
 * Program to remove duplicate characters from a string
 */
public class RemoveDuplicates {

    public static String removeDup(String s) {
        StringBuilder sb = new StringBuilder();
        
        // Iterate through the input string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean seen = false;
            
            // Check if the character already exists in the result builder
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == c) { 
                    seen = true; 
                    break; 
                }
            }
            
            // Append only if not already seen
            if (!seen) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Display result
            System.out.println("Without duplicates: " + removeDup(s));
        }
    }
}
