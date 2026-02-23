package designpatterns;

/**
 * Strategy Pattern implementation.
 * Encapsulates interchangeably algorithms, making them independent from clients
 * using them.
 */

// Step 1: Definition of the standard generic Strategy interface configuration
interface PaymentStrategyLogic {
    int executePaymentTransaction(int amountValueParam);
}

// Step 2: Concrete variations mapping interchangeable algorithmic
// implementations
class CashPayment implements PaymentStrategyLogic {
    @Override
    public int executePaymentTransaction(int transactionValue) {
        System.out.println("Processing standard Cash Payment: Deducting $" + transactionValue);
        return transactionValue;
    }
}

class CardPayment implements PaymentStrategyLogic {
    @Override
    public int executePaymentTransaction(int transactionValue) {
        // Strategy may contain unique variation costs/taxes mapping executions
        int processingFeeRate = 2; // Fixed Card processing execution logic overhead
        System.out.println("Processing Card Payment logic (Includes $2 processing fee): Deducting $"
                + (transactionValue + processingFeeRate));
        return transactionValue + processingFeeRate;
    }
}

class UPIPayment implements PaymentStrategyLogic {
    @Override
    public int executePaymentTransaction(int transactionValue) {
        System.out.println("Processing secure UPI Digital Transfer logic: Deducting $" + transactionValue);
        return transactionValue;
    }
}

// Step 3: The Context executing interchangeably applied strategy logic
// dynamically
class CheckoutContextEnvironment {
    private PaymentStrategyLogic activeExecutionPaymentStrategy;

    public void setPaymentStrategy(PaymentStrategyLogic selectedPaymentLogicObj) {
        // Set context algorithm variation
        this.activeExecutionPaymentStrategy = selectedPaymentLogicObj;
    }

    public void validateAndExecuteCheckout(int orderTotalLogicVal) {
        if (activeExecutionPaymentStrategy != null) {
            System.out.println("[Context System] Requesting Strategy logic execution workflow...");
            activeExecutionPaymentStrategy.executePaymentTransaction(orderTotalLogicVal);
        } else {
            System.err.println("[Context System] Error: No payment algorithm configuration bound.");
        }
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Interchangeable Strategy Pattern Algorithm Executions...\n");

        CheckoutContextEnvironment checkoutSystem = new CheckoutContextEnvironment();

        System.out.println("--- Scenario 1: Customer Chooses Cash Logic ---");
        // Bind configuration logically
        checkoutSystem.setPaymentStrategy(new CashPayment());
        checkoutSystem.validateAndExecuteCheckout(150);

        System.out.println("\n--- Scenario 2: Customer Chooses Card Interface ---");
        // Re-Bind processing behavior mapping
        checkoutSystem.setPaymentStrategy(new CardPayment());
        checkoutSystem.validateAndExecuteCheckout(500);

        System.out.println("\n--- Scenario 3: Customer Switches logic to UPI Framework ---");
        // Change logic mapped process without disrupting context system structural
        // integration
        checkoutSystem.setPaymentStrategy(new UPIPayment());
        checkoutSystem.validateAndExecuteCheckout(1200);
    }
}
