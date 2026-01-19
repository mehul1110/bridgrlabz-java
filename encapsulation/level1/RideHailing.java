import java.util.ArrayList;

/*
 * Problem 8: Ride-Hailing Application
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class
abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        }
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate: $" + ratePerKm + "/km");
    }
}

// Concrete class 1
class RideCar extends RideVehicle implements GPS {
    private String currentLocation;

    public RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 5.0; // Base fare $5
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Location updated to: " + newLocation);
    }
}

// Concrete class 2
class RideBike extends RideVehicle implements GPS {
    private String currentLocation;

    public RideBike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 2.0; // Base fare $2
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Location updated to: " + newLocation);
    }
}

// Concrete class 3
class RideAuto extends RideVehicle implements GPS {
    private String currentLocation;

    public RideAuto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 3.0; // Base fare $3
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Location updated to: " + newLocation);
    }
}

public class RideHailing {
    
    // Polymorphic method
    public static void processRide(RideVehicle vehicle, double distance) {
        System.out.println("--- Ride Details ---");
        vehicle.getVehicleDetails();
        
        if (vehicle instanceof GPS) {
            GPS gps = (GPS) vehicle;
            gps.updateLocation("Downtown");
            System.out.println("Current Location: " + gps.getCurrentLocation());
        }
        
        double fare = vehicle.calculateFare(distance);
        System.out.println("Distance: " + distance + " km");
        System.out.printf("Fare: $%.2f\n", fare);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        ArrayList<RideVehicle> vehicles = new ArrayList<>();
        
        vehicles.add(new RideCar("CAR001", "John", 2.5));
        vehicles.add(new RideBike("BIKE001", "Mike", 1.5));
        vehicles.add(new RideAuto("AUTO001", "Sarah", 2.0));

        double rideDistance = 10.0;

        // Polymorphism
        System.out.println("=== Ride Fares for " + rideDistance + " km ===");
        for (RideVehicle vehicle : vehicles) {
            processRide(vehicle, rideDistance);
        }
    }
}
