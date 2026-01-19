/*
 * Program for Car Rental System
 * Manages car rental details and cost calculation
 */
public class CarRental {
    
    // Instance variables
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0;

    /*
     * Parameterized Constructor
     * Sets up rental agreement details
     */
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Calculate total cost based on days and rate
    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    // Display rental information
    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Model: " + carModel);
        System.out.println("Days: " + rentalDays);
        System.out.printf("Total Cost: $%.2f\n", calculateTotalCost());
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Create rental 1
        CarRental r1 = new CarRental("Mike Ross", "Tesla Model 3", 5);
        r1.displayRentalDetails();

        // Create rental 2
        CarRental r2 = new CarRental("Rachel Zane", "BMW X5", 3);
        r2.displayRentalDetails();
    }
}
