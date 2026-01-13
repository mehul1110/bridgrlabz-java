import java.util.Random;
import java.util.Scanner;

public class MarksScorecard {
    // Q12: take marks in 3 subjects, compute total, avg, percentage and grade
    public static String gradeFromPercent(double p) {
        if (p >= 80) return "A";
        if (p >= 70) return "B";
        if (p >= 60) return "C";
        if (p >= 50) return "D";
        if (p >= 40) return "E";
        return "R";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        double[][] marks = new double[n][3];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            marks[i][0] = Math.round((50 + r.nextInt(51)) * 100.0) / 100.0; // physics
            marks[i][1] = Math.round((50 + r.nextInt(51)) * 100.0) / 100.0; // chemistry
            marks[i][2] = Math.round((50 + r.nextInt(51)) * 100.0) / 100.0; // math
        }
        System.out.println("Idx\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100.0;
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.0f\t%.2f\t%.2f\t%s\n", i+1, marks[i][0], marks[i][1], marks[i][2], total, avg, percent, gradeFromPercent(percent));
        }
        sc.close();
    }
}
