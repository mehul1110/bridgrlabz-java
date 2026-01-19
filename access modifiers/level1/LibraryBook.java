/*
 * Program for Library Book System
 * Manages book details and borrowing status
 */
public class LibraryBook {
    
    // Instance variables
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    /*
     * Parameterized Constructor
     * Sets book details and default availability
     */
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    // Method to borrow book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Borrowed: " + title);
        } else {
            System.out.println("Unavailable: " + title);
        }
    }

    // Method to return book
    public void returnBook() {
        isAvailable = true;
        System.out.println("Returned: " + title);
    }

    // Display book status
    public void displayStatus() {
        System.out.println("Title: " + title);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Create book
        LibraryBook book = new LibraryBook("Clean Code", "Robert Martin", 40.0);
        book.displayStatus();
        
        // Borrow book
        book.borrowBook();
        book.displayStatus();
        
        // Return book
        book.returnBook();
        book.displayStatus();
    }
}
