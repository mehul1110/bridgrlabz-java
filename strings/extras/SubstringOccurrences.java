import java.util.Scanner;

public class SubstringOccurrences {
    public static int countOccurrences(String s, String sub) {
        int count = 0;
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            boolean match = true;
            for (int j = 0; j < sub.length(); j++) if (s.charAt(i+j) != sub.charAt(j)) { match = false; break; }
            if (match) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.print("Enter substring: ");
            String sub = sc.nextLine();
            System.out.println("Occurrences: " + countOccurrences(s, sub));
        }
    }
}
