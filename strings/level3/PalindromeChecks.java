import java.util.Scanner;

/*
 * Program to check if a string is a palindrome using multiple methods: Iteration, Recursion, and Reversal
 */
public class PalindromeChecks {

    public static boolean isPalindromeIter(String s) {
        int i = 0, j = s.length() - 1;
        // Loop pointers towards center to check for palindrome property
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; 
            j--;
        }
        return true;
    }

    public static boolean isPalindromeRec(String s, int i, int j) {
        // Base case: if pointers meet or cross, it's a palindrome
        if (i >= j) return true;
        // If mismatch found, return false
        if (s.charAt(i) != s.charAt(j)) return false;
        // Recursive call with inner substring
        return isPalindromeRec(s, i+1, j-1);
    }

    public static boolean isPalindromeByReverse(String s) {
        char[] rev = new char[s.length()];
        // Loop to construct reversed character array
        for (int i = 0; i < s.length(); i++) {
            rev[i] = s.charAt(s.length() - 1 - i);
        }
        // Check equality between original and reversed array content
        return java.util.Arrays.equals(s.toCharArray(), rev);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Perform palindrome checks
            System.out.println("Iterative: " + isPalindromeIter(s));
            System.out.println("Recursive: " + isPalindromeRec(s, 0, s.length()-1));
            System.out.println("By reverse: " + isPalindromeByReverse(s));
        }
    }
}
