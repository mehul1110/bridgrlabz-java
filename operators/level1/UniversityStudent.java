/*
 * Program for University Student Management
 * Demonstrates static, this, final, and instanceof keywords
 */
public class UniversityStudent {
    
    // Static variables shared across all students
    private static String universityName = "State University";
    private static int totalStudents = 0;
    
    // Instance variables
    private String name;
    private final String rollNumber; // Final - cannot be changed
    private String grade;

    /*
     * Constructor
     * Uses 'this' to initialize instance variables
     */
    public UniversityStudent(String name, String rollNumber, String grade) {
        this.name = name; // 'this' resolves ambiguity
        this.rollNumber = rollNumber; // Final variable initialization
        this.grade = grade;
        totalStudents++; // Increment static counter
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated to: " + newGrade);
    }

    // Display student details
    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------");
    }

    // Safe operations using instanceof check
    public static void safeOperation(Object obj) {
        // Check if object is instance of UniversityStudent
        if (obj instanceof UniversityStudent) {
            UniversityStudent student = (UniversityStudent) obj;
            student.displayDetails();
        } else {
            System.out.println("Error: Object is not a UniversityStudent instance");
        }
    }

    public static void main(String[] args) {
        // Create students
        UniversityStudent s1 = new UniversityStudent("Alice Johnson", "ROLL001", "A");
        UniversityStudent s2 = new UniversityStudent("Bob Williams", "ROLL002", "B+");
        
        // Display using instanceof check
        System.out.println("--- Student 1 ---");
        safeOperation(s1);
        
        System.out.println("--- Student 2 ---");
        safeOperation(s2);
        
        // Update grade
        System.out.println("--- Updating Grade ---");
        s1.updateGrade("A+");
        safeOperation(s1);
        
        // Display total students
        UniversityStudent.displayTotalStudents();
        
        // Test instanceof with invalid object
        System.out.println("\n--- Testing with invalid object ---");
        safeOperation(100);
    }
}
