package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement 1: Try-With-Resources for Multiple Files
 * 
 * Problem: Read multiple files from list. Ensure each closed. Handle
 * IOException.
 */
public class FileProcessor {

    public void processFiles(List<String> filePaths) {
        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                System.out.println("Processing " + path + ":");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }
        }
    }

    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        processor.processFiles(Arrays.asList("data.txt", "missing.txt"));
    }
}
