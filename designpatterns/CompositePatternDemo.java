package designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern implementation.
 * Treats individual objects and compositions of objects uniformly.
 */

// Define standard rules matching common behavior
interface EmployeeComponent {
    void showDetails();
}

// Implement Leaf objects (no children components below them)
class Developer implements EmployeeComponent {
    private String name;
    private long id;

    public Developer(String name, long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void showDetails() {
        System.out.println("  - Developer [ ID = " + id + ", Name = " + name + " ]");
    }
}

// Implement Composite objects (has branches/children below)
class Manager implements EmployeeComponent {
    private String name;
    private long id;

    // Hold collections of objects implementing Employee Component Interface
    private List<EmployeeComponent> subordinates;

    public Manager(String name, long id) {
        this.name = name;
        this.id = id;
        this.subordinates = new ArrayList<>();
    }

    // Mechanism to append or structure organizational branches
    public void addEmployee(EmployeeComponent emp) {
        subordinates.add(emp);
    }

    public void removeEmployee(EmployeeComponent emp) {
        subordinates.remove(emp);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager [ ID = " + id + ", Name = " + name + " ]");

        // Loop branches iteratively reflecting Composite Component interface uniform
        // methods
        for (EmployeeComponent subordinate : subordinates) {
            subordinate.showDetails();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Composite Pattern...");
        System.out.println("Applying structure to organizational chart components:\n");

        // Building the lower tier Leaf node workers
        Developer developer1 = new Developer("Alice Johnson", 100);
        Developer developer2 = new Developer("Bob Smith", 101);

        // Define Composite structure branch head node
        Manager manager1 = new Manager("Carol Davis", 200);

        // Map individual objects branching structurally within composition logic
        manager1.addEmployee(developer1);
        manager1.addEmployee(developer2);

        // A Manager might manage other managers structuring an aggregate composite
        Manager generalManager = new Manager("Eve Director", 900);
        generalManager.addEmployee(manager1);

        // Printing recursive structure
        generalManager.showDetails();
    }
}
