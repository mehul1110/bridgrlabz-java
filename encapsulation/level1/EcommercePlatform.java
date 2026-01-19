import java.util.ArrayList;

/*
 * Problem 2: E-Commerce Platform
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    // Abstract method
    public abstract double calculateDiscount();

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

// Concrete class 1
class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "GST 18%";
    }
}

// Concrete class 2
class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public String getTaxDetails() {
        return "GST 12%";
    }
}

// Concrete class 3
class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class EcommercePlatform {
    
    // Polymorphic method
    public static void calculateFinalPrice(Product product) {
        System.out.println("--- Product Details ---");
        product.displayProductInfo();
        
        double discount = product.calculateDiscount();
        double tax = 0;
        
        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
            System.out.println("Tax: " + ((Taxable) product).getTaxDetails());
        }
        
        double finalPrice = product.getPrice() + tax - discount;
        System.out.println("Discount: $" + discount);
        System.out.println("Tax: $" + tax);
        System.out.printf("Final Price: $%.2f\n", finalPrice);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        
        products.add(new Electronics("E001", "Laptop", 1000));
        products.add(new Clothing("C001", "Shirt", 50));
        products.add(new Groceries("G001", "Rice", 20));

        // Polymorphism in action
        for (Product product : products) {
            calculateFinalPrice(product);
        }
    }
}
