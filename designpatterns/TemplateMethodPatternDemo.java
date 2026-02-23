package designpatterns;

/**
 * Template Method Pattern implementation.
 * Defines a structural algorithm skeleton mapping steps, letting subclasses
 * customize specific implementations.
 */

// Step 1: Definition of the Abstract Base Class outlining Template structure
// configurations
abstract class OrderProcessTemplate {

    // Abstract operations customized logically by inherited descendants
    protected abstract void selectOrderItems();

    protected abstract void executePaymentProcessing();

    protected abstract void deliverOrder();

    // Step 2: The Template Method itself structuring algorithm sequential execution
    // mapping
    // (Final so it cannot be altered or broken functionally by subclasses)
    public final void processCheckoutExecutionWorkflow() {
        System.out.println("Beginning Standard Order Workflow Framework Processing...");

        selectOrderItems();
        executePaymentProcessing();
        deliverOrder();

        System.out.println("Workflow Algorithm Complete.");
    }
}

// Step 3: Concrete Classes customizing structural steps functionally
class DeliveryOrder extends OrderProcessTemplate {
    @Override
    protected void selectOrderItems() {
        System.out.println("[Step 1] Delivery Customer selected items via Online Store.");
    }

    @Override
    protected void executePaymentProcessing() {
        System.out.println("[Step 2] Processing payment logic using Credit Card Interface Integration.");
    }

    @Override
    protected void deliverOrder() {
        System.out.println("[Step 3] Order dispatched to shipping center. ETA 3 Business Days.");
    }
}

class InStorePickupOrder extends OrderProcessTemplate {
    @Override
    protected void selectOrderItems() {
        System.out.println("[Step 1] Customer reserved specific store items logically.");
    }

    @Override
    protected void executePaymentProcessing() {
        System.out.println("[Step 2] Payment mapped to Cash Counter Register implementation.");
    }

    @Override
    protected void deliverOrder() {
        System.out.println("[Step 3] Customer collected order physically in-store. Process finalized.");
    }
}

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Template Method Algorithm Skeletons Workflows...\n");

        System.out.println("--- Executing Online Delivery Scenario ---");
        // Structure mapped through structural base
        OrderProcessTemplate onlinePurchaseEventWorkflow = new DeliveryOrder();
        onlinePurchaseEventWorkflow.processCheckoutExecutionWorkflow();

        System.out.println("\n--- Executing In-Store Physical Scenario ---");
        // Structure workflow sequence maintained consistently while steps alter
        // behavior logically
        OrderProcessTemplate storeReserveEventWorkflow = new InStorePickupOrder();
        storeReserveEventWorkflow.processCheckoutExecutionWorkflow();
    }
}
