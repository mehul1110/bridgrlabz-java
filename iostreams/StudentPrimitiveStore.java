package iostreams;

import java.io.*;

/**
 * Problem 7: Data Streams - Store and Retrieve Primitive Data
 * 
 * Writes a Java program that stores student details (roll number, name, GPA) in
 * a binary file and retrieves it later.
 * 
 * Requirements:
 * - Use DataOutputStream to write primitive data.
 * - Use DataInputStream to read data.
 * - Ensure proper closing of resources.
 */
public class StudentPrimitiveStore {

    private static final String DATA_FILE = "students.dat";

    public static void main(String[] args) {
        // Data to write
        int[] rolls = { 101, 102, 103 };
        String[] names = { "John Doe", "Jane Smith", "Mike Ross" };
        double[] gpas = { 3.5, 3.8, 2.9 };

        // 1. Write primitive data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(DATA_FILE))) {
            // Write number of students first so we know how many to read
            dos.writeInt(rolls.length);

            for (int i = 0; i < rolls.length; i++) {
                dos.writeInt(rolls[i]);
                dos.writeUTF(names[i]); // UTF-8 encoded string for names
                dos.writeDouble(gpas[i]);
            }
            System.out.println("Student data written to " + DATA_FILE);

        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }

        // 2. Read primitive data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(DATA_FILE))) {
            int count = dis.readInt();
            System.out.println("\nReading " + count + " student records:");
            System.out.println("Roll | Name       | GPA");
            System.out.println("-------------------------");

            for (int i = 0; i < count; i++) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.printf("%-4d | %-10s | %.2f%n", roll, name, gpa);
            }

        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}
