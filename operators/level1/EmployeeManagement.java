/*
 * Program for Employee Management System
 * Demonstrates static, this, final, and instanceof keywords
 */
public class EmployeeManagement {
    
    // Static variables shared by all employees
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    
    // Instance variables
    private String name;
    private final String id; // Final - cannot be modified
    private String designation;

    /*
     * Constructor
     * Uses 'this' to initialize instance variables
     */
    public EmployeeManagement(String name, String id, String designation) {
        this.name = name; // 'this' resolves ambiguity
        this.id = id; // Final variable initialization
        this.designation = designation;
        totalEmployees++; // Increment static counter
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
        System.out.println("-------------------------");
    }

    // Safe display using instanceof check
    public static void safeDisplay(Object obj) {
        // Check if object is instance of EmployeeManagement
        if (obj instanceof EmployeeManagement) {
            EmployeeManagement emp = (EmployeeManagement) obj;
            emp.displayDetails();
        } else {
            System.out.println("Error: Object is not an EmployeeManagement instance");
        }
    }

    public static void main(String[] args) {
        // Create employees
        EmployeeManagement emp1 = new EmployeeManagement("John Doe", "EMP001", "Software Engineer");
        EmployeeManagement emp2 = new EmployeeManagement("Jane Smith", "EMP002", "Project Manager");
        
        // Display using instanceof check
        System.out.println("--- Employee 1 ---");
        safeDisplay(emp1);
        
        System.out.println("--- Employee 2 ---");
        safeDisplay(emp2);
        
        // Display total employees
        EmployeeManagement.displayTotalEmployees();
        
        // Test instanceof with invalid object
        System.out.println("\n--- Testing with invalid object ---");
        safeDisplay(new Object());
    }
}
