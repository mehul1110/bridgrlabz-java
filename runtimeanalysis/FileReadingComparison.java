package runtimeanalysis;

import java.io.*;

/**
 * 4. Problem Statement: Large File Reading Efficiency
 * Objective: Compare FileReader (Character Stream) and InputStreamReader (Byte
 * Stream) reading a 10MB test file.
 */
public class FileReadingComparison {

    public static void main(String[] args) throws IOException {
        String testFile = "performance_test.txt";
        generateTestFile(testFile, 10); // Generating a 10MB test file

        System.out.println("==========================================================================");
        System.out.println("PROBLEM 4: LARGE FILE READING EFFICIENCY (10MB File)");
        System.out.println("==========================================================================");

        // FileReader: Read characters from the file
        long startFR = System.currentTimeMillis();
        try (FileReader fr = new FileReader(testFile)) {
            // Loop until end of stream is reached
            while (fr.read() != -1) {
                // Reading one character at a time
            }
        }
        long endFR = System.currentTimeMillis();
        System.out.printf("%-25s: %d ms\n", "FileReader Time", (endFR - startFR));

        // InputStreamReader: Bridge from byte streams to character streams
        long startISR = System.currentTimeMillis();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(testFile))) {
            // Loop until end of stream is reached
            while (isr.read() != -1) {
                // Reading one byte converted to char at a time
            }
        }
        long endISR = System.currentTimeMillis();
        System.out.printf("%-25s: %d ms\n", "InputStreamReader Time", (endISR - startISR));

        System.out.println("==========================================================================\n");

        // Clean up the generated test file
        new File(testFile).delete();
    }

    private static void generateTestFile(String name, int mb) throws IOException {
        try (FileWriter fw = new FileWriter(name)) {
            String line = "This is a dummy line for testing performance of file readers in Java.\n";
            long iters = (mb * 1024L * 1024L) / line.length();
            // Loop to populate file with repeated lines until size is reached
            for (long i = 0; i < iters; i++) {
                fw.write(line);
            }
        }
    }
}
