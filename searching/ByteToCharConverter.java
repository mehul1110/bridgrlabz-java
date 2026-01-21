package searching;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Problem: Use InputStreamReader to read binary (byte) data and convert to
 * character stream with UTF-8.
 */
public class ByteToCharConverter {
    public static void main(String[] args) {
        String fileName = "sample_text.txt";

        try (FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {

            String line;
            System.out.println("Reading using InputStreamReader (UTF-8):");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
