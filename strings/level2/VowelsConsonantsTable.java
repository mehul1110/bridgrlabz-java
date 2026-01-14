import java.util.Scanner;

public class VowelsConsonantsTable {
    public static String charType(char ch) {
        char c = Character.toLowerCase(ch);
        if (c >= 'a' && c <= 'z') {
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] analyze(String s) {
        String[][] out = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            out[i][0] = String.valueOf(s.charAt(i));
            out[i][1] = charType(s.charAt(i));
        }
        return out;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-6s %s%n", "Char", "Type");
        for (String[] r : table) System.out.printf("%-6s %s%n", r[0], r[1]);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String line = sc.nextLine();
            String[][] table = analyze(line);
            displayTable(table);
        }
    }
}
