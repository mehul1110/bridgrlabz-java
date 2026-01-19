import java.util.Random;
import java.util.Scanner;

/*
 * Program to generate marksheet for students
 * Computes total, average, percentage, and assigns grades
 */
public class MarksScorecard {

    public static String gradeFromPercent(double p) {
        // Return grade based on percentage brackets
        if (p >= 80) return "A";
        if (p >= 70) return "B";
        if (p >= 60) return "C";
        if (p >= 50) return "D";
        if (p >= 40) return "E";
        // Return R for Fail
        return "R";
    }

    public static void main(String[] args) {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        // 2D Array to store marks for Physics, Chemistry, Math
        double[][] marks = new double[n][3];
        Random r = new Random();
        
        // Generate random marks for each student
        for (int i = 0; i < n; i++) {
            marks[i][0] = Math.round((50 + r.nextInt(51)) * 100.0) / 100.0; // Physics: 50-100
            marks[i][1] = Math.round((50 + r.nextInt(51)) * 100.0) / 100.0; // Chemistry: 50-100
            marks[i][2] = Math.round((50 + r.nextInt(51)) * 100.0) / 100.0; // Math: 50-100
        }
        
        // Display header
        System.out.println("Idx\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        
        // Compute statistics and display scorecard
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100.0;
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.0f\t%.2f\t%.2f\t%s\n", i+1, marks[i][0], marks[i][1], marks[i][2], total, avg, percent, gradeFromPercent(percent));
        }
        
        // Close Scanner
        sc.close();
    }
}
