/*
 * Utility class to perform various unit conversions
 * Supports Distance, Temperature, Weight, and Volume conversions
 */
public class UnitConverter {

    // Distance Conversions
    public static double convertKmToMiles(double km) {
        // Formula: 1 km approx 0.621371 miles
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        // Formula: 1 mile approx 1.60934 km
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        // Formula: 1 meter approx 3.28084 feet
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        // Formula: 1 foot = 0.3048 meters
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    // Yards/Feet/Inches/Cm Conversions
    public static double convertYardsToFeet(double yards) {
        // Formula: 1 yard = 3 feet
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        // Formula: 1 foot = 1/3 yards
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        // Formula: 1 meter approx 39.3701 inches
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        // Formula: 1 inch = 0.0254 meters
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        // Formula: 1 inch = 2.54 cm
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    // Temperature Conversions
    public static double convertFahrenheitToCelsius(double f) {
        // Formula: (F - 32) * 5/9
        return (f - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        // Formula: (C * 9/5) + 32
        return (c * 9 / 5) + 32;
    }

    // Weight Conversions
    public static double convertPoundsToKilograms(double pounds) {
        // Formula: 1 pound approx 0.453592 kg
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kg) {
        // Formula: 1 kg approx 2.20462 pounds
        double kilograms2pounds = 2.20462;
        return kg * kilograms2pounds;
    }

    // Volume Conversions
    public static double convertGallonsToLiters(double gallons) {
        // Formula: 1 gallon approx 3.78541 liters
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        // Formula: 1 liter approx 0.264172 gallons
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
}
