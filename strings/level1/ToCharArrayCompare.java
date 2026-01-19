import java.util.Arrays;
import java.util.Scanner;

/*
 * Program to convert string to char array manually and compare with built-in method
 */
public class ToCharArrayCompare {

    public static char[] manualChars(String s) {
        char[] res = new char[s.length()];
        // Iterate through the string to copy each character to the array
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i);
        }
        return res;
    }

    public static boolean arraysEqual(char[] a, char[] b) {
        // Check if array lengths differ
        if (a.length != b.length) return false;
        
        // Iterate through arrays to compare elements at each index
        for (int i = 0; i < a.length; i++) {
            // Return false immediately if a mismatch is found
            if (a[i] != b[i]) {
                return false;
            }
        }
        // Return true if all elements match
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Convert to char array manually
            char[] man = manualChars(s);
            
            // Convert to char array using built-in method
            char[] built = s.toCharArray();
            
            // Display results and comparison
            System.out.println("Manual: " + Arrays.toString(man));
            System.out.println("Built-in: " + Arrays.toString(built));
            System.out.println("Equal? " + arraysEqual(man, built));
        }
    }
}
