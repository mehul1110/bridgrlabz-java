import java.util.Scanner;

/*
 * Program to find and display unique characters in a string
 */
public class UniqueCharacters {

    public static int manualLength(String s) {
        int c = 0; 
        try { 
            // Loop until exception to deduce length
            while (true) { 
                s.charAt(c); 
                c++; 
            } 
        } catch (IndexOutOfBoundsException e) {} 
        return c;
    }

    public static char[] uniqueChars(String s) {
        int n = manualLength(s);
        char[] temp = new char[n];
        int k = 0;
        
        // Loop through string characters to filter unique ones
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean seen = false;
            
            // Nested loop to check if the current character 'ch' has appeared before
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == ch) { 
                    seen = true; 
                    break; 
                }
            }
            
            // If unique, add it to our temp array
            if (!seen) temp[k++] = ch;
        }
        
        // Create an array of correct size and copy elements
        char[] res = new char[k];
        for (int i = 0; i < k; i++) {
            res[i] = temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Get unique characters
            char[] u = uniqueChars(s);
            System.out.println("Unique characters: " + java.util.Arrays.toString(u));
        }
    }
}
