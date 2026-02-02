package iostreams;

import java.io.*;

/**
 * Problem 6: Filter Streams - Convert Uppercase to Lowercase
 * 
 * Creates a program that reads a text file and writes its contents into another
 * file,
 * converting all uppercase letters to lowercase.
 * 
 * Requirements:
 * - Use FileReader and FileWriter.
 * - Use BufferedReader and BufferedWriter for efficiency.
 * - Handle character encoding issues (Note: FileReader/Writer use platform
 * default encoding usually,
 * but OutputStreamWriter/InputStreamReader allows specifying it. We will use
 * FileReader/FileWriter as requested
 * but are aware of encoding limitations).
 */
public class CaseConverter {

    private static final String INPUT_FILE = "mixed_case_input.txt";
    private static final String OUTPUT_FILE = "lowercase_output.txt";

    public static void main(String[] args) {
        createDummyFile();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
                BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            String line;
            System.out.println("Reading from " + INPUT_FILE + " and converting to lowercase...");

            while ((line = br.readLine()) != null) {
                // Convert line to lowercase
                String lowerLine = line.toLowerCase();
                bw.write(lowerLine);
                bw.newLine(); // Maintain line structure
            }

            System.out.println("Conversion complete. Output saved to " + OUTPUT_FILE);

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createDummyFile() {
        File file = new File(INPUT_FILE);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("HELLO World!\n");
                fw.write("Java I/O STREAMS are POWERFUL.\n");
                fw.write("This IS a Test FILE.\n");
                System.out.println("Created input file: " + INPUT_FILE);
            } catch (IOException e) {
                System.err.println("Error creating dummy file: " + e.getMessage());
            }
        }
    }
}
