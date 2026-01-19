import java.util.Scanner;

/*
 * Program to count vowels and consonants in a string
 */
public class VowelsConsonantsCount {

    public static String charType(char ch) {
        char c = Character.toLowerCase(ch);
        // Check if character is a letter
        if (c >= 'a' && c <= 'z') {
            // Check if character is a vowel
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVC(String s) {
        int v = 0, c = 0;
        // Iterate through string to classify each character
        for (int i = 0; i < s.length(); i++) {
            String t = charType(s.charAt(i));
            // Update counts based on type
            if (t.equals("Vowel")) v++; 
            else if (t.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String line = sc.nextLine();
            
            // Get counts
            int[] res = countVC(line);
            
            // Display counts
            System.out.println("Vowels: " + res[0]);
            System.out.println("Consonants: " + res[1]);
        }
    }
}
