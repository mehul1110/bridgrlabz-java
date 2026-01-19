import java.util.Scanner;

/*
 * Program to trim leading and trailing spaces manually and compare with built-in trim
 */
public class TrimUsingCharAt {

    public static int[] trimIndices(String s) {
        int start = 0;
        // Loop to find the first non-space character index
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        
        int end = s.length() - 1;
        // Loop backwards to find the last non-space character index
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        
        // Return start index and end index (adjusted for substring method which is exclusive)
        return new int[]{start, end + 1};
    }

    public static String substringByCharAt(String s, int start, int end) {
        // Validate indices
        if (start < 0 || end > s.length() || start > end) throw new IllegalArgumentException("Invalid indices");
        
        StringBuilder sb = new StringBuilder();
        // Loop to construct substring from start to end index
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static boolean manualEquals(String a, String b) {
        // Compare string lengths
        if (a.length() != b.length()) return false;
        
        // Loop to compare characters at each position
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text with spaces: ");
            String s = sc.nextLine();
            
            // Determine indices for trimming
            int[] idx = trimIndices(s);
            
            // Apply manual trim
            String manualTrim = substringByCharAt(s, idx[0], idx[1]);
            
            // Apply built-in trim
            String builtinTrim = s.trim();
            
            // Display results
            System.out.println("Manual trimmed: '" + manualTrim + "'");
            System.out.println("Built-in trim : '" + builtinTrim + "'");
            System.out.println("Equal? " + manualEquals(manualTrim, builtinTrim));
        }
    }
}
