import java.util.Scanner;

/*
 * Program to calculate average marks and determine grade
 */
public class GradeCalculator {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter marks for Physics: ");
        double p = in.nextDouble();
        System.out.print("Enter marks for Chemistry: ");
        double c = in.nextDouble();
        System.out.print("Enter marks for Maths: ");
        double m = in.nextDouble();

        // Calculate average
        double total = p + c + m;
        double avg = total / 3.0;

        String grade;
        // Determine grade based on average
        if (avg >= 80) grade = "A";
        else if (avg >= 70) grade = "B";
        else if (avg >= 60) grade = "C";
        else if (avg >= 50) grade = "D";
        else if (avg >= 40) grade = "E";
        else grade = "R";

        // Display results
        System.out.printf("Average: %.2f\nGrade: %s\n", avg, grade);
        
        // Close Scanner
        in.close();
    }
}
