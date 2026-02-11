package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Problem 8: Validate CSV Data Before Processing
 * 
 * This program validates CSV data by:
 * - Ensuring that the "Email" column follows a valid email format using regex
 * - Ensuring that "Phone Numbers" contain exactly 10 digits
 * - Printing any invalid rows with an error message
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class ValidateCSVData {

    // Regular expression patterns for validation
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    /**
     * Validates email format using regex
     * 
     * @param email Email address to validate
     * @return true if valid, false otherwise
     */
    private static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates phone number (must be exactly 10 digits)
     * 
     * @param phone Phone number to validate
     * @return true if valid, false otherwise
     */
    private static boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    /**
     * Main method to execute the validation functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/contacts.csv";

        System.out.println("========================================");
        System.out.println("  CSV DATA VALIDATION SYSTEM");
        System.out.println("========================================\n");

        int totalRecords = 0;
        int validRecords = 0;
        int invalidRecords = 0;

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Validation Rules:");
            System.out.println("- Email must be in valid format (e.g., user@example.com)");
            System.out.println("- Phone must contain exactly 10 digits");
            System.out.println("\n========================================\n");

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Skip and display header row
                if (isHeader) {
                    System.out.println("Processing file: " + filePath);
                    System.out.println("Header: " + line);
                    System.out.println("----------------------------------------\n");
                    isHeader = false;
                    continue;
                }

                totalRecords++;

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Extract contact details (assuming format: ID,Name,Email,Phone)
                String id = columns[0];
                String name = columns[1];
                String email = columns[2];
                String phone = columns[3];

                // Validation flags
                boolean emailValid = isValidEmail(email);
                boolean phoneValid = isValidPhone(phone);

                // Check if record is valid
                if (emailValid && phoneValid) {
                    validRecords++;
                    System.out.println("✓ VALID - Record #" + totalRecords + ": " + name);
                } else {
                    invalidRecords++;
                    System.out.println("✗ INVALID - Record #" + totalRecords + ":");
                    System.out.println("  ID    : " + id);
                    System.out.println("  Name  : " + name);

                    // Report specific validation errors
                    if (!emailValid) {
                        System.out.println("  Email : " + email + " ❌ (Invalid email format)");
                    } else {
                        System.out.println("  Email : " + email + " ✓");
                    }

                    if (!phoneValid) {
                        System.out.println("  Phone : " + phone + " ❌ (Must be exactly 10 digits)");
                    } else {
                        System.out.println("  Phone : " + phone + " ✓");
                    }

                    System.out.println();
                }
            }

            // Display validation summary
            System.out.println("========================================");
            System.out.println("VALIDATION SUMMARY");
            System.out.println("========================================");
            System.out.println("Total Records    : " + totalRecords);
            System.out.println("Valid Records    : " + validRecords);
            System.out.println("Invalid Records  : " + invalidRecords);
            System.out.println("Success Rate     : " +
                    String.format("%.2f%%", (validRecords * 100.0 / totalRecords)));
            System.out.println("========================================");

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException arrayException) {
            // Handle missing columns
            System.err.println("Error: CSV file has missing columns");
            arrayException.printStackTrace();
        }
    }
}
