import java.util.ArrayList;

/*
 * Problem 4: School and Students with Courses (Association and Aggregation)
 * Demonstrates many-to-many relationship between students and courses
 */

// Course class
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("  - " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class
class Student {
    private String name;
    private String rollNumber;
    private ArrayList<Course> courses;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void viewCourses() {
        System.out.println("\nStudent: " + name + " (" + rollNumber + ")");
        System.out.println("Enrolled Courses:");
        for (Course c : courses) {
            System.out.println("  - " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

// School class
public class SchoolStudents {
    private String schoolName;
    private ArrayList<Student> students;

    public SchoolStudents(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println(student.getName() + " added to " + schoolName);
    }

    public static void main(String[] args) {
        // Create school
        SchoolStudents school = new SchoolStudents("City High School");

        // Create students
        Student s1 = new Student("Alice", "S001");
        Student s2 = new Student("Bob", "S002");

        // Add students to school (aggregation)
        school.addStudent(s1);
        school.addStudent(s2);

        // Create courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course chemistry = new Course("Chemistry");

        // Enroll students in courses (association - many-to-many)
        s1.enrollInCourse(math);
        s1.enrollInCourse(physics);
        s2.enrollInCourse(physics);
        s2.enrollInCourse(chemistry);

        // View student courses
        s1.viewCourses();
        s2.viewCourses();

        // View course enrollments
        System.out.println("\n--- Course Enrollments ---");
        physics.displayEnrolledStudents();
    }
}
