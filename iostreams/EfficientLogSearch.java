package iostreams;

import java.io.*;

/**
 * Problem 9: Read a Large File Line by Line
 * 
 * Develops a Java program that efficiently reads a large text file (500MB+)
 * line by line
 * and prints only lines containing the word "error".
 * 
 * Requirements:
 * - Use BufferedReader for efficient reading.
 * - Read line-by-line instead of loading the entire file.
 * - Display only lines containing "error" (case insensitive).
 */
public class EfficientLogSearch {

    private static final String LOG_FILE = "server_logs.txt";

    public static void main(String[] args) {
        // Generate a reasonably sized log file for testing
        createDummyLogFile();

        System.out.println("Scanning " + LOG_FILE + " for errors...");

        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            int lineNumber = 0;
            int errorCount = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                // Check for "error" case-insensitive
                if (line.toLowerCase().contains("error")) {
                    System.out.println("[Line " + lineNumber + "] " + line);
                    errorCount++;
                }
            }

            System.out.println("Scan complete. Found " + errorCount + " error lines.");

        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }

    private static void createDummyLogFile() {
        File file = new File(LOG_FILE);
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                // Write some dummy lines
                for (int i = 0; i < 1000; i++) {
                    if (i % 100 == 0) {
                        bw.write("TIMESTAMP [ERROR] Something went wrong at index " + i);
                    } else if (i % 50 == 0) {
                        bw.write("TIMESTAMP [WARN] Warning at index " + i);
                    } else {
                        bw.write("TIMESTAMP [INFO] Operation successful at index " + i);
                    }
                    bw.newLine();
                }
                System.out.println("Created dummy log file with 1000 entries.");
            } catch (IOException e) {
                System.err.println("Could not create dummy log: " + e.getMessage());
            }
        }
    }
}
