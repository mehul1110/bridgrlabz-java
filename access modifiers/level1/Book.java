/*
 * Program to demonstrate Constructor Usage
 * Creates a Book class with title, author, and price attributes
 * Demonstrates default and parameterized constructors
 */
public class Book {
    
    // Instance variables
    private String title;
    private String author;
    private double price;

    /*
     * Default Constructor
     * Initializes book with default values
     */
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    /*
     * Parameterized Constructor
     * Initializes book with user provided values
     */
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Create object using default constructor
        Book defaultBook = new Book();
        defaultBook.displayDetails();

        // Create object using parameterized constructor
        Book paramBook = new Book("The Alchemist", "Paulo Coelho", 350.50);
        paramBook.displayDetails();
    }
}
