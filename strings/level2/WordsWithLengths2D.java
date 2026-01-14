import java.util.Scanner;

public class WordsWithLengths2D {
    public static String[] manualSplit(String s) {
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (sb.length() > 0) { words.add(sb.toString()); sb.setLength(0); }
            } else sb.append(c);
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static int manualLength(String s) {
        int c = 0; try { while (true) { s.charAt(c); c++; } } catch (IndexOutOfBoundsException e) {}
        return c;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] out = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            out[i][0] = words[i];
            out[i][1] = String.valueOf(manualLength(words[i]));
        }
        return out;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String line = sc.nextLine();
            String[] words = manualSplit(line);
            String[][] table = wordsWithLengths(words);
            System.out.printf("%-20s %s%n", "Word", "Length");
            for (String[] r : table) {
                System.out.printf("%-20s %d%n", r[0], Integer.parseInt(r[1]));
            }
        }
    }
}
