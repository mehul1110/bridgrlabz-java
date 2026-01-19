import java.util.Scanner;

/*
 * Program to find the first non-repeating character in a string
 */
public class FirstNonRepeating {

    public static char firstNonRepeating(String s) {
        int[] freq = new int[256];
        
        // Loop to calculate frequencies of all characters
        for (int i = 0; i < s.length(); i++) {
            freq[(int)s.charAt(i)]++;
        }
        
        // Loop through the string again to find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[(int)s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        
        // Return null character if no unique character is found
        return '\0';
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            char c = firstNonRepeating(s);
            
            if (c == '\0') {
                System.out.println("No non-repeating character found");
            } else {
                System.out.println("First non-repeating: " + c);
            }
        }
    }
}
