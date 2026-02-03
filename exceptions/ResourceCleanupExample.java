package exceptions;

/**
 * Problem Statement 7: Exception Handling with Resource Cleanup
 * 
 * Problem: Manage connection requiring cleanup. Ensure proper cleanup.
 */

class Connection {
    void open() {
        System.out.println("Opening connection...");
    }

    void close() {
        System.out.println("Closing connection...");
    }
}

public class ResourceCleanupExample {

    public static void main(String[] args) {
        Connection conn = new Connection();
        try {
            conn.open();
            throw new RuntimeException("Something went wrong!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Ensure cleanup happens
            conn.close();
        }
    }
}
