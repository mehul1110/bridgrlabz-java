package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Problem 5: Search for a Record in CSV
 * 
 * This program reads an employees.csv file and searches for an employee by
 * name.
 * It prints their department and salary if found.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class SearchRecordInCSV {

    /**
     * Main method to execute the search functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/employees.csv";

        System.out.println("========================================");
        System.out.println("  EMPLOYEE SEARCH SYSTEM");
        System.out.println("========================================\n");

        // Get employee name from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("\nSearching for employee: " + searchName);
            System.out.println("========================================\n");

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Extract employee details
                String id = columns[0];
                String name = columns[1];
                String department = columns[2];
                String salary = columns[3];

                // Check if the name matches (case-insensitive)
                if (name.equalsIgnoreCase(searchName)) {
                    found = true;

                    // Print employee details
                    System.out.println("✓ Employee Found!");
                    System.out.println("----------------------------------------");
                    System.out.println("ID         : " + id);
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : ₹" + salary);
                    System.out.println("----------------------------------------");
                    break; // Exit loop once employee is found
                }
            }

            // If employee not found
            if (!found) {
                System.out.println("✗ Employee not found!");
                System.out.println("Name '" + searchName + "' does not exist in the database.");
            }

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
