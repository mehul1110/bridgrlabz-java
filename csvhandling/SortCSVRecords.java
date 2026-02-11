package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem 7: Sort CSV Records by a Column
 * 
 * This program reads a CSV file and sorts the records by Salary
 * in descending order. It prints the top 5 highest-paid employees.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class SortCSVRecords {

    /**
     * Inner class to represent an Employee record
     */
    static class Employee {
        String id;
        String name;
        String department;
        double salary;

        /**
         * Constructor to initialize Employee object
         * 
         * @param id         Employee ID
         * @param name       Employee Name
         * @param department Employee Department
         * @param salary     Employee Salary
         */
        public Employee(String id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        /**
         * Get employee salary
         * 
         * @return salary
         */
        public double getSalary() {
            return salary;
        }

        /**
         * String representation of Employee
         * 
         * @return formatted employee details
         */
        @Override
        public String toString() {
            return String.format("%-5s | %-20s | %-15s | ₹%-10.2f",
                    id, name, department, salary);
        }
    }

    /**
     * Main method to execute the sorting functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/employees.csv";

        System.out.println("========================================");
        System.out.println("  TOP 5 HIGHEST PAID EMPLOYEES");
        System.out.println("========================================\n");

        // List to store all employees
        List<Employee> employees = new ArrayList<>();

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Extract employee details and create Employee object
                String id = columns[0];
                String name = columns[1];
                String department = columns[2];
                double salary = Double.parseDouble(columns[3]);

                // Add employee to the list
                employees.add(new Employee(id, name, department, salary));
            }

            // Sort employees by salary in descending order
            Collections.sort(employees, new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    return Double.compare(e2.getSalary(), e1.getSalary());
                }
            });

            // Alternatively, using lambda expression (Java 8+):
            // employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

            // Print the top 5 highest-paid employees
            System.out.println("Rank  | ID    | Name                 | Department      | Salary");
            System.out.println("------|-------|----------------------|-----------------|------------");

            int displayCount = Math.min(5, employees.size());
            for (int i = 0; i < displayCount; i++) {
                System.out.printf("%-5d | %s%n", (i + 1), employees.get(i));
            }

            System.out.println("\n========================================");
            System.out.println("Total Employees Scanned: " + employees.size());
            System.out.println("Top Employees Displayed: " + displayCount);
            System.out.println("========================================");

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            // Handle invalid number format in salary column
            System.err.println("Error parsing salary: " + numberFormatException.getMessage());
            numberFormatException.printStackTrace();
        }
    }
}
