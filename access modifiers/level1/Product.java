/*
 * Program for Product Inventory
 * Demonstrates Instance vs Static variables
 */
public class Product {
    
    // Instance variables
    private String productName;
    private double price;

    // Static variable shared by all instances
    private static int totalProducts = 0;

    /*
     * Constructor
     * Initializes product and increments total count
     */
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment global count
    }

    // Display individual product details
    public void displayProductDetails() {
        System.out.println("Product: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("-------------------------");
    }

    // Static method to display total products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Smartphone", 800.00);
        Product p3 = new Product("Tablet", 450.00);

        // Display details
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        // Display static count
        Product.displayTotalProducts();
    }
}
