/*
 * Single Inheritance - Sample Problem 1
 * Library Management with Books and Authors
 * Demonstrates single inheritance with Book as superclass and Author as subclass
 */

// Superclass
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // Call superclass constructor
        this.name = name;
        this.bio = bio;
    }

    // Override and extend display method
    public void displayInfo() {
        System.out.println("--- Book Information ---");
        displayBookInfo(); // Call superclass method
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
        System.out.println("-------------------------");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        // Create book with author
        Author book1 = new Author("Clean Code", 2008, "Robert Martin", "Software craftsman and author");
        Author book2 = new Author("Effective Java", 2018, "Joshua Bloch", "Java expert and former Google engineer");

        // Display information
        book1.displayInfo();
        book2.displayInfo();
    }
}
