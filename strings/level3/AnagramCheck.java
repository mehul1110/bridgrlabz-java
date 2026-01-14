import java.util.Scanner;

public class AnagramCheck {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] f = new int[256];
        for (int i = 0; i < a.length(); i++) f[(int)a.charAt(i)]++;
        for (int i = 0; i < b.length(); i++) f[(int)b.charAt(i)]--;
        for (int i = 0; i < 256; i++) if (f[i] != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first text: ");
            String a = sc.nextLine();
            System.out.print("Enter second text: ");
            String b = sc.nextLine();
            System.out.println("Anagram? " + isAnagram(a, b));
        }
    }
}
