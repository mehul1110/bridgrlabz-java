package generics;

/**
 * Dynamic Online Marketplace.
 * Demonstrates Type Parameters, Generic Methods, and Bounded Type Parameters.
 */
public class OnlineMarketplace {

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 45.00, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Denim Jacket", 75.50, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 999.99, new GadgetCategory());

        System.out.println("--- Before Discount ---");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        // Apply discounts
        applyDiscount(book, 10); // 10% off
        applyDiscount(shirt, 20); // 20% off
        applyDiscount(phone, 5); // 5% off

        System.out.println("\n--- After Discount ---");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }

    /**
     * Generic method to apply a discount to any product type.
     * Restricts the type T to be a subclass of Product (or Product itself).
     *
     * @param product    The product to discount.
     * @param percentage The discount percentage.
     * @param <T>        The type of the product (extends Product class).
     */
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double newPrice = currentPrice - (currentPrice * (percentage / 100));
        product.setPrice(newPrice);
        System.out.println("Applied " + percentage + "% discount to " + product.getName());
    }
}

/**
 * Abstract class representing a general category of products.
 */
abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

/**
 * Generic class Product.
 * T is restricted to subclasses of ProductCategory.
 *
 * @param <T> The category of the product.
 */
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product: " + name + " (" + category + "), Price: $" + price;
    }
}
