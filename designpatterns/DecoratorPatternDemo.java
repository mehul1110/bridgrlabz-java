package designpatterns;

/**
 * Decorator Pattern implementation.
 * Adds behavior to objects dynamically without altering structure.
 */

// Define standard base Interface behavior
interface CoffeeBeverage {
    double getCost();

    String getDescription();
}

// Concrete component defining core structure execution
class SimpleCoffee implements CoffeeBeverage {
    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Simple Basic Coffee";
    }
}

// Abstract Decorator class wrapping the standard object
abstract class CoffeeDecorator implements CoffeeBeverage {
    protected CoffeeBeverage wrappedCoffeeComponent;

    public CoffeeDecorator(CoffeeBeverage coffeeRef) {
        this.wrappedCoffeeComponent = coffeeRef;
    }

    // Fallback logic delegates method call mapping properties
    @Override
    public double getCost() {
        return wrappedCoffeeComponent.getCost();
    }

    @Override
    public String getDescription() {
        return wrappedCoffeeComponent.getDescription();
    }
}

// Concrete Additions to decorate/augment functionality
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(CoffeeBeverage coffeeRef) {
        super(coffeeRef);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0; // Adding dynamic execution value to result
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", add Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(CoffeeBeverage coffeeRef) {
        super(coffeeRef);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0; // Augment Cost logic dynamically
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", add Sugar";
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Decorator Pattern...\n");

        System.out.println("Creating basic structure (Simple Coffee):");
        CoffeeBeverage orderObj = new SimpleCoffee();
        System.out.println("Details: " + orderObj.getDescription() + " | Cost: $" + orderObj.getCost());

        System.out.println("\nRuntime wrapping functionality (Add Milk):");
        orderObj = new MilkDecorator(orderObj);
        System.out.println("Details: " + orderObj.getDescription() + " | Cost: $" + orderObj.getCost());

        System.out.println("\nRuntime wrapping functionality (Add Sugar):");
        orderObj = new SugarDecorator(orderObj);
        System.out.println("Details: " + orderObj.getDescription() + " | Cost: $" + orderObj.getCost());
    }
}
