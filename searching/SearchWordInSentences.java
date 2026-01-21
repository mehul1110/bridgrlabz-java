package searching;

/**
 * Problem: Linear Search to find the first sentence containing a specific word.
 */
public class SearchWordInSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is a programming language.",
                "Linear search is simple.",
                "Searching for a word in sentences.",
                "StringBuilder is mutable."
        };
        String targetWord = "search";

        String result = searchWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }

    /**
     * Searches for a word in an array of sentences.
     * 
     * @param sentences Array of strings
     * @param target    Word to find
     * @return The first sentence containing the word, or "Not Found"
     */
    public static String searchWord(String[] sentences, String target) {
        if (sentences == null || target == null)
            return "Not Found";

        for (String sentence : sentences) {
            // Check if sentence contains the word (case insensitive check)
            if (sentence.toLowerCase().contains(target.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
