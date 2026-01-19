import java.util.Scanner;

/*
 * Program to count frequency of characters by first finding unique characters
 */
public class CharFrequencyUnique {

    public static char[] uniqueChars(String s) {
        int n = s.length();
        char[] temp = new char[n];
        int k = 0;
        
        // Iterate through string to identify unique characters
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean seen = false;
            
            // Check if current character has been seen before
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == ch) { 
                    seen = true; 
                    break; 
                }
            }
            
            // If not seen, add to temp array
            if (!seen) temp[k++] = ch;
        }
        
        // Copy unique characters to a correctly sized array
        char[] res = new char[k]; 
        for (int i = 0; i < k; i++) {
            res[i] = temp[i];
        }
        return res;
    }

    public static String[][] frequencyUsingUnique(String s) {
        int[] freq = new int[256];
        // Loop to calculate frequency of all characters first
        for (int i = 0; i < s.length(); i++) {
            freq[(int)s.charAt(i)]++;
        }
        
        // Get unique characters to structure the output
        char[] uniq = uniqueChars(s);
        String[][] out = new String[uniq.length][2];
        
        // Loop to map unique characters to their pre-calculated frequencies
        for (int i = 0; i < uniq.length; i++) {
            out[i][0] = String.valueOf(uniq[i]);
            out[i][1] = String.valueOf(freq[(int)uniq[i]]);
        }
        return out;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Calculate frequencies
            String[][] table = frequencyUsingUnique(s);
            
            // Display frequency table
            System.out.printf("%-6s %s%n", "Char", "Freq");
            for (String[] r : table) {
                System.out.printf("%-6s %s%n", r[0], r[1]);
            }
        }
    }
}
