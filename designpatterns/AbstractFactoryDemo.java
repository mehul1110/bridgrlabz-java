package designpatterns;

/**
 * Abstract Factory Pattern implementation.
 * Provides an interface for creating families of related objects.
 */

// Define generic Car Interface
interface Car {
    void drive();
}

// Define generic Bike Interface
interface Bike {
    void ride();
}

// Concrete Car implementations
class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a smooth Sedan Car.");
    }
}

class SUV implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a rugged SUV Car.");
    }
}

// Concrete Bike implementations
class SportsBike implements Bike {
    @Override
    public void ride() {
        System.out.println("Riding a fast Sports Bike.");
    }
}

class NormalBike implements Bike {
    @Override
    public void ride() {
        System.out.println("Riding a comfortable Normal Bike.");
    }
}

// Abstract factory
interface VehicleFactory {
    Car createCar(String type);

    Bike createBike(String type);
}

// Concrete Factory for Cars
class CarFactory implements VehicleFactory {
    @Override
    public Car createCar(String type) {
        if (type.equalsIgnoreCase("SEDAN")) {
            return new Sedan();
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUV();
        }
        return null;
    }

    @Override
    public Bike createBike(String type) {
        return null; // Car factory doesn't produce bikes
    }
}

// Concrete Factory for Bikes
class BikeFactory implements VehicleFactory {
    @Override
    public Car createCar(String type) {
        return null; // Bike factory doesn't produce cars
    }

    @Override
    public Bike createBike(String type) {
        if (type.equalsIgnoreCase("SPORTS")) {
            return new SportsBike();
        } else if (type.equalsIgnoreCase("NORMAL")) {
            return new NormalBike();
        }
        return null;
    }
}

// Example usage
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("Testing Abstract Factory Pattern...\n");

        // Factory for Cars
        VehicleFactory carFactory = new CarFactory();
        Car mySUV = carFactory.createCar("SUV");
        if (mySUV != null) {
            mySUV.drive();
        }

        // Factory for Bikes
        VehicleFactory bikeFactory = new BikeFactory();
        Bike mySportsBike = bikeFactory.createBike("SPORTS");
        if (mySportsBike != null) {
            mySportsBike.ride();
        }
    }
}
