import java.util.ArrayList;

/*
 * Problem 8: University Management System
 * Demonstrates association and aggregation with students, professors, and courses
 */

// Course class
class UniversityCourse {
    private String courseName;
    private String courseCode;
    private Professor assignedProfessor;
    private ArrayList<UniversityStudent> enrolledStudents;

    public UniversityCourse(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.assignedProfessor = professor;
        System.out.println("Prof. " + professor.getName() + " assigned to " + courseName);
    }

    public void enrollStudent(UniversityStudent student) {
        enrolledStudents.add(student);
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse: " + courseName + " (" + courseCode + ")");
        if (assignedProfessor != null) {
            System.out.println("Professor: " + assignedProfessor.getName());
        }
        System.out.println("Enrolled Students: " + enrolledStudents.size());
        for (UniversityStudent s : enrolledStudents) {
            System.out.println("  - " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class
class UniversityStudent {
    private String name;
    private String studentID;
    private ArrayList<UniversityCourse> courses;

    public UniversityStudent(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.courses = new ArrayList<>();
    }

    // Communication method
    public void enrollCourse(UniversityCourse course) {
        courses.add(course);
        course.enrollStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void viewCourses() {
        System.out.println("\n" + name + "'s Courses:");
        for (UniversityCourse c : courses) {
            System.out.println("  - " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

// Professor class
class Professor {
    private String name;
    private String department;
    private ArrayList<UniversityCourse> courses;

    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
        this.courses = new ArrayList<>();
    }

    public void teachCourse(UniversityCourse course) {
        courses.add(course);
        course.assignProfessor(this);
    }

    public void viewCourses() {
        System.out.println("\nProf. " + name + " teaches:");
        for (UniversityCourse c : courses) {
            System.out.println("  - " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

// University Management System
public class UniversityManagement {
    private String universityName;
    private ArrayList<UniversityStudent> students;
    private ArrayList<Professor> professors;
    private ArrayList<UniversityCourse> courses;

    public UniversityManagement(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(UniversityStudent student) {
        students.add(student);
        System.out.println(student.getName() + " added to " + universityName);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
        System.out.println("Prof. " + professor.getName() + " joined " + universityName);
    }

    public void addCourse(UniversityCourse course) {
        courses.add(course);
        System.out.println("Course " + course.getCourseName() + " added");
    }

    public static void main(String[] args) {
        // Create university
        UniversityManagement university = new UniversityManagement("Tech University");

        // Create students
        UniversityStudent s1 = new UniversityStudent("Alice", "S001");
        UniversityStudent s2 = new UniversityStudent("Bob", "S002");

        // Create professors
        Professor p1 = new Professor("Dr. Smith", "Computer Science");
        Professor p2 = new Professor("Dr. Johnson", "Mathematics");

        // Create courses
        UniversityCourse c1 = new UniversityCourse("Data Structures", "CS101");
        UniversityCourse c2 = new UniversityCourse("Calculus", "MATH101");

        // Add to university
        university.addStudent(s1);
        university.addStudent(s2);
        university.addProfessor(p1);
        university.addProfessor(p2);
        university.addCourse(c1);
        university.addCourse(c2);

        // Assign professors to courses
        p1.teachCourse(c1);
        p2.teachCourse(c2);

        // Students enroll in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // Display information
        s1.viewCourses();
        p1.viewCourses();
        c1.displayCourseInfo();
    }
}
