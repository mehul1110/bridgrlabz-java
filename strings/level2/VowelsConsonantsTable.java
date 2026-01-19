import java.util.Scanner;

/*
 * Program to display a table of characters and their types (Vowel/Consonant)
 */
public class VowelsConsonantsTable {

    public static String charType(char ch) {
        char c = Character.toLowerCase(ch);
        // Check if character is a letter
        if (c >= 'a' && c <= 'z') {
            // Determine if it is a vowel or consonant
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] analyze(String s) {
        String[][] out = new String[s.length()][2];
        // Loop through each character to populate analysis table
        for (int i = 0; i < s.length(); i++) {
            out[i][0] = String.valueOf(s.charAt(i));  // Character
            out[i][1] = charType(s.charAt(i));        // Type
        }
        return out;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-6s %s%n", "Char", "Type");
        // Iterate through table rows to display data
        for (String[] r : table) {
            System.out.printf("%-6s %s%n", r[0], r[1]);
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String line = sc.nextLine();
            
            // Analyze string and display table
            String[][] table = analyze(line);
            displayTable(table);
        }
    }
}
