package csvhandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Problem 2: Write Data to a CSV File
 * 
 * This program creates a CSV file with employee details (ID, Name, Department,
 * Salary)
 * and writes at least 5 records to the file.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class WriteDataToCSV {

    /**
     * Main method to execute the CSV writing functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the output CSV file path
        String filePath = "csvhandling/employees.csv";

        System.out.println("========================================");
        System.out.println("  WRITING EMPLOYEE DATA TO CSV FILE");
        System.out.println("========================================\n");

        // Use try-with-resources to automatically close the BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            // Write the header row
            bufferedWriter.write("ID,Name,Department,Salary");
            bufferedWriter.newLine();

            // Write employee records (at least 5 records)
            String[] employees = {
                    "101,John Doe,Engineering,60000",
                    "102,Jane Smith,HR,50000",
                    "103,Michael Brown,Marketing,55000",
                    "104,Alice Williams,Finance,62000",
                    "105,Bob Johnson,Sales,58000",
                    "106,Emily Davis,IT,65000",
                    "107,David Wilson,IT,67000"
            };

            // Write each employee record to the file
            for (String employee : employees) {
                bufferedWriter.write(employee);
                bufferedWriter.newLine();
            }

            System.out.println("✓ CSV file created successfully!");
            System.out.println("✓ File location: " + filePath);
            System.out.println("✓ Total records written: " + employees.length);
            System.out.println("\nEmployee records written:");
            System.out.println("----------------------------------------");

            // Display the records that were written
            for (int i = 0; i < employees.length; i++) {
                System.out.println((i + 1) + ". " + employees[i]);
            }

        } catch (IOException ioException) {
            // Handle file writing errors
            System.err.println("Error writing to CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}
