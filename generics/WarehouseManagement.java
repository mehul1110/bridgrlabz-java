package generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Smart Warehouse Management System.
 * Demonstrates Generic Classes, Bounded Type Parameters, and Wildcards.
 */
public class WarehouseManagement {

    public static void main(String[] args) {
        // Create storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 999.99, 24));
        electronicsStorage.addItem(new Electronics("Smartphone", 699.50, 12));

        // Create storage for Groceries
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Apple", 1.20, LocalDate.now().plusWeeks(2)));
        groceryStorage.addItem(new Groceries("Milk", 0.99, LocalDate.now().plusDays(5)));

        // Create storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Desk", 150.00, "Wood"));
        furnitureStorage.addItem(new Furniture("Chair", 85.00, "Plastic"));

        // Display items using wildcard method
        System.out.println("\n--- Electronics Inventory ---");
        displayInventory(electronicsStorage.getItems());

        System.out.println("\n--- Grocery Inventory ---");
        displayInventory(groceryStorage.getItems());

        System.out.println("\n--- Furniture Inventory ---");
        displayInventory(furnitureStorage.getItems());
    }

    /**
     * Wildcard method to display all items in a list.
     * Uses Upper Bounded Wildcard (? extends WarehouseItem) to accept any list of
     * WarehouseItem subclasses.
     *
     * @param items List of items to display.
     */
    public static void displayInventory(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

/**
 * Abstract class representing a generic item in the warehouse.
 * All specific item types like Electronics, Groceries, etc., will extend this
 * class.
 */
abstract class WarehouseItem {
    private String name;
    private double price;

    /**
     * Constructor to initialize the warehouse item.
     *
     * @param name  The name of the item.
     * @param price The price of the item.
     */
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Price: $" + price;
    }
}

/**
 * Represents an Electronics item in the warehouse.
 */
class Electronics extends WarehouseItem {
    private int warrantyPeriod; // in months

    public Electronics(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyPeriod + " months";
    }
}

/**
 * Represents a Grocery item in the warehouse.
 */
class Groceries extends WarehouseItem {
    private LocalDate expirationDate;

    public Groceries(String name, double price, LocalDate expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Expires: " + expirationDate;
    }
}

/**
 * Represents a Furniture item in the warehouse.
 */
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}

/**
 * Generic class Storage to store warehouse items securely.
 * Restricted to subtypes of WarehouseItem using bounded type parameters.
 *
 * @param <T> The type of item to be stored, extending WarehouseItem.
 */
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName());
    }

    public List<T> getItems() {
        return items;
    }
}
