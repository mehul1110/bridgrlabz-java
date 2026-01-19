import java.util.Scanner;

/*
 * Program to count the number of vowels and consonants in a string
 */
public class CountVowelsConsonants {

    public static int[] count(String s) {
        int vowels = 0, consonants = 0;
        
        // Iterate through string to process each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Check if character is alphabetic
            if (Character.isLetter(c)) {
                char lc = Character.toLowerCase(c);
                // Check if the character is a vowel
                if (lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u') {
                    vowels++; 
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            int[] res = count(s);
            System.out.println("Vowels: " + res[0]);
            System.out.println("Consonants: " + res[1]);
        }
    }
}
