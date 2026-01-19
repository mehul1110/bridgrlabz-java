/*
 * Program for Book Library Access
 * Demonstrates access modifiers in inheritance
 */
public class BookAccess {
    
    public String isbn;
    protected String title;
    private String author;

    /*
     * Constructor
     */
    public BookAccess(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Public getter for private author
    public String getAuthor() {
        return author;
    }

    public void displayDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public static void main(String[] args) {
        BookAccess b = new BookAccess("978-3", "Java", "Gosling");
        b.displayDetails();

        System.out.println("--- EBook ---");
        EBook eb = new EBook("123-4", "Effective Java", "Bloch");
        eb.displayEBookDetails();
    }
}

/*
 * Subclass EBook
 */
class EBook extends BookAccess {
    
    public EBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    public void displayEBookDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title); // Protected access
        System.out.println("Author: " + getAuthor()); // Public access to private
    }
}
