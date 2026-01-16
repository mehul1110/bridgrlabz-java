import java.util.Scanner;

public class YoungestAndTallestFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int ageAmar = input.nextInt();
        System.out.print("Enter height of Amar (cm): ");
        double heightAmar = input.nextDouble();

        System.out.print("Enter age of Akbar: ");
        int ageAkbar = input.nextInt();
        System.out.print("Enter height of Akbar (cm): ");
        double heightAkbar = input.nextDouble();

        System.out.print("Enter age of Anthony: ");
        int ageAnthony = input.nextInt();
        System.out.print("Enter height of Anthony (cm): ");
        double heightAnthony = input.nextDouble();

        // youngest
        int youngestAge = ageAmar;
        String youngest = "Amar";
        if (ageAkbar < youngestAge) { youngestAge = ageAkbar; youngest = "Akbar"; }
        if (ageAnthony < youngestAge) { youngestAge = ageAnthony; youngest = "Anthony"; }

        // tallest
        double tallestHeight = heightAmar;
        String tallest = "Amar";
        if (heightAkbar > tallestHeight) { tallestHeight = heightAkbar; tallest = "Akbar"; }
        if (heightAnthony > tallestHeight) { tallestHeight = heightAnthony; tallest = "Anthony"; }

        System.out.println("Youngest friend: " + youngest + " with age " + youngestAge);
        System.out.println("Tallest friend: " + tallest + " with height " + tallestHeight + " cm");

        input.close();
    }
}