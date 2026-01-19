import java.util.Scanner;

/*
 * Program to calculate grades for students based on marks in three subjects
 * Uses multiple 1D arrays to store marks and results
 */
public class MarksGrades {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = in.nextInt();
        
        // Arrays for inputs and outputs
        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percent = new double[n];
        String[] grade = new String[n];

        // Loop to process each student
        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks for student " + (i+1) + ": ");
            physics[i] = in.nextDouble();
            System.out.print("Enter chemistry marks for student " + (i+1) + ": ");
            chemistry[i] = in.nextDouble();
            System.out.print("Enter maths marks for student " + (i+1) + ": ");
            maths[i] = in.nextDouble();
            
            // Calculate percentage
            percent[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            double p = percent[i];
            
            // Determine grade
            if (p >= 80) grade[i] = "A";
            else if (p >= 70) grade[i] = "B";
            else if (p >= 60) grade[i] = "C";
            else if (p >= 50) grade[i] = "D";
            else if (p >= 40) grade[i] = "E";
            else grade[i] = "R";
        }

        // Display scorecard
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: %%=%.2f Grade=%s\n", i+1, percent[i], grade[i]);
        }
        
        // Close Scanner
        in.close();
    }
}
