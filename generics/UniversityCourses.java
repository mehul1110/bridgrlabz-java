package generics;

import java.util.Arrays;
import java.util.List;

/**
 * Multi-Level University Course Management System.
 * Demonstrates Generic Classes, Wildcards, and Bounded Type Parameters.
 */
public class UniversityCourses {

    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Calculus 101", new ExamCourse());
        Course<AssignmentCourse> history = new Course<>("World History", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Quantum Mechanics", new ResearchCourse());

        List<Course<?>> courses = Arrays.asList(math, history, physics);

        System.out.println("--- University Courses ---");
        displayCourses(courses);
    }

    /**
     * Helper method to display course details using wildcards.
     * Accepts a list of any Course type.
     *
     * @param courses List of courses.
     */
    public static void displayCourses(List<Course<?>> courses) {
        for (Course<?> course : courses) {
            System.out.println(course);
        }
    }
}

/**
 * Abstract class representing a type of course evaluation.
 */
abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    @Override
    public String toString() {
        return evaluationMethod;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research Based");
    }
}

/**
 * Generic Course class.
 * T is restricted to subclasses of CourseType.
 *
 * @param <T> The type of course evaluation.
 */
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " | Type: " + courseType;
    }
}
