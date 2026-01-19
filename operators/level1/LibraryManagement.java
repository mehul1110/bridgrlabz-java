/*
 * Program for Library Management System
 * Demonstrates static, this, final, and instanceof keywords
 */
public class LibraryManagement {
    
    // Static variable shared across all books
    private static String libraryName = "City Central Library";
    
    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final - unique identifier

    /*
     * Constructor
     * Uses 'this' to initialize instance variables
     */
    public LibraryManagement(String title, String author, String isbn) {
        this.title = title; // 'this' resolves ambiguity
        this.author = author;
        this.isbn = isbn; // Final variable initialization
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    // Display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("-------------------------");
    }

    // Safe display using instanceof check
    public static void safeDisplay(Object obj) {
        // Verify object is instance of LibraryManagement
        if (obj instanceof LibraryManagement) {
            LibraryManagement book = (LibraryManagement) obj;
            book.displayDetails();
        } else {
            System.out.println("Error: Object is not a LibraryManagement instance");
        }
    }

    public static void main(String[] args) {
        // Display library name
        LibraryManagement.displayLibraryName();
        System.out.println();
        
        // Create books
        LibraryManagement book1 = new LibraryManagement("Clean Code", "Robert Martin", "978-0132350884");
        LibraryManagement book2 = new LibraryManagement("Effective Java", "Joshua Bloch", "978-0134685991");
        
        // Display using instanceof check
        System.out.println("--- Book 1 ---");
        safeDisplay(book1);
        
        System.out.println("--- Book 2 ---");
        safeDisplay(book2);
        
        // Test instanceof with invalid object
        System.out.println("--- Testing with Integer object ---");
        safeDisplay(123);
    }
}
