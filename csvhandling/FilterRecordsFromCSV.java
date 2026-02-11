package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem 4: Filter Records from CSV
 * 
 * This program reads a CSV file and filters students who have scored
 * more than 80 marks. It prints only the qualifying records.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class FilterRecordsFromCSV {

    // Constant for the passing marks threshold
    private static final int MARKS_THRESHOLD = 80;

    /**
     * Main method to execute the filtering functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/students.csv";

        System.out.println("========================================");
        System.out.println("  STUDENTS WITH MARKS > " + MARKS_THRESHOLD);
        System.out.println("========================================\n");

        int qualifiedCount = 0;

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Skip the header row
                if (isHeader) {
                    System.out.println("Filtering students with marks > " + MARKS_THRESHOLD + "...\n");
                    isHeader = false;
                    continue;
                }

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Extract student details
                String id = columns[0];
                String name = columns[1];
                String age = columns[2];
                int marks = Integer.parseInt(columns[3]);

                // Filter students with marks > 80
                if (marks > MARKS_THRESHOLD) {
                    qualifiedCount++;

                    // Print qualifying records in a structured format
                    System.out.println("Qualified Student #" + qualifiedCount + ":");
                    System.out.println("  ID    : " + id);
                    System.out.println("  Name  : " + name);
                    System.out.println("  Age   : " + age);
                    System.out.println("  Marks : " + marks + " ✓");
                    System.out.println();
                }
            }

            System.out.println("========================================");
            System.out.println("Total Qualified Students: " + qualifiedCount);
            System.out.println("========================================");

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            // Handle invalid number format in marks column
            System.err.println("Error parsing marks: " + numberFormatException.getMessage());
            numberFormatException.printStackTrace();
        }
    }
}
