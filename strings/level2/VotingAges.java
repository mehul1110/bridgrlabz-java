import java.util.Scanner;

public class VotingAges {
    public static int[] randomAges(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = 10 + (int)(Math.random() * 90); // 10..99
        return a;
    }

    public static String[][] ageVoteTable(int[] ages) {
        String[][] out = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            out[i][0] = String.valueOf(ages[i]);
            boolean can = ages[i] >= 18;
            if (ages[i] < 0) can = false;
            out[i][1] = String.valueOf(can);
        }
        return out;
    }

    public static void display(String[][] table) {
        System.out.printf("%-8s %s%n", "Age", "CanVote");
        for (String[] r : table) System.out.printf("%-8s %s%n", r[0], r[1]);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of students: ");
            int n = sc.nextInt();
            int[] ages = randomAges(n);
            String[][] table = ageVoteTable(ages);
            display(table);
        }
    }
}
