package linkedlists;

/**
 * LibraryManagementSystem - Manages books using a Doubly Linked List.
 * Attributes: Title, Author, Genre, ID, Availability Status.
 * Maintains head and tail pointers.
 */
public class LibraryManagementSystem {

    private static class Node {
        String title, author, genre;
        int id;
        boolean isAvailable;
        Node next, prev;

        Node(String title, String author, String genre, int id, boolean status) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.id = id;
            this.isAvailable = status;
        }
    }

    private Node head, tail;
    private int bookCount = 0;

    // Add a new book at beginning, end, or position
    public void addBook(String title, String author, String genre, int id, boolean status, int pos) {
        Node newNode = new Node(title, author, genre, id, status);
        if (head == null) {
            head = tail = newNode;
        } else if (pos <= 1) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < pos - 1 && current.next != null; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null)
                current.next.prev = newNode;
            else
                tail = newNode;
            current.next = newNode;
        }
        bookCount++;
    }

    // Remove a book by Book ID and update pointers correctly
    public void removeById(int id) {
        Node current = head;
        while (current != null) {
            if (current.id == id) {
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;
                else
                    tail = current.prev;
                bookCount--;
                return;
            }
            current = current.next;
        }
    }

    // Search by title or author
    public void search(String query) {
        Node current = head;
        // Search through the list
        while (current != null) {
            if (current.title.equalsIgnoreCase(query) || current.author.equalsIgnoreCase(query)) {
                System.out.println("Match: " + current.title + " by " + current.author + " ["
                        + (current.isAvailable ? "Available" : "Checked Out") + "]");
            }
            current = current.next;
        }
    }

    // Display all books in forward and reverse order
    public void displayBooks(boolean forward) {
        System.out.println("\n--- Library (" + (forward ? "Forward" : "Reverse") + ") ---");
        Node current = forward ? head : tail;
        // Traversal using doubly links
        while (current != null) {
            System.out.println("ID: " + current.id + " | Title: " + current.title);
            current = forward ? current.next : current.prev;
        }
    }

    public void updateStatus(int id, boolean status) {
        Node current = head;
        while (current != null) {
            if (current.id == id) {
                current.isAvailable = status;
                return;
            }
            current = current.next;
        }
    }

    public int getBookCount() {
        return bookCount;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();
        lib.addBook("Clean Code", "Robert Martin", "Tech", 501, true, 1);
        lib.addBook("Refactoring", "Martin Fowler", "Tech", 502, true, 2);
        lib.displayBooks(true);
        lib.search("Robert Martin");
        System.out.println("Total Books: " + lib.getBookCount());
        lib.removeById(502);
        lib.displayBooks(false);
    }
}
