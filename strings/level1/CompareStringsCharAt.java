import java.util.Scanner;

public class CompareStringsCharAt {
    public static boolean compareUsingCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first string (no spaces): ");
            String s1 = sc.next();
            System.out.print("Enter second string (no spaces): ");
            String s2 = sc.next();
            boolean manual = compareUsingCharAt(s1, s2);
            boolean builtin = s1.equals(s2);
            System.out.println("Compare using charAt: " + manual);
            System.out.println("Compare using equals(): " + builtin);
        }
    }
}
