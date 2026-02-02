package iostreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Problem 8: Piped Streams - Inter-Thread Communication
 * 
 * Implements a Java program where one thread writes data into a
 * PipedOutputStream
 * and another thread reads data from a PipedInputStream.
 * 
 * Requirements:
 * - Use two threads for reading and writing.
 * - Synchronize properly to prevent data loss (handled internally by Piped
 * streams usually).
 * - Handle IOException.
 */
public class PipedThreadCommunication {

    public static void main(String[] args) {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream();

        try {
            // Connect the streams
            pos.connect(pis);
        } catch (IOException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return;
        }

        // Thread 1: Writer
        Thread writerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String msg = "Message " + i;
                    pos.write(msg.getBytes());
                    System.out.println("Writer sent: " + msg);
                    Thread.sleep(500); // Simulate delay
                }
                pos.close(); // Close stream to signal end of data
                System.out.println("Writer closed stream.");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread 2: Reader
        Thread readerThread = new Thread(() -> {
            try {
                int data;
                System.out.println("Reader waiting for data...");
                // read() blocks until data is available
                while ((data = pis.read()) != -1) {
                    // We might want to read chunks or lines, but byte-by-byte for simplicity or
                    // construct string buffer
                    // Here we assume messages are printed character by character as they arrive
                    System.out.print((char) data);

                    // Add a newline for clarity if we detect one or just printing stream
                    // To keep output clean, let's just print chars.
                    // Note: 'Message N' sent as bytes won't have newlines unless we add them.
                    // Let's add simple formatting in the writer or handle here?
                    // The prompt just says "reads data".
                }
                System.out.println("\nReader finished.");
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writerThread.start();
        readerThread.start();
    }
}
