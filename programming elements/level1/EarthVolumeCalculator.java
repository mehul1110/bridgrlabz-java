/*
 * This program calculates the volume of the Earth
 * using the mathematical formula for a sphere
 */
public class EarthVolumeCalculator {

    public static void main(String[] args) {

        // Store the radius value for calculation
        double radiusKm = 6378;

        // Use the built-in mathematical constant
        double pi = Math.PI;

        // Calculate volume using arithmetic operations and power function
        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);

        // Define conversion factor for unit conversion
        double kmToMiles = 1.0 / 1.6; // 1 km = 1/1.6 miles

        // Convert radius from kilometers to miles
        double radiusMiles = radiusKm * kmToMiles;

        // Recalculate volume after unit conversion
        double volumeMiles3 = (4.0 / 3.0) * pi * Math.pow(radiusMiles, 3);

        // Display both calculated volumes
        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeKm3 +
                        " and cubic miles is " + volumeMiles3
        );
    }
}
