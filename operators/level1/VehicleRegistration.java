/*
 * Program for Vehicle Registration System
 * Demonstrates static, this, final, and instanceof keywords
 */
public class VehicleRegistration {
    
    // Static variable common for all vehicles
    private static double registrationFee = 500.0;
    
    // Instance variables
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber; // Final - unique identifier

    /*
     * Constructor
     * Uses 'this' to initialize instance variables
     */
    public VehicleRegistration(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName; // 'this' resolves ambiguity
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber; // Final variable initialization
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee);
    }

    // Display registration details
    public void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);
        System.out.println("-------------------------");
    }

    // Safe display using instanceof check
    public static void safeDisplay(Object obj) {
        // Check if object belongs to VehicleRegistration class
        if (obj instanceof VehicleRegistration) {
            VehicleRegistration vehicle = (VehicleRegistration) obj;
            vehicle.displayDetails();
        } else {
            System.out.println("Error: Object is not a VehicleRegistration instance");
        }
    }

    public static void main(String[] args) {
        // Create vehicles
        VehicleRegistration v1 = new VehicleRegistration("Alice Brown", "Sedan", "REG001");
        VehicleRegistration v2 = new VehicleRegistration("Bob Green", "SUV", "REG002");
        
        // Display using instanceof check
        System.out.println("--- Vehicle 1 ---");
        safeDisplay(v1);
        
        System.out.println("--- Vehicle 2 ---");
        safeDisplay(v2);
        
        // Update registration fee
        System.out.println("--- Updating Fee ---");
        VehicleRegistration.updateRegistrationFee(600.0);
        
        // Display again with new fee
        System.out.println("\n--- After Fee Update ---");
        safeDisplay(v1);
        
        // Test instanceof with invalid object
        System.out.println("--- Testing with invalid object ---");
        safeDisplay(new String("Not a vehicle"));
    }
}
