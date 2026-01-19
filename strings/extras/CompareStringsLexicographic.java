import java.util.Scanner;

/*
 * Program to compare two strings lexicographically without using built-in compareTo
 */
public class CompareStringsLexicographic {

    public static int compare(String a, String b) {
        int n = Math.min(a.length(), b.length());
        
        // Loop to compare character by character up to the length of the shorter string
        for (int i = 0; i < n; i++) {
            // Return difference immediately if mismatch found
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) - b.charAt(i);
            }
        }
        
        // If one string is a substring of the other, return difference in lengths
        return a.length() - b.length();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("String 1: ");
            String a = sc.nextLine();
            System.out.print("String 2: ");
            String b = sc.nextLine();
            
            int cmp = compare(a, b);
            
            // Display result based on comparison value
            if (cmp < 0) {
                System.out.println('"' + a + '"' + " comes before " + '"' + b + '"');
            } else if (cmp > 0) {
                System.out.println('"' + a + '"' + " comes after " + '"' + b + '"');
            } else {
                System.out.println("Equal");
            }
        }
    }
}
