import java.util.*;

public class FriendsStats {
    public static int youngestIndex(int[] ages) {
        int minIdx = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIdx]) minIdx = i;
        }
        return minIdx;
    }

    public static int tallestIndex(double[] heights) {
        int maxIdx = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height (in cm) of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        int y = youngestIndex(ages);
        int t = tallestIndex(heights);
        System.out.println("Youngest: " + names[y] + " (age=" + ages[y] + ")");
        System.out.println("Tallest: " + names[t] + " (height=" + heights[t] + " cm)");
    }
}
