import java.util.Scanner;

/*
 * Program to replace a specific word in a sentence with another word
 */
public class ReplaceWordInSentence {

    public static String replaceWord(String sentence, String target, String replacement) {
        // Split sentence into words based on spaces
        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        // Loop through words to rebuild the sentence with replacement
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(target)) {
                sb.append(replacement); 
            } else {
                sb.append(parts[i]);
            }
            
            // Append space if it's not the last word
            if (i < parts.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter sentence: "); 
            String s = sc.nextLine();
            System.out.print("Target word: "); 
            String t = sc.nextLine();
            System.out.print("Replacement word: "); 
            String r = sc.nextLine();
            
            // Display result
            System.out.println("Result: " + replaceWord(s, t, r));
        }
    }
}
