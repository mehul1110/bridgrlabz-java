import java.util.Scanner;

/*
 * Program to compare two strings using charAt() method manually
 */
public class CompareStringsCharAt {

    public static boolean compareUsingCharAt(String a, String b) {
        // Check if lengths are different; if so, strings cannot be equal
        if (a.length() != b.length()) return false;
        
        // Iterate through each character of the strings to compare them one by one
        for (int i = 0; i < a.length(); i++) {
            // Check if characters at the current index match
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        // If all characters matched, return true
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner to read input
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first string (no spaces): ");
            String s1 = sc.next();
            System.out.print("Enter second string (no spaces): ");
            String s2 = sc.next();
            
            // Compare strings using the manual method
            boolean manual = compareUsingCharAt(s1, s2);
            
            // Compare strings using the built-in equals() method
            boolean builtin = s1.equals(s2);
            
            // Display the results of both comparisons
            System.out.println("Compare using charAt: " + manual);
            System.out.println("Compare using equals(): " + builtin);
        }
    }
}
