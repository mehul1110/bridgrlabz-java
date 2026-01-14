import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDup(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean seen = false;
            for (int j = 0; j < sb.length(); j++) if (sb.charAt(j) == c) { seen = true; break; }
            if (!seen) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.println("Without duplicates: " + removeDup(s));
        }
    }
}
