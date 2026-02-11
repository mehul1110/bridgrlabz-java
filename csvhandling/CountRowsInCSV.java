package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem 3: Read and Count Rows in a CSV File
 * 
 * This program reads a CSV file and counts the number of records
 * (excluding the header row).
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class CountRowsInCSV {

    /**
     * Main method to execute the row counting functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/students.csv";

        System.out.println("========================================");
        System.out.println("  COUNTING ROWS IN CSV FILE");
        System.out.println("========================================\n");

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int totalRows = 0;
            int dataRows = 0;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                totalRows++;

                // Skip header row for data count
                if (totalRows > 1) {
                    dataRows++;
                }
            }

            // Display the results
            System.out.println("File: " + filePath);
            System.out.println("----------------------------------------");
            System.out.println("Total rows (including header): " + totalRows);
            System.out.println("Data rows (excluding header) : " + dataRows);
            System.out.println("----------------------------------------");

            // Provide additional information
            if (dataRows == 0) {
                System.out.println("\n⚠ Warning: No data rows found in the CSV file!");
            } else {
                System.out.println("\n✓ Successfully counted " + dataRows + " record(s)");
            }

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}
