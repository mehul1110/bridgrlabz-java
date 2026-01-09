import java.util.Scanner;

public class MarksGrades2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = in.nextInt();
        double[][] marks = new double[n][3]; // physics, chemistry, maths
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks for student " + (i+1) + ": ");
            marks[i][0] = in.nextDouble();
            System.out.print("Enter chemistry marks for student " + (i+1) + ": ");
            marks[i][1] = in.nextDouble();
            System.out.print("Enter maths marks for student " + (i+1) + ": ");
            marks[i][2] = in.nextDouble();
            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            double p = percent[i];
            if (p >= 80) grade[i] = "A";
            else if (p >= 70) grade[i] = "B";
            else if (p >= 60) grade[i] = "C";
            else if (p >= 50) grade[i] = "D";
            else if (p >= 40) grade[i] = "E";
            else grade[i] = "R";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: %%=%.2f Grade=%s\n", i+1, percent[i], grade[i]);
        }
        in.close();
    }
}
