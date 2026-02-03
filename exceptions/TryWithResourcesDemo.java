package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Practice Problem 5: try-with-resources
 * 
 * Problem: Read first line of "info.txt".
 * Expected: Exists -> print line. Missing -> "Error reading file".
 */
public class TryWithResourcesDemo {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
