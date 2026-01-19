/*
 * Program for University Management System
 * Demonstrates public, private, protected access modifiers
 */
public class Student {
    
    public int rollNumber;
    protected String name;
    private double cgpa;

    /*
     * Constructor
     */
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Public method to get private CGPA
    public double getCgpa() {
        return cgpa;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Roll: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }

    public static void main(String[] args) {
        Student s = new Student(101, "John", 3.5);
        s.displayDetails();
        
        System.out.println("--- Postgraduate ---");
        PostgraduateStudent pg = new PostgraduateStudent(102, "Ajay", 3.8);
        pg.displayPostGradDetails();
    }
}

/*
 * Subclass to demonstrate protected access
 */
class PostgraduateStudent extends Student {
    
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    public void displayPostGradDetails() {
        // Access public
        System.out.println("PG Roll: " + rollNumber);
        // Access protected
        System.out.println("PG Name: " + name);
        // Access private via public method
        System.out.println("PG CGPA: " + getCgpa());
    }
}
