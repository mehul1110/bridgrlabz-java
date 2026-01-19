/*
 * Program for Vehicle Registration
 * Demonstrates static methods for updating shared data
 */
public class Vehicle {
    
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Static variable for registration fee
    private static double registrationFee = 100.0;

    /*
     * Constructor
     * Initializes vehicle details
     */
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Type: " + vehicleType);
        System.out.println("Fee: $" + registrationFee);
        System.out.println("-------------------------");
    }

    // Static method to update fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Fee updated to: $" + registrationFee);
    }

    public static void main(String[] args) {
        // Create vehicles
        Vehicle v1 = new Vehicle("Alice", "Sedan");
        Vehicle v2 = new Vehicle("Bob", "SUV");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Update fee
        Vehicle.updateRegistrationFee(150.0);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
