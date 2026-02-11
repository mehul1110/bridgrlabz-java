package csvhandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 10: Merge Two CSV Files
 * 
 * This program merges two CSV files:
 * - students1.csv (contains ID, Name, Age)
 * - students2.csv (contains ID, Marks, Grade)
 * 
 * It merges both files based on ID and creates a new file containing all
 * details.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class MergeTwoCSVFiles {

    /**
     * Main method to execute the CSV merging functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define file paths
        String file1Path = "csvhandling/students1.csv";
        String file2Path = "csvhandling/students2.csv";
        String mergedFilePath = "csvhandling/students_merged.csv";

        System.out.println("========================================");
        System.out.println("  MERGING TWO CSV FILES");
        System.out.println("========================================\n");

        // Map to store data from first file (ID -> Name,Age)
        Map<String, String> file1Data = new HashMap<>();

        // Map to store data from second file (ID -> Marks,Grade)
        Map<String, String> file2Data = new HashMap<>();

        try {
            // Read first CSV file (students1.csv)
            System.out.println("Reading file 1: " + file1Path);
            try (BufferedReader br1 = new BufferedReader(new FileReader(file1Path))) {
                String line;
                boolean isHeader = true;

                while ((line = br1.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }

                    // Split the line: ID,Name,Age
                    String[] columns = line.split(",");
                    String id = columns[0];
                    String nameAge = columns[1] + "," + columns[2];

                    file1Data.put(id, nameAge);
                }
            }
            System.out.println("✓ File 1 loaded: " + file1Data.size() + " records\n");

            // Read second CSV file (students2.csv)
            System.out.println("Reading file 2: " + file2Path);
            try (BufferedReader br2 = new BufferedReader(new FileReader(file2Path))) {
                String line;
                boolean isHeader = true;

                while ((line = br2.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }

                    // Split the line: ID,Marks,Grade
                    String[] columns = line.split(",");
                    String id = columns[0];
                    String marksGrade = columns[1] + "," + columns[2];

                    file2Data.put(id, marksGrade);
                }
            }
            System.out.println("✓ File 2 loaded: " + file2Data.size() + " records\n");

            // Merge the data and write to new file
            System.out.println("Merging files based on ID...\n");

            int mergedCount = 0;
            int unmatchedCount = 0;

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mergedFilePath))) {

                // Write header
                bufferedWriter.write("ID,Name,Age,Marks,Grade");
                bufferedWriter.newLine();

                // Iterate through all IDs from file1
                for (Map.Entry<String, String> entry : file1Data.entrySet()) {
                    String id = entry.getKey();
                    String nameAge = entry.getValue();

                    // Check if this ID exists in file2
                    if (file2Data.containsKey(id)) {
                        String marksGrade = file2Data.get(id);

                        // Merge the records
                        String mergedLine = id + "," + nameAge + "," + marksGrade;
                        bufferedWriter.write(mergedLine);
                        bufferedWriter.newLine();

                        mergedCount++;
                        System.out.println("✓ Merged record for ID: " + id);
                    } else {
                        unmatchedCount++;
                        System.out.println("⚠ Warning: ID " + id + " found in File1 but not in File2");
                    }
                }

                // Check for IDs in file2 that are not in file1
                for (String id : file2Data.keySet()) {
                    if (!file1Data.containsKey(id)) {
                        unmatchedCount++;
                        System.out.println("⚠ Warning: ID " + id + " found in File2 but not in File1");
                    }
                }
            }

            // Display merge summary
            System.out.println("\n========================================");
            System.out.println("  MERGE SUMMARY");
            System.out.println("========================================");
            System.out.println("File 1 Records     : " + file1Data.size());
            System.out.println("File 2 Records     : " + file2Data.size());
            System.out.println("Merged Records     : " + mergedCount);
            System.out.println("Unmatched Records  : " + unmatchedCount);
            System.out.println("Output File        : " + mergedFilePath);
            System.out.println("========================================");
            System.out.println("\n✓ Files merged successfully!");

        } catch (IOException ioException) {
            // Handle file reading/writing errors
            System.err.println("Error processing CSV files: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}
