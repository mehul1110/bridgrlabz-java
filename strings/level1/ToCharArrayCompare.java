import java.util.Arrays;
import java.util.Scanner;

public class ToCharArrayCompare {
    public static char[] manualChars(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) res[i] = s.charAt(i);
        return res;
    }

    public static boolean arraysEqual(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            char[] man = manualChars(s);
            char[] built = s.toCharArray();
            System.out.println("Manual: " + Arrays.toString(man));
            System.out.println("Built-in: " + Arrays.toString(built));
            System.out.println("Equal? " + arraysEqual(man, built));
        }
    }
}
