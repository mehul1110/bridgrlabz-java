import java.util.Scanner;

/*
 * Program to find the longest word in a sentence
 */
public class LongestWord {

    public static String longest(String s) {
        String[] parts = s.split(" ");
        String best = "";
        
        // Iterate through all words to find the max length
        for (String w : parts) {
            if (w.length() > best.length()) {
                best = w;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter sentence: ");
            String s = sc.nextLine();
            
            // Find and display longest word
            System.out.println("Longest: " + longest(s));
        }
    }
}
