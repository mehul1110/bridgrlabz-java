package designpatterns;

/**
 * Proxy Pattern implementation.
 * Controls access to another object (for security, lazy loading, etc.).
 */

// Define generic structure mapping behavior
interface FileService {
    void runAccessControlLogic();
}

// Concrete component defining complex base execution logic
class RealFileService implements FileService {
    public RealFileService() {
        // Simulating heavy configuration initialization load
        System.out.println("Initializing internal RealFileService properties mapping configuration...");
    }

    @Override
    public void runAccessControlLogic() {
        System.out.println("Processing actual File Resource Download and Logic...");
    }
}

// Surrogate Proxy Class regulating/controlling the Real Component
class FileAccessProxy implements FileService {
    private RealFileService realServiceObjRef;
    private String userRoleAuthCredential;

    public FileAccessProxy(String userRoleAuthCredential) {
        this.userRoleAuthCredential = userRoleAuthCredential;
    }

    // Implementing Gatekeeping behavior to avoid memory overhead or security
    // breaches
    @Override
    public void runAccessControlLogic() {
        System.out.println("Proxy intercepts the incoming action request -> Role: " + userRoleAuthCredential);

        if ("ADMIN".equalsIgnoreCase(userRoleAuthCredential)) {
            // Lazy-loading instantiates only if requirement passes proxy filters
            if (realServiceObjRef == null) {
                System.out.println("Authorized! Proxy allocates memory mapping structure to Core Component.");
                realServiceObjRef = new RealFileService();
            }
            // Delegating successful execution flow
            realServiceObjRef.runAccessControlLogic();
        } else {
            System.err.println("Denied: User " + userRoleAuthCredential + " does not possess sufficient privileges.");
        }
    }
}

public class ProxyPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Proxy Pattern Gatekeeping Execution...\n");

        System.out.println("Scenario #1: User trying Unauthorized Basic Login Request");
        // Proxy instantiated referencing client context
        FileService unauthorizedServiceCallProxy = new FileAccessProxy("GUEST");
        unauthorizedServiceCallProxy.runAccessControlLogic(); // Triggers Block

        System.out.println("\nScenario #2: Authorized Super User Request");
        // Authorized action routes successful Lazy Loaded Object call execution
        FileService authorizedServiceCallProxy = new FileAccessProxy("ADMIN");
        authorizedServiceCallProxy.runAccessControlLogic();

        System.out.println("\nScenario #3: Subsequent Call by Authorized User");
        // Next access bypasses costly creation load since already memory mapped
        authorizedServiceCallProxy.runAccessControlLogic();
    }
}
