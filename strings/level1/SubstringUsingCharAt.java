import java.util.Scanner;

public class SubstringUsingCharAt {
    public static String substringByCharAt(String s, int start, int end) {
        if (start < 0 || end > s.length() || start > end) throw new IllegalArgumentException("Invalid indices");
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text (no spaces): ");
            String s = sc.next();
            System.out.print("Enter start index: "); int st = sc.nextInt();
            System.out.print("Enter end index: "); int en = sc.nextInt();
            String subManual = substringByCharAt(s, st, en);
            String subBuilt = s.substring(st, en);
            System.out.println("Manual substring: " + subManual);
            System.out.println("Built-in substring: " + subBuilt);
            System.out.println("Equal? " + subManual.equals(subBuilt));
        }
    }
}
