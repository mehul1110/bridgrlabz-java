package searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Problem: Use FileReader to read a text file line by line.
 */
public class FileReaderLineByLine {
    public static void main(String[] args) {
        String fileName = "sample_text.txt";

        // Creating a sample file for demonstration
        createSampleFile(fileName);

        // Reading the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Contents of " + fileName + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void createSampleFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello World!\n");
            writer.write("This is a test file for FileReader.\n");
            writer.write("Reading line by line is efficient with BufferedReader.\n");
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
}
