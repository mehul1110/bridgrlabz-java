/*
 * Program for Online Course Management
 * Demonstrates static fields for shared data
 */
public class Course {
    
    // Instance variables
    private String courseName;
    private int durationMonths;
    private double fee;

    // Static variable common to all courses
    private static String instituteName = "Trend Academy";

    /*
     * Constructor
     * Initializes course details
     */
    public Course(String courseName, int durationMonths, double fee) {
        this.courseName = courseName;
        this.durationMonths = durationMonths;
        this.fee = fee;
    }

    // Display course info
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course: " + courseName);
        System.out.println("Fee: $" + fee);
        System.out.println("-------------------------");
    }

    // Static method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute Name Updated to: " + instituteName);
    }

    public static void main(String[] args) {
        // Create courses
        Course c1 = new Course("Java", 4, 500);
        Course c2 = new Course("Web Dev", 3, 300);

        // Display initial
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update static field
        Course.updateInstituteName("Tech Scholars");

        // Display updated
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
