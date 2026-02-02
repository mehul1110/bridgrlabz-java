package iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * Problem 1: File Handling - Read and Write a Text File
 * 
 * This program reads the contents of a text file and writes it into a new file.
 * It strictly uses FileInputStream and FileOutputStream as requested.
 * 
 * Requirements:
 * - Use FileInputStream and FileOutputStream.
 * - Handle IOException properly.
 * - Ensure that the destination file is created if it does not exist.
 */
public class FileCopyExample {

    private static final String SOURCE_FILE = "source_problem1.txt";
    private static final String DEST_FILE = "destination_problem1.txt";

    public static void main(String[] args) {
        // Create a dummy source file for valid testing if it doesn't exist
        createDummyFileIfNotExists();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File sourceFile = new File(SOURCE_FILE);
            if (!sourceFile.exists()) {
                System.out.println("Error: Source file '" + SOURCE_FILE + "' does not exist.");
                return;
            }

            // Initialize streams
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(DEST_FILE);

            System.out.println("Starting file copy...");

            int byteData;
            // Read byte by byte (inefficient but required by the problem for basic stream
            // demo)
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to '" + DEST_FILE + "'.");

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in finally block to ensure they are released
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }

    private static void createDummyFileIfNotExists() {
        File file = new File(SOURCE_FILE);
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                String content = "Hello, this is a test file for Problem 1.\nStream based file copying example.";
                fos.write(content.getBytes());
                System.out.println("Created dummy file: " + SOURCE_FILE);
            } catch (IOException e) {
                System.err.println("Could not create dummy file: " + e.getMessage());
            }
        }
    }
}
