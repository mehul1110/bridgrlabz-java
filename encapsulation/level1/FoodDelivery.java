import java.util.ArrayList;

/*
 * Problem 6: Online Food Delivery System
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Concrete class 1
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Special: 10% off";
    }
}

// Concrete class 2
class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge = 2.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Non-veg items have additional charges
        return (getPrice() + additionalCharge) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Offer: 5% off";
    }
}

public class FoodDelivery {
    
    // Polymorphic method
    public static void processOrder(FoodItem item) {
        System.out.println("--- Order Details ---");
        item.getItemDetails();
        
        double total = item.calculateTotalPrice();
        double discount = 0;
        
        if (item instanceof Discountable) {
            discount = ((Discountable) item).applyDiscount();
            System.out.println(((Discountable) item).getDiscountDetails());
        }
        
        System.out.println("Total: $" + total);
        System.out.println("Discount: $" + discount);
        System.out.printf("Final Amount: $%.2f\n", (total - discount));
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        ArrayList<FoodItem> order = new ArrayList<>();
        
        order.add(new VegItem("Paneer Tikka", 12.0, 2));
        order.add(new NonVegItem("Chicken Biryani", 15.0, 1));
        order.add(new VegItem("Veg Pulao", 10.0, 3));

        System.out.println("=== Food Order ===");
        for (FoodItem item : order) {
            processOrder(item);
        }
    }
}
