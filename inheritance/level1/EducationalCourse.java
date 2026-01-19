/*
 * Multilevel Inheritance - Sample Problem 2
 * Educational Course Hierarchy
 * Demonstrates multilevel inheritance: Course -> OnlineCourse -> PaidOnlineCourse
 */

// Base class
class Course {
    protected String courseName;
    protected int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// First level subclass
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // Call parent constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public void displayOnlineInfo() {
        displayCourseInfo(); // Call parent method
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Second level subclass
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded); // Call parent constructor
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    public void displayFullInfo() {
        System.out.println("--- Course Details ---");
        displayOnlineInfo(); // Call parent method
        System.out.println("Original Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.printf("Final Fee: $%.2f\n", calculateFinalFee());
        System.out.println("-------------------------");
    }
}

public class EducationalCourse {
    public static void main(String[] args) {
        // Create courses at different levels
        Course basic = new Course("Introduction to Programming", 20);
        OnlineCourse online = new OnlineCourse("Web Development", 40, "Udemy", true);
        PaidOnlineCourse premium = new PaidOnlineCourse("Advanced Java", 60, "Coursera", true, 199.99, 20);

        // Display information
        System.out.println("--- Basic Course ---");
        basic.displayCourseInfo();

        System.out.println("\n--- Online Course ---");
        online.displayOnlineInfo();

        System.out.println("\n--- Premium Course ---");
        premium.displayFullInfo();
    }
}
