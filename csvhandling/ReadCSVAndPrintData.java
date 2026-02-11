package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem 1: Read a CSV File and Print Data
 * 
 * This program reads a CSV file containing student details (ID, Name, Age,
 * Marks)
 * and prints each record in a structured format.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class ReadCSVAndPrintData {

    /**
     * Main method to execute the CSV reading functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/students.csv";

        System.out.println("========================================");
        System.out.println("  STUDENT RECORDS FROM CSV FILE");
        System.out.println("========================================\n");

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int recordNumber = 0;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                recordNumber++;

                // Skip the header row
                if (recordNumber == 1) {
                    System.out.println("Header: " + line);
                    System.out.println("----------------------------------------\n");
                    continue;
                }

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Print data in a structured format
                System.out.println("Record #" + (recordNumber - 1) + ":");
                System.out.println("  ID    : " + columns[0]);
                System.out.println("  Name  : " + columns[1]);
                System.out.println("  Age   : " + columns[2]);
                System.out.println("  Marks : " + columns[3]);
                System.out.println();
            }

            System.out.println("----------------------------------------");
            System.out.println("Total Records Displayed: " + (recordNumber - 1));

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}
