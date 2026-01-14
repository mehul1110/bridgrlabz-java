import java.util.Scanner;

public class UniqueCharacters {
    public static int manualLength(String s) {
        int c = 0; try { while (true) { s.charAt(c); c++; } } catch (IndexOutOfBoundsException e) {} return c;
    }

    public static char[] uniqueChars(String s) {
        int n = manualLength(s);
        char[] temp = new char[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) if (s.charAt(j) == ch) { seen = true; break; }
            if (!seen) temp[k++] = ch;
        }
        char[] res = new char[k];
        for (int i = 0; i < k; i++) res[i] = temp[i];
        return res;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            char[] u = uniqueChars(s);
            System.out.println("Unique characters: " + java.util.Arrays.toString(u));
        }
    }
}
