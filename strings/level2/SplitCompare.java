import java.util.Arrays;
import java.util.Scanner;

/*
 * Program to manually split a string by space and compare with built-in split
 */
public class SplitCompare {

    public static String[] manualSplit(String s) {
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // Iterate over string characters to implement split logic manually
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Check for delimiter (space)
            if (c == ' ') {
                // If we have accumulated characters, add them as a word
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0); // Reset buffer
                }
            } else {
                // Accumulate non-space characters
                sb.append(c);
            }
        }
        // Add the last word if buffer is not empty
        if (sb.length() > 0) words.add(sb.toString());
        
        return words.toArray(new String[0]);
    }

    public static boolean compareArrays(String[] a, String[] b) {
        // Use Arrays.equals for deep comparison of array contents
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String line = sc.nextLine();
            
            // Perform manual split
            String[] manual = manualSplit(line);
            
            // Perform built-in split for comparison
            String[] built = line.split(" ");
            
            // Display and compare results
            System.out.println("Manual split: " + Arrays.toString(manual));
            System.out.println("Built-in split: " + Arrays.toString(built));
            System.out.println("Equal? " + compareArrays(manual, built));
        }
    }
}
