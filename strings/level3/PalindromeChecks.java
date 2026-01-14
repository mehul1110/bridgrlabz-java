import java.util.Scanner;

public class PalindromeChecks {
    public static boolean isPalindromeIter(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static boolean isPalindromeRec(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalindromeRec(s, i+1, j-1);
    }

    public static boolean isPalindromeByReverse(String s) {
        char[] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) rev[i] = s.charAt(s.length()-1-i);
        return java.util.Arrays.equals(s.toCharArray(), rev);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.println("Iterative: " + isPalindromeIter(s));
            System.out.println("Recursive: " + isPalindromeRec(s, 0, s.length()-1));
            System.out.println("By reverse: " + isPalindromeByReverse(s));
        }
    }
}
