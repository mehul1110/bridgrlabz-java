import java.util.Scanner;

public class LongestWord {
    public static String longest(String s) {
        String[] parts = s.split(" ");
        String best = "";
        for (String w : parts) if (w.length() > best.length()) best = w;
        return best;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter sentence: ");
            String s = sc.nextLine();
            System.out.println("Longest: " + longest(s));
        }
    }
}
