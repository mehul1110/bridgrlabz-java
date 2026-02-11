package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 9: Convert CSV Data into Java Objects
 * 
 * This program reads a CSV file and converts each row into a Student Java
 * object.
 * It stores the objects in a List<Student> and prints them.
 * 
 * @author CSV Handling Practice
 * @version 1.0
 */
public class ConvertCSVToObjects {

    /**
     * Student class to represent student data
     */
    static class Student {
        // Private fields for encapsulation
        private String id;
        private String name;
        private int age;
        private double marks;

        /**
         * Constructor to initialize Student object
         * 
         * @param id    Student ID
         * @param name  Student Name
         * @param age   Student Age
         * @param marks Student Marks
         */
        public Student(String id, String name, int age, double marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        // Getter methods
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getMarks() {
            return marks;
        }

        /**
         * Calculate grade based on marks
         * 
         * @return Grade (A, B, C, D, or F)
         */
        public String getGrade() {
            if (marks >= 90)
                return "A";
            else if (marks >= 80)
                return "B";
            else if (marks >= 70)
                return "C";
            else if (marks >= 60)
                return "D";
            else
                return "F";
        }

        /**
         * String representation of Student object
         * 
         * @return Formatted student details
         */
        @Override
        public String toString() {
            return String.format("Student{ID='%s', Name='%s', Age=%d, Marks=%.2f, Grade='%s'}",
                    id, name, age, marks, getGrade());
        }

        /**
         * Display student details in a formatted manner
         */
        public void displayDetails() {
            System.out.println("  ID    : " + id);
            System.out.println("  Name  : " + name);
            System.out.println("  Age   : " + age);
            System.out.println("  Marks : " + marks);
            System.out.println("  Grade : " + getGrade());
        }
    }

    /**
     * Main method to execute the CSV to Object conversion
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define the CSV file path
        String filePath = "csvhandling/students.csv";

        System.out.println("========================================");
        System.out.println("  CSV TO JAVA OBJECTS CONVERTER");
        System.out.println("========================================\n");

        // List to store Student objects
        List<Student> students = new ArrayList<>();

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Skip the header row
                if (isHeader) {
                    System.out.println("Reading CSV file: " + filePath);
                    System.out.println("----------------------------------------\n");
                    isHeader = false;
                    continue;
                }

                // Split the line into columns using comma as delimiter
                String[] columns = line.split(",");

                // Extract student details
                String id = columns[0];
                String name = columns[1];
                int age = Integer.parseInt(columns[2]);
                double marks = Double.parseDouble(columns[3]);

                // Create Student object and add to list
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

            System.out.println("✓ Successfully converted " + students.size() + " records to Student objects\n");
            System.out.println("========================================");
            System.out.println("  STUDENT LIST");
            System.out.println("========================================\n");

            // Display all student objects
            for (int i = 0; i < students.size(); i++) {
                System.out.println("Student #" + (i + 1) + ":");
                students.get(i).displayDetails();
                System.out.println();
            }

            // Display using toString() method
            System.out.println("========================================");
            System.out.println("  COMPACT VIEW (toString())");
            System.out.println("========================================\n");

            for (Student student : students) {
                System.out.println(student);
            }

            // Display statistics
            System.out.println("\n========================================");
            System.out.println("  STATISTICS");
            System.out.println("========================================");
            System.out.println("Total Students  : " + students.size());

            // Calculate average marks
            double totalMarks = 0;
            for (Student student : students) {
                totalMarks += student.getMarks();
            }
            double averageMarks = totalMarks / students.size();

            System.out.println("Average Marks   : " + String.format("%.2f", averageMarks));
            System.out.println("========================================");

        } catch (IOException ioException) {
            // Handle file reading errors
            System.err.println("Error reading CSV file: " + ioException.getMessage());
            ioException.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            // Handle invalid number format
            System.err.println("Error parsing numeric data: " + numberFormatException.getMessage());
            numberFormatException.printStackTrace();
        }
    }
}
