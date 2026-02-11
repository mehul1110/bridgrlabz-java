package csvhandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Problem 6: Modify a CSV File (Update a Value)
 * 
 * This program reads a CSV file and increases the salary of employees
 * from the "IT" department by 10%. It saves the updated records back
 * to a new CSV file.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class ModifyCSVFile {

    // Constants
    private static final String TARGET_DEPARTMENT = "IT";
    private static final double SALARY_INCREMENT_PERCENTAGE = 10.0;

    /**
     * Main method to execute the CSV modification functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define file paths
        String inputFilePath = "csvhandling/employees.csv";
        String outputFilePath = "csvhandling/employees_updated.csv";

        System.out.println("========================================");
        System.out.println("  UPDATING IT DEPARTMENT SALARIES");
        System.out.println("========================================\n");

        int totalRecords = 0;
        int updatedRecords = 0;

        // Use try-with-resources to automatically close readers and writers
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isHeader = true;

            // Read and process the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Handle header row
                if (isHeader) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    isHeader = false;
                    continue;
                }

                totalRecords++;

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Extract employee details
                String id = columns[0];
                String name = columns[1];
                String department = columns[2];
                double salary = Double.parseDouble(columns[3]);

                // Check if employee is from IT department
                if (department.equalsIgnoreCase(TARGET_DEPARTMENT)) {
                    // Calculate new salary (10% increment)
                    double oldSalary = salary;
                    salary = salary * (1 + SALARY_INCREMENT_PERCENTAGE / 100);

                    updatedRecords++;

                    // Display update information
                    System.out.println("Updated: " + name);
                    System.out.println("  Department : " + department);
                    System.out.println("  Old Salary : ₹" + String.format("%.2f", oldSalary));
                    System.out.println("  New Salary : ₹" + String.format("%.2f", salary) + " (+10%)");
                    System.out.println();
                }

                // Write the updated record to the new file
                String updatedLine = id + "," + name + "," + department + "," + (int) salary;
                bufferedWriter.write(updatedLine);
                bufferedWriter.newLine();
            }

            System.out.println("========================================");
            System.out.println("Summary:");
            System.out.println("----------------------------------------");
            System.out.println("Total Records    : " + totalRecords);
            System.out.println("Updated Records  : " + updatedRecords);
            System.out.println("Output File      : " + outputFilePath);
            System.out.println("========================================");
            System.out.println("\n✓ CSV file updated successfully!");

        } catch (IOException ioException) {
            // Handle file reading/writing errors
            System.err.println("Error processing CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            // Handle invalid number format in salary column
            System.err.println("Error parsing salary: " + numberFormatException.getMessage());
            numberFormatException.printStackTrace();
        }
    }
}
