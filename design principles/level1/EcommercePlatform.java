import java.util.ArrayList;

/*
 * Problem 7: E-commerce Platform with Orders, Customers, and Products
 * Demonstrates communication and object relationships in e-commerce
 */

// Product class
class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println("  " + productName + " - $" + price);
    }
}

// Order class
class Order {
    private String orderID;
    private ArrayList<Product> products;
    private double totalAmount;

    public Order(String orderID) {
        this.orderID = orderID;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
        System.out.println(product.getProductName() + " added to order " + orderID);
    }

    public void displayOrder() {
        System.out.println("\nOrder ID: " + orderID);
        System.out.println("Products:");
        for (Product p : products) {
            p.displayInfo();
        }
        System.out.println("Total: $" + totalAmount);
    }

    public String getOrderID() {
        return orderID;
    }
}

// Customer class
class EcomCustomer {
    private String name;
    private String customerID;
    private ArrayList<Order> orders;

    public EcomCustomer(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
        this.orders = new ArrayList<>();
    }

    public Order placeOrder(String orderID) {
        Order order = new Order(orderID);
        orders.add(order);
        System.out.println("\n" + name + " placed order " + orderID);
        return order;
    }

    public void viewOrders() {
        System.out.println("\n=== " + name + "'s Orders ===");
        for (Order o : orders) {
            o.displayOrder();
        }
    }

    public String getName() {
        return name;
    }
}

// E-commerce Platform
public class EcommercePlatform {
    private String platformName;
    private ArrayList<EcomCustomer> customers;

    public EcommercePlatform(String platformName) {
        this.platformName = platformName;
        this.customers = new ArrayList<>();
    }

    public void registerCustomer(EcomCustomer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " registered on " + platformName);
    }

    public static void main(String[] args) {
        // Create platform
        EcommercePlatform platform = new EcommercePlatform("ShopNow");

        // Create customers
        EcomCustomer c1 = new EcomCustomer("Alice", "C001");
        EcomCustomer c2 = new EcomCustomer("Bob", "C002");

        // Register customers
        platform.registerCustomer(c1);
        platform.registerCustomer(c2);

        // Create products
        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Mouse", 25);
        Product p3 = new Product("Keyboard", 75);

        // Customer places order and adds products
        Order order1 = c1.placeOrder("ORD001");
        order1.addProduct(p1);
        order1.addProduct(p2);

        Order order2 = c2.placeOrder("ORD002");
        order2.addProduct(p3);

        // View customer orders
        c1.viewOrders();
        c2.viewOrders();
    }
}
