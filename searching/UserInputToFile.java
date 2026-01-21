package searching;

import java.io.*;

/**
 * Problem: Read user input from console using InputStreamReader and write to a
 * file.
 */
public class UserInputToFile {
    public static void main(String[] args) {
        String outputFileName = "user_input.txt";

        // InputStreamReader to read from System.in
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            System.out.println("Enter text to save to file (type 'exit' to stop):");
            String line;
            while (true) {
                line = reader.readLine();
                if (line == null || "exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                writer.write(line);
                writer.newLine(); // Write each input as a new line
            }
            System.out.println("Input saved to " + outputFileName);
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}
