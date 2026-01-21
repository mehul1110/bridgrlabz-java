package searching;

/**
 * Problem: Concatenate an array of strings efficiently using StringBuffer.
 */
public class StringBufferConcatenate {
    public static void main(String[] args) {
        String[] words = { "Efficient", " ", "String", " ", "Concatenation", " ", "using", " ", "StringBuffer" };

        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }

    /**
     * Efficiently concatenates strings using StringBuffer.
     * 
     * @param arr Array of strings
     * @return Concatenated string
     */
    public static String concatenateStrings(String[] arr) {
        if (arr == null || arr.length == 0)
            return "";

        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Iterate through each string and append
        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
