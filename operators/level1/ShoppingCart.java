/*
 * Program for Shopping Cart System
 * Demonstrates static, this, final, and instanceof keywords
 */
public class ShoppingCart {
    
    // Static variable shared by all products
    private static double discount = 10.0; // 10% discount
    
    // Instance variables
    private String productName;
    private double price;
    private int quantity;
    private final String productID; // Final - unique identifier

    /*
     * Constructor
     * Uses 'this' to initialize instance variables
     */
    public ShoppingCart(String productName, double price, int quantity, String productID) {
        this.productName = productName; // 'this' resolves ambiguity
        this.price = price;
        this.quantity = quantity;
        this.productID = productID; // Final variable initialization
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Calculate final price after discount
    public double calculateFinalPrice() {
        double total = price * quantity;
        double discountAmount = total * (discount / 100);
        return total - discountAmount;
    }

    // Display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.printf("Final Price: $%.2f\n", calculateFinalPrice());
        System.out.println("-------------------------");
    }

    // Safe processing using instanceof check
    public static void safeProcess(Object obj) {
        // Validate object is instance of ShoppingCart
        if (obj instanceof ShoppingCart) {
            ShoppingCart product = (ShoppingCart) obj;
            product.displayDetails();
        } else {
            System.out.println("Error: Object is not a ShoppingCart instance");
        }
    }

    public static void main(String[] args) {
        // Create products
        ShoppingCart p1 = new ShoppingCart("Laptop", 1000, 1, "PROD001");
        ShoppingCart p2 = new ShoppingCart("Mouse", 25, 2, "PROD002");
        
        // Display using instanceof check
        System.out.println("--- Product 1 ---");
        safeProcess(p1);
        
        System.out.println("--- Product 2 ---");
        safeProcess(p2);
        
        // Update discount
        System.out.println("--- Updating Discount ---");
        ShoppingCart.updateDiscount(15.0);
        
        // Display again with new discount
        System.out.println("\n--- After Discount Update ---");
        safeProcess(p1);
        
        // Test instanceof with invalid object
        System.out.println("--- Testing with invalid object ---");
        safeProcess("Invalid");
    }
}
