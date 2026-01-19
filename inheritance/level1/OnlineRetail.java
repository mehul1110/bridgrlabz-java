/*
 * Multilevel Inheritance - Sample Problem 1
 * Online Retail Order Management
 * Demonstrates multilevel inheritance: Order -> ShippedOrder -> DeliveredOrder
 */

// Base class
class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

// First level subclass
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate); // Call parent constructor
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }

    public void displayShippingInfo() {
        displayOrderInfo(); // Call grandparent method
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Second level subclass
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber); // Call parent constructor
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }

    public void displayDeliveryInfo() {
        System.out.println("--- Order Details ---");
        displayShippingInfo(); // Call parent method
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: " + getOrderStatus());
        System.out.println("-------------------------");
    }
}

public class OnlineRetail {
    public static void main(String[] args) {
        // Create orders at different stages
        Order order1 = new Order("ORD001", "2024-01-15");
        ShippedOrder order2 = new ShippedOrder("ORD002", "2024-01-16", "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2024-01-14", "TRK67890", "2024-01-18");

        // Display status
        System.out.println("Order 1 Status: " + order1.getOrderStatus());
        System.out.println("\nOrder 2 Status: " + order2.getOrderStatus());
        System.out.println("\nOrder 3:");
        order3.displayDeliveryInfo();
    }
}
