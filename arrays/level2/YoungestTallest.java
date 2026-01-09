import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] names = {"Amar","Akbar","Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = in.nextInt();
            System.out.print("Enter height (cm) for " + names[i] + ": ");
            heights[i] = in.nextDouble();
        }

        int minAgeIdx = 0;
        for (int i = 1; i < 3; i++) if (ages[i] < ages[minAgeIdx]) minAgeIdx = i;
        int maxHeightIdx = 0;
        for (int i = 1; i < 3; i++) if (heights[i] > heights[maxHeightIdx]) maxHeightIdx = i;

        System.out.println("Youngest: " + names[minAgeIdx] + " (" + ages[minAgeIdx] + ")");
        System.out.println("Tallest: " + names[maxHeightIdx] + " (" + heights[maxHeightIdx] + " cm)");
        in.close();
    }
}
