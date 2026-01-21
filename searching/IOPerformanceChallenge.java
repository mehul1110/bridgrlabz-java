package searching;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Challenge Problem: Compare StringBuilder vs StringBuffer and FileReader vs
 * InputStreamReader.
 */
public class IOPerformanceChallenge {
    public static void main(String[] args) {
        String largeFileName = "large_test_file.txt";
        int iterations = 1000000;

        // 1. StringBuilder vs StringBuffer
        System.out.println("--- String Concatenation Performance (1M times) ---");
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++)
            sb.append("a");
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++)
            sbuf.append("a");
        System.out.println("StringBuffer:  " + (System.currentTimeMillis() - start) + "ms");

        // 2. Create a "large" file for testing (e.g., 5MB for brevity in this example)
        createLargeFile(largeFileName, 50000); // 50k lines

        // 3. FileReader vs InputStreamReader (Byte to Char with UTF-8)
        System.out.println("\n--- File Reading Performance ---");

        // FileReader
        start = System.currentTimeMillis();
        int wordsFileReader = countWordsWithFileReader(largeFileName);
        System.out.println(
                "FileReader count: " + wordsFileReader + " | Time: " + (System.currentTimeMillis() - start) + "ms");

        // InputStreamReader
        start = System.currentTimeMillis();
        int wordsISR = countWordsWithISR(largeFileName);
        System.out.println(
                "InputStreamReader count: " + wordsISR + " | Time: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void createLargeFile(String path, int lines) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < lines; i++) {
                pw.println("The quick brown fox jumps over the lazy dog " + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWordsWithFileReader(String path) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static int countWordsWithISR(String path) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
