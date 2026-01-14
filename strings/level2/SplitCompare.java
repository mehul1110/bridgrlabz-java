import java.util.Arrays;
import java.util.Scanner;

public class SplitCompare {
    public static String[] manualSplit(String s) {
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static boolean compareArrays(String[] a, String[] b) {
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String line = sc.nextLine();
            String[] manual = manualSplit(line);
            String[] built = line.split(" ");
            System.out.println("Manual split: " + Arrays.toString(manual));
            System.out.println("Built-in split: " + Arrays.toString(built));
            System.out.println("Equal? " + compareArrays(manual, built));
        }
    }
}
