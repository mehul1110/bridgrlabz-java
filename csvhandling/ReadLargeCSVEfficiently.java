package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem 11: Read Large CSV File Efficiently
 * 
 * Given a large CSV file (500MB+), this program implements a memory-efficient
 * way to read it in chunks. It processes only 100 lines at a time and displays
 * the count of records processed.
 * 
 * This approach prevents memory overflow when dealing with very large files.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class ReadLargeCSVEfficiently {

    // Constant for chunk size (number of lines to process at a time)
    private static final int CHUNK_SIZE = 100;

    /**
     * Process a chunk of CSV data
     * 
     * @param chunkNumber  The current chunk number
     * @param linesInChunk The number of lines in this chunk
     */
    private static void processChunk(int chunkNumber, int linesInChunk) {
        System.out.println("Processing Chunk #" + chunkNumber +
                " (" + linesInChunk + " lines)");

        // Simulate processing (in real scenario, you would perform operations here)
        // For example: data validation, transformation, database insertion, etc.

        // Optional: Add a small delay to simulate processing time
        try {
            Thread.sleep(50); // 50ms processing time simulation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Main method to execute the efficient CSV reading functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the large CSV file path
        String filePath = "csvhandling/students.csv"; // Use any CSV file for demonstration

        System.out.println("========================================");
        System.out.println("  EFFICIENT LARGE CSV FILE READER");
        System.out.println("========================================\n");
        System.out.println("Chunk Size: " + CHUNK_SIZE + " lines per chunk");
        System.out.println("File: " + filePath);
        System.out.println("----------------------------------------\n");

        int totalRecordsProcessed = 0;
        int currentChunk = 0;
        int linesInCurrentChunk = 0;

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Skip the header row
                if (isHeader) {
                    System.out.println("Skipping header row: " + line + "\n");
                    isHeader = false;
                    continue;
                }

                // Increment line counter for current chunk
                linesInCurrentChunk++;
                totalRecordsProcessed++;

                // When chunk size is reached, process the chunk
                if (linesInCurrentChunk >= CHUNK_SIZE) {
                    currentChunk++;
                    processChunk(currentChunk, linesInCurrentChunk);

                    // Display progress
                    System.out.println("  ✓ Chunk completed. Total processed so far: " +
                            totalRecordsProcessed + " records\n");

                    // Reset chunk counter
                    linesInCurrentChunk = 0;

                    // Optional: Clear memory (force garbage collection for very large files)
                    // System.gc();
                }
            }

            // Process any remaining lines that didn't fill a complete chunk
            if (linesInCurrentChunk > 0) {
                currentChunk++;
                processChunk(currentChunk, linesInCurrentChunk);
                System.out.println("  ✓ Final chunk completed. Total processed: " +
                        totalRecordsProcessed + " records\n");
            }

            // Display final summary
            System.out.println("========================================");
            System.out.println("  PROCESSING SUMMARY");
            System.out.println("========================================");
            System.out.println("Total Records Processed : " + totalRecordsProcessed);
            System.out.println("Total Chunks Processed  : " + currentChunk);
            System.out.println("Chunk Size              : " + CHUNK_SIZE + " lines");
            System.out.println("Lines in Last Chunk     : " +
                    (linesInCurrentChunk == 0 ? CHUNK_SIZE : linesInCurrentChunk));
            System.out.println("========================================");
            System.out.println("\n✓ Large file processed successfully!");
            System.out.println("\nMemory-Efficient Processing Benefits:");
            System.out.println("- Prevents OutOfMemoryError for large files");
            System.out.println("- Enables progress tracking");
            System.out.println("- Allows for batch processing operations");
            System.out.println("- Reduces memory footprint");

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}
