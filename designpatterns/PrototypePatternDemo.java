package designpatterns;

/**
 * Prototype Pattern implementation.
 * Creates objects by cloning existing ones (from memory) instead of creating
 * new instances.
 */
class EmployeeProfile implements Cloneable {
    private String name;
    private int id;
    private String department;

    public EmployeeProfile(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public void display() {
        System.out.println("Employee [Name=" + name + ", ID=" + id + ", Department=" + department + "]");
    }

    // Override clone method logic from Cloneable interface
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Cloning object instance currently present in memory structure
        return super.clone();
    }
}

public class PrototypePatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Prototype Pattern...\n");

        // Step 1: Create Original Source object instance
        EmployeeProfile emp1 = new EmployeeProfile("John Doe", 101, "Engineering");

        System.out.println("Original Object Data:");
        emp1.display();

        try {
            // Step 2: Form a new copy element from previous memory
            EmployeeProfile clonedEmp = (EmployeeProfile) emp1.clone();

            System.out.println("\nCloned Object Data Output:");
            clonedEmp.display();

            // Compare runtime data mapping references
            if (emp1 != clonedEmp) {
                System.out.println("\nSUCCESS: Original and Cloned objects exist at different memory locations!");
            }
        } catch (CloneNotSupportedException e) {
            System.err.println("Clone procedure restricted or failed.");
        }
    }
}
