/*
 * Hybrid Inheritance - Sample Problem 2
 * Vehicle Management System
 * Demonstrates hybrid inheritance: Vehicle -> ElectricVehicle/PetrolVehicle + Refuelable interface
 */

// Base class
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// Subclass 1 - Electric Vehicle
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("--- Electric Vehicle ---");
        displayVehicleInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Action: Charging battery...");
        System.out.println("-------------------------");
    }
}

// Subclass 2 - Petrol Vehicle implementing interface
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelTankCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("--- Petrol Vehicle ---");
        displayVehicleInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
        System.out.println("Action: Refueling with petrol...");
        System.out.println("-------------------------");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        // Create different vehicle types
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 225, 75);
        PetrolVehicle bmw = new PetrolVehicle("BMW M5", 250, 68);

        // Perform operations
        tesla.charge();
        bmw.refuel();

        // Demonstrate interface polymorphism
        Refuelable refuelableVehicle = bmw;
        System.out.println("--- Using Interface Reference ---");
        refuelableVehicle.refuel();
    }
}
