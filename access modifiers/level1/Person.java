/*
 * Program to demonstrate Copy Constructor
 * Creates a Person class and clones attributes using copy constructor
 */
public class Person {
    
    // Instance variables
    private String name;
    private int age;

    /*
     * Default Constructor
     * Initializes person with default values
     */
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    /*
     * Parameterized Constructor
     * Initializes person with specific values
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * Copy Constructor
     * Clones attributes from another Person object
     */
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Create original person
        System.out.println("--- Original Person ---");
        Person p1 = new Person("Alice", 30);
        p1.displayDetails();

        // Create copy of person
        System.out.println("--- Copied Person ---");
        Person p2 = new Person(p1);
        p2.displayDetails();
    }
}
