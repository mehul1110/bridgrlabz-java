/*
 * Hierarchical Inheritance - Sample Problem 2
 * School System with Different Roles
 * Demonstrates hierarchical inheritance: Person -> Teacher, Student, Staff
 */

// Base class
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass 1
class Teacher extends Person {
    private String subject;
    private int experience;

    public Teacher(String name, int age, String subject, int experience) {
        super(name, age);
        this.subject = subject;
        this.experience = experience;
    }

    public void displayRole() {
        System.out.println("--- Teacher Profile ---");
        displayPersonInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Role: Educator");
        System.out.println("-------------------------");
    }
}

// Subclass 2
class Student extends Person {
    private String grade;
    private double gpa;

    public Student(String name, int age, String grade, double gpa) {
        super(name, age);
        this.grade = grade;
        this.gpa = gpa;
    }

    public void displayRole() {
        System.out.println("--- Student Profile ---");
        displayPersonInfo();
        System.out.println("Grade: " + grade);
        System.out.println("GPA: " + gpa);
        System.out.println("Role: Learner");
        System.out.println("-------------------------");
    }
}

// Subclass 3
class Staff extends Person {
    private String department;
    private String position;

    public Staff(String name, int age, String department, String position) {
        super(name, age);
        this.department = department;
        this.position = position;
    }

    public void displayRole() {
        System.out.println("--- Staff Profile ---");
        displayPersonInfo();
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Role: Support Staff");
        System.out.println("-------------------------");
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        // Create different roles
        Teacher teacher = new Teacher("Dr. Smith", 45, "Mathematics", 15);
        Student student = new Student("Alice Johnson", 16, "10th Grade", 3.8);
        Staff staff = new Staff("Bob Williams", 35, "Administration", "Office Manager");

        // Display all roles
        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}
