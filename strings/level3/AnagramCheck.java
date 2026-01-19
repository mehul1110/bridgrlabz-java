import java.util.Scanner;

/*
 * Program to check if two strings are anagrams of each other
 */
public class AnagramCheck {

    public static boolean isAnagram(String a, String b) {
        // If lengths differ, they cannot be anagrams
        if (a.length() != b.length()) return false;
        
        int[] f = new int[256];
        
        // Iterate through the first string to increment character counts
        for (int i = 0; i < a.length(); i++) {
            f[(int)a.charAt(i)]++;
        }
        
        // Iterate through the second string to decrement character counts
        for (int i = 0; i < b.length(); i++) {
            f[(int)b.charAt(i)]--;
        }
        
        // Check if all counts return to zero
        for (int i = 0; i < 256; i++) {
            // If any count is non-zero, strings are not anagrams
            if (f[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first text: ");
            String a = sc.nextLine();
            System.out.print("Enter second text: ");
            String b = sc.nextLine();
            
            // Perform anagram check and display result
            System.out.println("Anagram? " + isAnagram(a, b));
        }
    }
}
