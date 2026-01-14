import java.util.Scanner;

public class ToUpperCompare {
    public static String toUpperManual(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') sb.append((char)(c - ('a' - 'A')));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            String manual = toUpperManual(s);
            String built = s.toUpperCase();
            System.out.println("Manual upper: " + manual);
            System.out.println("Built-in upper: " + built);
            System.out.println("Equal? " + compare(manual, built));
        }
    }
}
