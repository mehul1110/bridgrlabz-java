import java.util.Scanner;

/*
 * Program to check if two strings are anagrams of each other
 */
public class AnagramCheckExtra {

    public static boolean isAnagram(String a, String b) {
        // Strings of different lengths cannot be anagrams
        if (a.length() != b.length()) return false;
        
        int[] f = new int[256];
        // Count frequency of chars in first string
        for (int i = 0; i < a.length(); i++) {
            f[(int)a.charAt(i)]++;
        }
        
        // Decrement frequency for chars in second string
        for (int i = 0; i < b.length(); i++) {
            f[(int)b.charAt(i)]--;
        }
        
        // Check if all frequencies are zero, indicating match
        for (int i = 0; i < 256; i++) {
            if (f[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first string: ");
            String a = sc.nextLine();
            System.out.print("Enter second string: ");
            String b = sc.nextLine();
            
            // Perform anagram check
            System.out.println("Anagram? " + isAnagram(a, b));
        }
    }
}
