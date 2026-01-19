import java.util.ArrayList;

/*
 * Problem 1: Library and Books (Aggregation)
 * Demonstrates aggregation where books can exist independently of library
 */

// Book class - can exist independently
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }

    public String getTitle() {
        return title;
    }
}

// Library class - aggregates books
public class LibraryBooks {
    private String libraryName;
    private ArrayList<Book> books;

    public LibraryBooks(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to " + libraryName);
    }

    // Display all books in library
    public void displayBooks() {
        System.out.println("\n--- " + libraryName + " ---");
        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Book book : books) {
                book.displayInfo();
            }
        }
    }

    public static void main(String[] args) {
        // Create books independently
        Book b1 = new Book("Clean Code", "Robert Martin");
        Book b2 = new Book("Effective Java", "Joshua Bloch");
        Book b3 = new Book("Design Patterns", "Gang of Four");

        // Create libraries
        LibraryBooks lib1 = new LibraryBooks("Central Library");
        LibraryBooks lib2 = new LibraryBooks("City Library");

        // Add books to libraries (aggregation)
        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b2); // Same book in different library
        lib2.addBook(b3);

        // Display library contents
        lib1.displayBooks();
        lib2.displayBooks();

        // Books still exist independently
        System.out.println("\n--- Independent Book ---");
        b1.displayInfo();
    }
}
