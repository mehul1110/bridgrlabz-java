import java.util.Scanner;

public class ShortestLongest {
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

    public static int manualLength(String s) { int c = 0; try { while (true) { s.charAt(c); c++; } } catch (IndexOutOfBoundsException e) {} return c; }

    public static int[] shortestAndLongestIndexes(String[][] wordsAndLengths) {
        if (wordsAndLengths.length == 0) return new int[]{-1, -1};
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < wordsAndLengths.length; i++) {
            int len = Integer.parseInt(wordsAndLengths[i][1]);
            if (len < Integer.parseInt(wordsAndLengths[minIdx][1])) minIdx = i;
            if (len > Integer.parseInt(wordsAndLengths[maxIdx][1])) maxIdx = i;
        }
        return new int[]{minIdx, maxIdx};
    }

    public static String[][] to2D(String[] words) {
        String[][] out = new String[words.length][2];
        for (int i = 0; i < words.length; i++) { out[i][0] = words[i]; out[i][1] = String.valueOf(manualLength(words[i])); }
        return out;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String line = sc.nextLine();
            String[] words = manualSplit(line);
            String[][] table = to2D(words);
            int[] idx = shortestAndLongestIndexes(table);
            if (idx[0] >= 0) {
                System.out.println("Shortest: " + table[idx[0]][0] + " (" + table[idx[0]][1] + ")");
                System.out.println("Longest : " + table[idx[1]][0] + " (" + table[idx[1]][1] + ")");
            } else System.out.println("No words provided.");
        }
    }
}
