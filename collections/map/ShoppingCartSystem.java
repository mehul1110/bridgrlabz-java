package collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implement a Shopping Cart
 * - HashMap to store product prices (Product -> Price)
 * - LinkedHashMap to maintain order of items added (Product -> Quantity)
 * - TreeMap to display items sorted by price? or Name?
 * "Use TreeMap to display items sorted by price." -> This requires sorting by
 * Value. TreeMap sorts by Key.
 * So we will create a custom Comparator or structure to store in TreeMap for
 * display.
 */
public class ShoppingCartSystem {

    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();

    public void addProductPrice(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void displayCartInsertionOrder() {
        System.out.println("\nCart (Insertion Order):");
        System.out.println(cart);
    }

    public void displayCartSortedByPrice() {
        System.out.println("\nCart (Sorted by Price):");
        // TreeMap doesn't support sorting by value directly.
        // We can put entries into a List and sort, or use a TreeMap with a custom
        // comparator that looks up prices.

        Comparator<String> priceComparator = (p1, p2) -> {
            Double price1 = productPrices.get(p1);
            Double price2 = productPrices.get(p2);
            int cmp = price1.compareTo(price2);
            return cmp != 0 ? cmp : p1.compareTo(p2); // Fallback to name if prices equal
        };

        Map<String, Integer> sortedCart = new TreeMap<>(priceComparator);
        sortedCart.putAll(cart);

        for (Map.Entry<String, Integer> entry : sortedCart.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue() + " (Price: " + productPrices.get(entry.getKey()) + ")");
        }
    }

    public static void main(String[] args) {
        ShoppingCartSystem shop = new ShoppingCartSystem();
        shop.addProductPrice("Apple", 1.0);
        shop.addProductPrice("Banana", 0.5);
        shop.addProductPrice("Cherry", 2.0);

        shop.addToCart("Cherry", 5);
        shop.addToCart("Apple", 2);
        shop.addToCart("Banana", 10);

        shop.displayCartInsertionOrder();
        shop.displayCartSortedByPrice();
    }
}
