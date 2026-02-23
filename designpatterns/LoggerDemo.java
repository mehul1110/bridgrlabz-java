package designpatterns;

/**
 * Singleton Pattern implementation.
 * Ensures only one instance of the Logger class exists and provides a global
 * access point.
 */
class Logger {
    // Private static instance variable
    private static Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
    }

    // Public static method to provide a global access point
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class LoggerDemo {
    public static void main(String[] args) {
        System.out.println("Starting Singleton Logger test...");

        // Fetch the instance multiple times
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Print logs
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify that both instances point to the same object
        if (logger1 == logger2) {
            System.out.println("Result: Both logger instances are the same. Singleton works.");
        } else {
            System.out.println("Result: Logger instances are different. Singleton failed.");
        }
    }
}
