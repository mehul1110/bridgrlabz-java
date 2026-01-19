import java.util.ArrayList;

/*
 * Problem 5: Library Management System
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Concrete class 1
class Book extends LibraryItem implements Reservable {
    private String borrowerName;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            this.borrowerName = borrowerName;
            setAvailable(false);
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Concrete class 2
class Magazine extends LibraryItem implements Reservable {
    private String borrowerName;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            this.borrowerName = borrowerName;
            setAvailable(false);
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Concrete class 3
class DVD extends LibraryItem implements Reservable {
    private String borrowerName;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            this.borrowerName = borrowerName;
            setAvailable(false);
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<LibraryItem> items = new ArrayList<>();
        
        items.add(new Book("B001", "Clean Code", "Robert Martin"));
        items.add(new Magazine("M001", "Tech Today", "Various"));
        items.add(new DVD("D001", "Java Tutorial", "Oracle"));

        // Polymorphism
        System.out.println("=== Library Items ===");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("John Doe");
            }
            System.out.println("-------------------------");
        }
    }
}
