/*
 * Hybrid Inheritance - Sample Problem 1
 * Restaurant Management System
 * Demonstrates hybrid inheritance using interfaces: Person -> Chef/Waiter + Worker interface
 */

// Base class
class Person {
    protected String name;
    protected String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Subclass 1 implementing interface
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, String id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("--- Chef Duties ---");
        displayPersonInfo();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Preparing meals, managing kitchen, creating recipes");
        System.out.println("-------------------------");
    }
}

// Subclass 2 implementing interface
class Waiter extends Person implements Worker {
    private int tablesAssigned;

    public Waiter(String name, String id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("--- Waiter Duties ---");
        displayPersonInfo();
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Taking orders, serving food, customer service");
        System.out.println("-------------------------");
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        // Create restaurant workers
        Chef chef = new Chef("Gordon Ramsay", "CH001", "Italian Cuisine");
        Waiter waiter = new Waiter("John Smith", "WT001", 5);

        // Perform duties
        chef.performDuties();
        waiter.performDuties();

        // Demonstrate polymorphism with interface
        Worker worker1 = chef;
        Worker worker2 = waiter;

        System.out.println("--- All Workers ---");
        worker1.performDuties();
        worker2.performDuties();
    }
}
