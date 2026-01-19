import java.util.ArrayList;

/*
 * Problem 3: Vehicle Rental System
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) {
            this.rentalRate = rentalRate;
        }
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    public void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate + "/day");
    }
}

// Concrete class 1
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 50.0; // Fixed insurance per rental
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy: " + policyNumber;
    }
}

// Concrete class 2
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% discount for bikes
    }

    @Override
    public double calculateInsurance() {
        return 20.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy: " + policyNumber;
    }
}

// Concrete class 3
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5; // 50% extra for trucks
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        vehicles.add(new Car("CAR001", 50, "POL123"));
        vehicles.add(new Bike("BIKE001", 20, "POL456"));
        vehicles.add(new Truck("TRUCK001", 100));

        int rentalDays = 3;

        // Polymorphism
        System.out.println("=== Rental Costs for " + rentalDays + " days ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
            System.out.println("Rental Cost: $" + vehicle.calculateRentalCost(rentalDays));
            
            if (vehicle instanceof Insurable) {
                Insurable insurable = (Insurable) vehicle;
                System.out.println("Insurance: $" + insurable.calculateInsurance());
                System.out.println(insurable.getInsuranceDetails());
            }
            System.out.println("-------------------------");
        }
    }
}
