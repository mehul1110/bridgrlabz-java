import java.util.ArrayList;

/*
 * Problem 1: Employee Management System
 * Demonstrates encapsulation, abstract classes, interfaces, and polymorphism
 */

// Interface
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// Abstract class
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and setters (encapsulation)
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// Concrete class 1
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        // Full time gets base salary + 20% bonus
        return getBaseSalary() * 1.20;
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Concrete class 2
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;

    public PartTimeEmployee(String employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, hourlyRate);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        // Part time salary = hourly rate * hours worked
        return getBaseSalary() * hoursWorked;
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        // Create employee list
        ArrayList<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee("FT001", "Alice", 5000);
        emp1.assignDepartment("IT");
        
        PartTimeEmployee emp2 = new PartTimeEmployee("PT001", "Bob", 25, 80);
        emp2.assignDepartment("HR");

        employees.add(emp1);
        employees.add(emp2);

        // Polymorphism - processing different employee types
        System.out.println("=== Employee Details ===");
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println("Department: " + ((Department) emp).getDepartmentDetails());
            }
            System.out.println("-------------------------");
        }
    }
}
