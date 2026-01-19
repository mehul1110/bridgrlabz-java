import java.util.Scanner;

/*
 * Program to count occurrences of a substring within a larger string
 */
public class SubstringOccurrences {

    public static int countOccurrences(String s, String sub) {
        int count = 0;
        // Iterate through valid start positions for the substring match
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            boolean match = true;
            // Inner loop to check character by character match
            for (int j = 0; j < sub.length(); j++) {
                if (s.charAt(i+j) != sub.charAt(j)) { 
                    match = false; 
                    break; 
                }
            }
            // Increment count if match found
            if (match) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.print("Enter substring: ");
            String sub = sc.nextLine();
            
            // Display occurrence count
            System.out.println("Occurrences: " + countOccurrences(s, sub));
        }
    }
}
