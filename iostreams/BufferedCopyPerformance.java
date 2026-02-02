package iostreams;

import java.io.*;
import java.util.Arrays;

/**
 * Problem 2: Buffered Streams - Efficient File Copy
 * 
 * This program copies a large file using Buffered Streams and compares
 * the performance with normal file streams.
 * 
 * Requirements:
 * - Read and write in chunks of 4 KB (4096 bytes).
 * - Use System.nanoTime() to measure execution time.
 * - Compare execution time with unbuffered streams.
 */
public class BufferedCopyPerformance {

    private static final String LARGE_FILE = "large_test_file.bin";
    private static final String OUT_BUFFERED = "out_buffered.bin";
    private static final String OUT_NORMAL = "out_normal.bin";
    private static final int FILE_SIZE_BYTES = 10 * 1024 * 1024; // 10 MB for testing (100MB takes too long to generate
                                                                 // on fly)
    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        // 1. Generate a large(ish) file for testing
        createLargeFileIfNeeded();

        // 2. Test Normal Stream Performance (with 4KB chunk reading)
        long normalDuration = copyWithNormalStreams();

        // 3. Test Buffered Stream Performance (with 4KB chunk reading and internal
        // buffering)
        long bufferedDuration = copyWithBufferedStreams();

        // 4. Compare results
        System.out.println("\n--- Performance Comparison ---");
        System.out.println("Normal Stream Time:   " + (normalDuration / 1_000_000) + " ms");
        System.out.println("Buffered Stream Time: " + (bufferedDuration / 1_000_000) + " ms");

        if (normalDuration > bufferedDuration) {
            System.out.println("Buffered usage was " + String.format("%.2f", (double) normalDuration / bufferedDuration)
                    + "x faster.");
        } else {
            System.out.println("Difference was negligible (file might be too small or caching involved).");
        }
    }

    private static long copyWithNormalStreams() {
        System.out.print("Running Normal File Stream Copy... ");
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(LARGE_FILE);
                FileOutputStream fos = new FileOutputStream(OUT_NORMAL)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Done.");
        return endTime - startTime;
    }

    private static long copyWithBufferedStreams() {
        System.out.print("Running Buffered Stream Copy... ");
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(LARGE_FILE));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(OUT_BUFFERED))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Done.");
        return endTime - startTime;
    }

    private static void createLargeFileIfNeeded() {
        File file = new File(LARGE_FILE);
        if (file.exists() && file.length() >= FILE_SIZE_BYTES) {
            System.out.println(
                    "Using existing large file: " + LARGE_FILE + " (" + (file.length() / 1024 / 1024) + " MB)");
            return;
        }

        System.out.println(
                "Generating large test file (" + (FILE_SIZE_BYTES / 1024 / 1024) + " MB)... this may take a moment.");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] chunk = new byte[BUFFER_SIZE];
            Arrays.fill(chunk, (byte) 1); // Fill with dummy data

            int loops = FILE_SIZE_BYTES / BUFFER_SIZE;
            for (int i = 0; i < loops; i++) {
                fos.write(chunk);
            }
        } catch (IOException e) {
            System.err.println("Error creating large file: " + e.getMessage());
        }
    }
}
