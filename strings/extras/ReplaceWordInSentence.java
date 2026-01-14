import java.util.Scanner;

public class ReplaceWordInSentence {
    public static String replaceWord(String sentence, String target, String replacement) {
        // simple replace by scanning words
        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(target)) sb.append(replacement); else sb.append(parts[i]);
            if (i < parts.length-1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter sentence: "); String s = sc.nextLine();
            System.out.print("Target word: "); String t = sc.nextLine();
            System.out.print("Replacement word: "); String r = sc.nextLine();
            System.out.println("Result: " + replaceWord(s, t, r));
        }
    }
}
