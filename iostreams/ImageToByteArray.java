package iostreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Problem 5: ByteArray Stream - Convert Image to ByteArray
 * 
 * Writes a Java program that converts an image file into a byte array and then
 * writes it back to another image file.
 * 
 * Requirements:
 * - Use ByteArrayInputStream and ByteArrayOutputStream.
 * - Verify that the new file is identical to the original image.
 * - Handle IOException.
 */
public class ImageToByteArray {

    private static final String INPUT_IMAGE = "dummy_image.png";
    private static final String OUTPUT_IMAGE = "restored_image.png";

    public static void main(String[] args) {
        // Create a dummy image file (binary data) for testing
        createDummyImageIfNeeded();

        try {
            // 1. Read file into a byte array (Simulated "Image to ByteArray")
            // Normally we would just use Files.readAllBytes() but we should demonstrate
            // usage of streams or at least the process
            byte[] imageBytes = readImageToByteArray(INPUT_IMAGE);
            System.out.println("Image read into byte array. Size: " + imageBytes.length + " bytes.");

            // 2. Write byte array back to file using ByteArrayInputStream (as a source for
            // simulation)
            // or just use FileOutputStream directly. Attempting to use ByteArrayStreams as
            // requested.
            writeByteArrayToImage(imageBytes, OUTPUT_IMAGE);

            System.out.println("Image restored to '" + OUTPUT_IMAGE + "'.");

            // 3. Verification
            if (verifyIdentity(INPUT_IMAGE, OUTPUT_IMAGE)) {
                System.out.println("Success: The restored image is identical to the original.");
            } else {
                System.err.println("Failure: The restored image differs from the original.");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static byte[] readImageToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        // Using ByteArrayOutputStream to accumulate bytes from file stream
        try (FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] data, String outputPath) throws IOException {
        // Using ByteArrayInputStream to read from the array and write to file
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
                FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static boolean verifyIdentity(String file1, String file2) throws IOException {
        Path p1 = Paths.get(file1);
        Path p2 = Paths.get(file2);
        // Available since Java 12: Files.mismatch(p1, p2). For older java versions,
        // read bytes and compare.
        // Assuming Java 8+ environment, we read all bytes.
        byte[] f1 = Files.readAllBytes(p1);
        byte[] f2 = Files.readAllBytes(p2);

        if (f1.length != f2.length)
            return false;

        for (int i = 0; i < f1.length; i++) {
            if (f1[i] != f2[i])
                return false;
        }
        return true;
    }

    private static void createDummyImageIfNeeded() {
        File f = new File(INPUT_IMAGE);
        if (!f.exists()) {
            try (FileOutputStream fos = new FileOutputStream(f)) {
                byte[] randomBytes = new byte[1024 * 5]; // 5KB dummy image
                new Random().nextBytes(randomBytes);
                fos.write(randomBytes);
                System.out.println("Created dummy image file: " + INPUT_IMAGE);
            } catch (IOException e) {
                System.err.println("Could not create dummy image: " + e.getMessage());
            }
        }
    }
}
