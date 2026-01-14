import java.util.Scanner;

public class VowelsConsonantsCount {
    public static String charType(char ch) {
        char c = Character.toLowerCase(ch);
        if (c >= 'a' && c <= 'z') {
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVC(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            String t = charType(s.charAt(i));
            if (t.equals("Vowel")) v++; else if (t.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String line = sc.nextLine();
            int[] res = countVC(line);
            System.out.println("Vowels: " + res[0]);
            System.out.println("Consonants: " + res[1]);
        }
    }
}
