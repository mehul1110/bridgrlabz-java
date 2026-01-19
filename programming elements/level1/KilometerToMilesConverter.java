/*
 * This program converts a distance value
 * from kilometers to miles using arithmetic division
 */
public class KilometerToMilesConverter {

    public static void main(String[] args) {

        // Perform unit conversion using division
        double km = 10.8;
        double miles = km / 1.6;

        // Display the converted distance
        System.out.println("The distance " + km + " km in miles is " + miles);
    }
}
