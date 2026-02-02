package iostreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Serialization - Save and Retrieve an Object
 * 
 * Designs a Java program that allows a user to store a list of employees in a
 * file
 * using Object Serialization and later retrieve the data from the file.
 * 
 * Requirements:
 * - Create an Employee class with fields: id, name, department, salary.
 * - Serialize the list of employees into a file (ObjectOutputStream).
 * - Deserialize and display the employees from the file (ObjectInputStream).
 * - Handle ClassNotFoundException and IOException.
 */
public class EmployeeSerialization {

    private static final String DATA_FILE = "employees.ser";

    // Inner static class implementing Serializable
    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L; // Best practice for serialization ver control

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
        }
    }

    public static void main(String[] args) {
        // 1. Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice Smith", "Engineering", 75000));
        employees.add(new Employee(102, "Bob Jones", "HR", 50000));
        employees.add(new Employee(103, "Charlie Brown", "Sales", 60000));

        System.out.println("Original List: " + employees);

        // 2. Serialize objects to file
        serializeEmployees(employees);

        // 3. Deserialize objects from file
        List<Employee> loadedEmployees = deserializeEmployees();

        System.out.println("Deserialized List: " + loadedEmployees);
    }

    private static void serializeEmployees(List<Employee> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(list);
            System.out.println("Serialization successful. Data saved to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> deserializeEmployees() {
        List<Employee> list = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            list = (List<Employee>) ois.readObject();
            System.out.println("Deserialization successful.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization failed: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
