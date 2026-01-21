package linkedlists;

/**
 * MovieManagementSystem - Manages movie records using a Doubly Linked List.
 * Attributes: Title, Director, Year of Release, Rating.
 * Maintains pointers to both head and tail for efficiency.
 */
public class MovieManagementSystem {

    private static class Node {
        String title, director;
        int year;
        double rating;
        Node next, prev;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    private Node head, tail;

    // Add movie at beginning, end, or specific position
    public void addMovie(String title, String director, int year, double rating, int pos) {
        Node newNode = new Node(title, director, year, rating);

        // Handle insertion at beginning
        if (head == null) {
            head = tail = newNode;
            return;
        }

        if (pos <= 1) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;
            // Traverse to position-1
            for (int i = 1; i < pos - 1 && current.next != null; i++) {
                current = current.next;
            }

            // Insert in between or at end
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode; // Updating tail if added at the end
            }
            current.next = newNode;
        }
    }

    // Remove a movie record by Title
    public void removeByTitle(String title) {
        Node current = head;
        // Search for title
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                // Update previous neighbor
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                // Update next neighbor
                if (current.next != null)
                    current.next.prev = current.prev;
                else
                    tail = current.prev;
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    // Search by Director or Rating
    public void search(String director, Double rating) {
        Node current = head;
        boolean found = false;
        // Iterate through doubly linked list
        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                    (rating != null && current.rating == rating)) {
                System.out.println("Match: " + current.title + " | " + current.director + " | " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("No movies matching criteria found.");
    }

    // Display all movies in both forward and reverse order
    public void display(boolean forward) {
        System.out.println("\n--- Movie Records (" + (forward ? "Forward" : "Reverse") + ") ---");
        Node current = forward ? head : tail;
        // Traverse using next or prev pointers
        while (current != null) {
            System.out.println(
                    current.title + " [" + current.director + ", " + current.year + ", " + current.rating + "]");
            current = forward ? current.next : current.prev;
        }
    }

    // Update a movie's Rating based on title
    public void updateRating(String title, double newRating) {
        Node current = head;
        // Search and update
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        mms.addMovie("Inception", "Nolan", 2010, 8.8, 1);
        mms.addMovie("Interstellar", "Nolan", 2014, 8.6, 2);
        mms.addMovie("The Dark Knight", "Nolan", 2008, 9.0, 2);
        mms.display(true); // Forward
        mms.display(false); // Reverse
        mms.search("Nolan", null);
        mms.updateRating("Inception", 9.1);
        mms.removeByTitle("Interstellar");
        mms.display(true);
    }
}
