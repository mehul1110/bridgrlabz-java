import java.util.Scanner;

/*
 * Program to check if a string is a palindrome using built-in methods
 */
public class PalindromeCheckerBuiltIn {

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        // Loop to compare characters from both ends moving towards center
        while (i < j) {
            // Return false if mismatch found
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Check and display result
            System.out.println("Is palindrome? " + isPalindrome(s));
        }
    }
}
