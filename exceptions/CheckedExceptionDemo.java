package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Practice Problem 1: Checked Exception (Compile-time Exception)
 * 
 * Problem: Read "data.txt". catch IOException.
 * Expected: File exists -> print contents. File missing -> print "File not
 * found".
 */
public class CheckedExceptionDemo {

    public static void main(String[] args) {
        // Ensure dummy file exists for happy path (Optional, but good for testing)
        // new java.io.File("data.txt");

        String fileName = "data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
