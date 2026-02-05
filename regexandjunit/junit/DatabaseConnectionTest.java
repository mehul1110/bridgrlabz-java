package regexandjunit.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class DatabaseConnection {
    private boolean connected = false;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}

/**
 * JUnit Test Class
 */
public class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setup() {
        db = new DatabaseConnection();
        db.connect();
    }

    @Test
    void testConnection() {
        assertTrue(db.isConnected());
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
        assertFalse(db.isConnected());
    }
}
