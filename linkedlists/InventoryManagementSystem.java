package linkedlists;

/**
 * InventoryManagementSystem - Manages inventory items using a Singly Linked
 * List.
 * Attributes: Name, ID, Quantity, Price.
 * Implementation: Add (beg/end/pos), Remove (ID), Update (Qty), Search
 * (ID/Name), Total Value, Merge Sort.
 */
public class InventoryManagementSystem {

    private static class Node {
        String name;
        int id, qty;
        double price;
        Node next;

        Node(String name, int id, int qty, double price) {
            this.name = name;
            this.id = id;
            this.qty = qty;
            this.price = price;
        }
    }

    private Node head;

    // Add item at specified position
    public void addItem(String name, int id, int qty, double price, int pos) {
        Node newNode = new Node(name, id, qty, price);
        if (pos <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < pos - 1 && current.next != null; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove item based on ID
    public void removeById(int id) {
        if (head == null)
            return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }
        if (current.next != null)
            current.next = current.next.next;
    }

    // Search for item based on ID or Name
    public void search(Integer id, String name) {
        Node current = head;
        // Traverse and match either ID or Name
        while (current != null) {
            if ((id != null && current.id == id) || (name != null && current.name.equalsIgnoreCase(name))) {
                System.out.println("Found: " + current.name + " | Qty: " + current.qty + " | Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }

    // Display total value of inventory (Qty * Price)
    public void displayTotalValue() {
        double total = 0;
        Node current = head;
        // Total sum calculation
        while (current != null) {
            total += current.qty * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + total);
    }

    // Implementation of Merge Sort for the linked list
    public void sort(boolean byName) {
        head = mergeSort(head, byName);
        System.out.println("Inventory Sorted successfully.");
    }

    private Node mergeSort(Node head, boolean byName) {
        if (head == null || head.next == null)
            return head;

        // Find middle
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively split and merge
        Node left = mergeSort(head, byName);
        Node right = mergeSort(nextOfMiddle, byName);

        return sortedMerge(left, right, byName);
    }

    private Node sortedMerge(Node a, Node b, boolean byName) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        boolean condition = byName ? (a.name.compareToIgnoreCase(b.name) <= 0) : (a.price <= b.price);

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, byName);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, byName);
        }
        return result;
    }

    private Node getMiddle(Node head) {
        if (head == null)
            return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayAll() {
        Node current = head;
        while (current != null) {
            System.out
                    .println(current.name + " (ID: " + current.id + ") - Qty: " + current.qty + " @ $" + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inv = new InventoryManagementSystem();
        inv.addItem("Laptop", 101, 10, 1000, 1);
        inv.addItem("Mouse", 102, 50, 20, 2);
        inv.addItem("Keyboard", 103, 30, 50, 2);
        inv.displayAll();
        inv.sort(true); // Sort by Name
        inv.displayAll();
        inv.displayTotalValue();
    }
}
