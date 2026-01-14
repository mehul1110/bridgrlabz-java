import java.util.Scanner;

public class RemoveSpecificCharacter {
    public static String removeChar(String s, char rem) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != rem) sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.print("Char to remove: ");
            char c = sc.nextLine().charAt(0);
            System.out.println("Modified String: " + removeChar(s, c));
        }
    }
}
