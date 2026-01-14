import java.util.Scanner;

public class CharFrequency {
    public static String[][] frequency(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[(int)s.charAt(i)]++;
        java.util.List<String[]> list = new java.util.ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) list.add(new String[]{String.valueOf((char)i), String.valueOf(freq[i])});
        }
        return list.toArray(new String[0][]);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            String[][] table = frequency(s);
            System.out.printf("%-6s %s%n", "Char", "Freq");
            for (String[] r : table) System.out.printf("%-6s %s%n", r[0], r[1]);
        }
    }
}
