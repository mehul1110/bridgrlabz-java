import java.util.Scanner;

public class TrimUsingCharAt {
    public static int[] trimIndices(String s) {
        int start = 0; while (start < s.length() && s.charAt(start) == ' ') start++;
        int end = s.length() - 1; while (end >= 0 && s.charAt(end) == ' ') end--;
        return new int[]{start, end + 1};
    }

    public static String substringByCharAt(String s, int start, int end) {
        if (start < 0 || end > s.length() || start > end) throw new IllegalArgumentException("Invalid indices");
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    public static boolean manualEquals(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text with spaces: ");
            String s = sc.nextLine();
            int[] idx = trimIndices(s);
            String manualTrim = substringByCharAt(s, idx[0], idx[1]);
            String builtinTrim = s.trim();
            System.out.println("Manual trimmed: '" + manualTrim + "'");
            System.out.println("Built-in trim : '" + builtinTrim + "'");
            System.out.println("Equal? " + manualEquals(manualTrim, builtinTrim));
        }
    }
}
