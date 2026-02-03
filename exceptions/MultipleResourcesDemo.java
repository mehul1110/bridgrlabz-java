package exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Problem Statement 4: Try-With-Resources with Multiple Resources
 * 
 * Problem: Read 2 files, write to 3rd. Ensure closure.
 */
public class MultipleResourcesDemo {

    public static void main(String[] args) {
        try (
                BufferedReader r1 = new BufferedReader(new FileReader("data.txt"));
                BufferedReader r2 = new BufferedReader(new FileReader("info.txt"));
                BufferedWriter w = new BufferedWriter(new FileWriter("merged.txt"))) {
            w.write(r1.readLine());
            w.newLine();
            w.write(r2.readLine());
            System.out.println("Merge complete.");
        } catch (IOException e) {
            System.out.println("Error processing files");
        }
    }
}
