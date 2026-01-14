import java.util.Scanner;

public class CharFrequencyUnique {
    public static char[] uniqueChars(String s) {
        int n = s.length();
        char[] temp = new char[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) if (s.charAt(j) == ch) { seen = true; break; }
            if (!seen) temp[k++] = ch;
        }
        char[] res = new char[k]; for (int i = 0; i < k; i++) res[i] = temp[i];
        return res;
    }

    public static String[][] frequencyUsingUnique(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[(int)s.charAt(i)]++;
        char[] uniq = uniqueChars(s);
        String[][] out = new String[uniq.length][2];
        for (int i = 0; i < uniq.length; i++) { out[i][0] = String.valueOf(uniq[i]); out[i][1] = String.valueOf(freq[(int)uniq[i]]); }
        return out;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            String[][] table = frequencyUsingUnique(s);
            System.out.printf("%-6s %s%n", "Char", "Freq");
            for (String[] r : table) System.out.printf("%-6s %s%n", r[0], r[1]);
        }
    }
}
