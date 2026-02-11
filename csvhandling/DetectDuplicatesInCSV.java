package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 12: Detect Duplicates in a CSV File
 * 
 * This program reads a CSV file and detects duplicate entries based on
 * the ID column. It prints all duplicate records with their occurrence count.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class DetectDuplicatesInCSV {

    /**
     * Inner class to store record details
     */
    static class Record {
        String id;
        String fullLine;
        int lineNumber;

        /**
         * Constructor for Record
         * 
         * @param id         Record ID
         * @param fullLine   Complete line from CSV
         * @param lineNumber Line number in the file
         */
        public Record(String id, String fullLine, int lineNumber) {
            this.id = id;
            this.fullLine = fullLine;
            this.lineNumber = lineNumber;
        }

        @Override
        public String toString() {
            return "Line " + lineNumber + ": " + fullLine;
        }
    }

    /**
     * Main method to execute the duplicate detection functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/students.csv";

        System.out.println("========================================");
        System.out.println("  DUPLICATE DETECTION IN CSV FILE");
        System.out.println("========================================\n");

        // Map to track ID occurrences: ID -> List of Records
        Map<String, List<Record>> idMap = new HashMap<>();

        int totalRecords = 0;

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            boolean isHeader = true;

            System.out.println("Scanning file: " + filePath);
            System.out.println("----------------------------------------\n");

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;

                // Skip the header row
                if (isHeader) {
                    System.out.println("Header (Line " + lineNumber + "): " + line + "\n");
                    isHeader = false;
                    continue;
                }

                totalRecords++;

                // Split the line to extract ID (assuming ID is the first column)
                String[] columns = line.split(",");
                String id = columns[0];

                // Create a Record object
                Record record = new Record(id, line, lineNumber);

                // Add record to the map
                if (idMap.containsKey(id)) {
                    // ID already exists - add to the list
                    idMap.get(id).add(record);
                } else {
                    // First occurrence of this ID
                    List<Record> recordList = new ArrayList<>();
                    recordList.add(record);
                    idMap.put(id, recordList);
                }
            }

            System.out.println("✓ File scan complete. Analyzing for duplicates...\n");

            // Analyze and display duplicates
            System.out.println("========================================");
            System.out.println("  DUPLICATE RECORDS REPORT");
            System.out.println("========================================\n");

            int duplicateGroups = 0;
            int totalDuplicates = 0;
            boolean foundDuplicates = false;

            // Iterate through the map to find duplicates
            for (Map.Entry<String, List<Record>> entry : idMap.entrySet()) {
                String id = entry.getKey();
                List<Record> records = entry.getValue();

                // If an ID appears more than once, it's a duplicate
                if (records.size() > 1) {
                    foundDuplicates = true;
                    duplicateGroups++;
                    totalDuplicates += records.size();

                    System.out.println("❌ DUPLICATE DETECTED - ID: " + id);
                    System.out.println("   Occurrence Count: " + records.size());
                    System.out.println("   Records:");

                    for (Record record : records) {
                        System.out.println("     - " + record);
                    }
                    System.out.println();
                }
            }

            // If no duplicates found
            if (!foundDuplicates) {
                System.out.println("✓ No duplicate records found!");
                System.out.println("All IDs are unique.\n");
            }

            // Display summary
            System.out.println("========================================");
            System.out.println("  SUMMARY");
            System.out.println("========================================");
            System.out.println("Total Records           : " + totalRecords);
            System.out.println("Unique IDs              : " + idMap.size());
            System.out.println("Duplicate Groups        : " + duplicateGroups);
            System.out.println("Total Duplicate Records : " + totalDuplicates);

            if (foundDuplicates) {
                System.out.println("Data Integrity Status   : ❌ FAILED (Duplicates found)");
            } else {
                System.out.println("Data Integrity Status   : ✓ PASSED (No duplicates)");
            }

            System.out.println("========================================");

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException arrayException) {
            // Handle missing columns
            System.err.println("Error: CSV file has missing ID column");
            arrayException.printStackTrace();
        }
    }
}
