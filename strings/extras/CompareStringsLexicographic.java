import java.util.Scanner;

public class CompareStringsLexicographic {
    public static int compare(String a, String b) {
        int n = Math.min(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i);
        }
        return a.length() - b.length();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("String 1: "); String a = sc.nextLine();
            System.out.print("String 2: "); String b = sc.nextLine();
            int cmp = compare(a, b);
            if (cmp < 0) System.out.println('"' + a + '"' + " comes before " + '"' + b + '"');
            else if (cmp > 0) System.out.println('"' + a + '"' + " comes after " + '"' + b + '"');
            else System.out.println("Equal");
        }
    }
}
