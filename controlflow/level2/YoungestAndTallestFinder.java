import java.util.Scanner;

/*
 * Program to determine the youngest and tallest among three friends (Amar, Akbar, Anthony)
 */
public class YoungestAndTallestFinder {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);

        // Get Amar's details
        System.out.print("Enter age of Amar: ");
        int ageAmar = input.nextInt();
        System.out.print("Enter height of Amar (cm): ");
        double heightAmar = input.nextDouble();

        // Get Akbar's details
        System.out.print("Enter age of Akbar: ");
        int ageAkbar = input.nextInt();
        System.out.print("Enter height of Akbar (cm): ");
        double heightAkbar = input.nextDouble();

        // Get Anthony's details
        System.out.print("Enter age of Anthony: ");
        int ageAnthony = input.nextInt();
        System.out.print("Enter height of Anthony (cm): ");
        double heightAnthony = input.nextDouble();

        // Determine youngest
        int youngestAge = ageAmar;
        String youngest = "Amar";
        if (ageAkbar < youngestAge) { youngestAge = ageAkbar; youngest = "Akbar"; }
        if (ageAnthony < youngestAge) { youngestAge = ageAnthony; youngest = "Anthony"; }

        // Determine tallest
        double tallestHeight = heightAmar;
        String tallest = "Amar";
        if (heightAkbar > tallestHeight) { tallestHeight = heightAkbar; tallest = "Akbar"; }
        if (heightAnthony > tallestHeight) { tallestHeight = heightAnthony; tallest = "Anthony"; }

        // Display results
        System.out.println("Youngest friend: " + youngest + " with age " + youngestAge);
        System.out.println("Tallest friend: " + tallest + " with height " + tallestHeight + " cm");

        // Close Scanner
        input.close();
    }
}