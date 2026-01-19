/*
 * Program for Employee Records
 * Demonstrates access modifiers
 */
public class Employee {
    
    public int employeeID;
    protected String department;
    private double salary;

    /*
     * Constructor
     */
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public getter for private salary
    public double getSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeID);
        System.out.println("Dept: " + department);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee e = new Employee(101, "HR", 50000);
        e.displayDetails();
        
        System.out.println("--- Manager ---");
        Manager m = new Manager(102, "IT", 90000);
        m.displayManagerDetails();
    }
}

/*
 * Subclass Manager
 */
class Manager extends Employee {
    
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("ID: " + employeeID);
        System.out.println("Dept: " + department); // Protected
        System.out.println("Salary: " + getSalary()); // Public getter
    }
}
