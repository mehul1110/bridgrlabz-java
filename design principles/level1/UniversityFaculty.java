import java.util.ArrayList;

/*
 * Problem 5: University with Faculties and Departments (Composition and Aggregation)
 * Demonstrates composition for departments and aggregation for faculty
 */

// Faculty class - can exist independently
class Faculty {
    private String name;
    private String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayInfo() {
        System.out.println("  Faculty: " + name + " (Subject: " + subject + ")");
    }

    public String getName() {
        return name;
    }
}

// Department class - owned by university
class UniversityDepartment {
    private String deptName;
    private ArrayList<Faculty> facultyMembers;

    public UniversityDepartment(String deptName) {
        this.deptName = deptName;
        this.facultyMembers = new ArrayList<>();
    }

    public void assignFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
        System.out.println(faculty.getName() + " assigned to " + deptName);
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Faculty f : facultyMembers) {
            f.displayInfo();
        }
    }
}

// University class
public class UniversityFaculty {
    private String universityName;
    private ArrayList<UniversityDepartment> departments;

    public UniversityFaculty(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    // Create department (composition)
    public UniversityDepartment createDepartment(String deptName) {
        UniversityDepartment dept = new UniversityDepartment(deptName);
        departments.add(dept);
        System.out.println("Department '" + deptName + "' created in " + universityName);
        return dept;
    }

    // Display university structure
    public void displayUniversity() {
        System.out.println("\n=== " + universityName + " ===");
        for (UniversityDepartment dept : departments) {
            dept.displayDepartment();
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        // Create university
        UniversityFaculty university = new UniversityFaculty("State University");

        // Create departments (composition)
        UniversityDepartment csDept = university.createDepartment("Computer Science");
        UniversityDepartment mathDept = university.createDepartment("Mathematics");

        // Create faculty members (aggregation - exist independently)
        Faculty f1 = new Faculty("Dr. Smith", "Algorithms");
        Faculty f2 = new Faculty("Dr. Johnson", "Calculus");
        Faculty f3 = new Faculty("Dr. Williams", "Data Structures");

        // Assign faculty to departments
        csDept.assignFaculty(f1);
        csDept.assignFaculty(f3);
        mathDept.assignFaculty(f2);

        // Display university
        university.displayUniversity();

        // Faculty exists independently
        System.out.println("\n--- Independent Faculty ---");
        f1.displayInfo();

        // Deleting university deletes departments but not faculty
        System.out.println("\nUniversity deleted - departments removed, faculty remains");
        university = null;
        f1.displayInfo();
    }
}
