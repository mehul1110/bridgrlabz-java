import java.util.Scanner;

public class MarksGrades {
    public static int[][] randomPCM(int n) {
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) for (int j = 0; j < 3; j++) a[i][j] = (int)(Math.random()*101); // 0..100
        return a;
    }

    public static String[][] totalsAndPercentages(int[][] pcm) {
        int n = pcm.length; String[][] out = new String[n][4];
        for (int i = 0; i < n; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = Math.round((total/3.0)*100.0)/100.0;
            double pct = Math.round((total/300.0*100.0)*100.0)/100.0;
            out[i][0] = String.valueOf(total);
            out[i][1] = String.valueOf(avg);
            out[i][2] = String.valueOf(pct);
            out[i][3] = gradeFor(pct);
        }
        return out;
    }

    public static String gradeFor(double pct) {
        if (pct >= 80) return "A";
        if (pct >= 70) return "B";
        if (pct >= 60) return "C";
        if (pct >= 50) return "D";
        if (pct >= 40) return "E";
        return "R";
    }

    public static void display(int[][] pcm, String[][] stats) {
        System.out.printf("%-6s %-6s %-6s %-6s %-8s %-10s %s%n", "Phy", "Chem", "Math", "Total", "Average", "Percent", "Grade");
        for (int i = 0; i < pcm.length; i++) {
            System.out.printf("%-6d %-6d %-6d %-6s %-8s %-10s %s%n",
                pcm[i][0], pcm[i][1], pcm[i][2], stats[i][0], stats[i][1], stats[i][2], stats[i][3]);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of students: ");
            int n = sc.nextInt();
            int[][] pcm = randomPCM(n);
            String[][] stats = totalsAndPercentages(pcm);
            display(pcm, stats);
        }
    }
}
