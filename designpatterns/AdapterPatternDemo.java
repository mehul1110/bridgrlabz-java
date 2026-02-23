package designpatterns;

/**
 * Adapter Pattern implementation.
 * Allows incompatible interfaces to work together.
 */

// Legacy system class that needs to be adapted
class OldSystem {
    public void oldMethod() {
        System.out.println("Processing logic through the Old Legacy System Method interface.");
    }
}

// New standard interface
interface NewSystem {
    void newMethod();
}

// Adapter bridging the new interface to old system classes
class Adapter implements NewSystem {
    private OldSystem oldSystemInstance;

    public Adapter(OldSystem old) {
        this.oldSystemInstance = old;
    }

    @Override
    public void newMethod() {
        System.out.println("Adapter executing: Routing New Method call to Old Legacy System.");

        // Translating logic bridging to Old System capabilities
        oldSystemInstance.oldMethod();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Adapter Pattern...\n");

        OldSystem legacyComponent = new OldSystem();

        // Use an Adapter instance to plug standard interface into old code execution
        // logic
        NewSystem adapterLogic = new Adapter(legacyComponent);

        System.out.println("Client calls the standard modern New System interface method: `newMethod()`");

        // The resulting invocation gets mapped transparently behind the Adapter pattern
        adapterLogic.newMethod();
    }
}
