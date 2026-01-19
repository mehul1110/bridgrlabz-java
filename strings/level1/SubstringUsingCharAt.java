import java.util.Scanner;

/*
 * Program to demonstrate substring creation using charAt() manually
 */
public class SubstringUsingCharAt {

    public static String substringByCharAt(String s, int start, int end) {
        // Validate indices to ensure they are within the string bounds and logically correct
        if (start < 0 || end > s.length() || start > end) {
            throw new IllegalArgumentException("Invalid indices");
        }
        
        StringBuilder sb = new StringBuilder();
        // Loop from start index up to (but not including) end index to build the substring
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize Scanner for user input
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text (no spaces): ");
            String s = sc.next();
            System.out.print("Enter start index: ");
            int st = sc.nextInt();
            System.out.print("Enter end index: ");
            int en = sc.nextInt();
            
            // Generate substring using the manual method
            String subManual = substringByCharAt(s, st, en);
            
            // Generate substring using the built-in method
            String subBuilt = s.substring(st, en);
            
            // Display and compare results
            System.out.println("Manual substring: " + subManual);
            System.out.println("Built-in substring: " + subBuilt);
            System.out.println("Equal? " + subManual.equals(subBuilt));
        }
    }
}
