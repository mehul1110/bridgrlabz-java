import java.util.Scanner;

/*
 * Program to split a sentence and display each word with its length in a table
 */
public class WordsWithLengths2D {

    public static String[] manualSplit(String s) {
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // Loop through string to isolate words based on spaces
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                // Space detected, if buffer has content, save it as a word
                if (sb.length() > 0) { 
                    words.add(sb.toString()); 
                    sb.setLength(0); 
                }
            } else {
                // Append char to current word
                sb.append(c);
            }
        }
        // Save the final word if exists
        if (sb.length() > 0) words.add(sb.toString());
        
        return words.toArray(new String[0]);
    }

    public static int manualLength(String s) {
        int c = 0; 
        try { 
            // Loop until exception to count characters
            while (true) { s.charAt(c); c++; } 
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return c;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] out = new String[words.length][2];
        // Populate 2D array with words and their manually calculated lengths
        for (int i = 0; i < words.length; i++) {
            out[i][0] = words[i];
            out[i][1] = String.valueOf(manualLength(words[i]));
        }
        return out;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String line = sc.nextLine();
            
            // Process string
            String[] words = manualSplit(line);
            String[][] table = wordsWithLengths(words);
            
            // Display table
            System.out.printf("%-20s %s%n", "Word", "Length");
            for (String[] r : table) {
                System.out.printf("%-20s %d%n", r[0], Integer.parseInt(r[1]));
            }
        }
    }
}
