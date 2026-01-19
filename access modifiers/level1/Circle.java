/*
 * Program to demonstrate Constructor Chaining
 * Creates a Circle class with radius attribute
 * Uses this() to chain constructors
 */
public class Circle {
    
    // Instance variable
    private double radius;

    /*
     * Default Constructor
     * Chains to parameterized constructor with default radius
     */
    public Circle() {
        this(1.0); // Chain to single argument constructor
        System.out.println("Default Constructor called");
    }

    /*
     * Parameterized Constructor
     * Initializes circle with specific radius
     */
    public Circle(double radius) {
        this.radius = radius;
        System.out.println("Parameterized Constructor called");
    }

    // Calculate Area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Calculate Circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.printf("Area: %.2f\n", calculateArea());
        System.out.printf("Circumference: %.2f\n", calculateCircumference());
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Create circle using default constructor
        System.out.println("--- Default Circle ---");
        Circle c1 = new Circle();
        c1.displayDetails();

        // Create circle using parameterized constructor
        System.out.println("--- Parameterized Circle ---");
        Circle c2 = new Circle(5.5);
        c2.displayDetails();
    }
}
