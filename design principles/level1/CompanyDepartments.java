import java.util.ArrayList;

/*
 * Problem 3: Company and Departments (Composition)
 * Demonstrates composition where departments cannot exist without company
 */

// Employee class
class Employee {
    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("  Employee: " + name + " (ID: " + id + ")");
    }
}

// Department class
class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}

// Company class
public class CompanyDepartments {
    private String companyName;
    private ArrayList<Department> departments;

    public CompanyDepartments(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Create department (composition)
    public Department createDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        System.out.println("Department '" + deptName + "' created in " + companyName);
        return dept;
    }

    // Display company structure
    public void displayCompany() {
        System.out.println("\n=== " + companyName + " ===");
        for (Department dept : departments) {
            dept.displayDepartment();
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        // Create company
        CompanyDepartments company = new CompanyDepartments("Tech Corp");

        // Create departments (composition - owned by company)
        Department itDept = company.createDepartment("IT");
        Department hrDept = company.createDepartment("HR");

        // Add employees to departments
        itDept.addEmployee(new Employee("John", "E001"));
        itDept.addEmployee(new Employee("Jane", "E002"));
        hrDept.addEmployee(new Employee("Mike", "E003"));

        // Display company
        company.displayCompany();

        // When company is deleted, departments are also deleted (composition)
        System.out.println("\nCompany deleted - all departments removed");
        company = null;
    }
}
