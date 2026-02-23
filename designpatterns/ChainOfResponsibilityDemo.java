package designpatterns;

/**
 * Chain of Responsibility Pattern implementation.
 * Passes a request along a chain of potential handlers until one decides to
 * process it.
 */

// Define Abstract Handler element properties structuring processing chaining
// Logic
abstract class ExpenseHandler {
    // Reference mapping towards subsequent processor handler level
    protected ExpenseHandler nextProcessorHandler;

    // Building Pipeline mapping pointers
    public void setNextLevelProcessor(ExpenseHandler next) {
        this.nextProcessorHandler = next;
    }

    // Concrete method implementations process input value mapped logic requirements
    public abstract void validateExpenseRequest(int amountToApprove);
}

// Concrete Handler Level 1 (Lowest mapping) processing execution
class TeamLead extends ExpenseHandler {
    private static final int LEAD_APPROVAL_LIMIT = 500;

    @Override
    public void validateExpenseRequest(int requestedAmount) {
        if (requestedAmount <= LEAD_APPROVAL_LIMIT) {
            System.out.println("Processing Level: Team Lead approved the expense request for $" + requestedAmount);
        } else if (nextProcessorHandler != null) {
            System.out
                    .println("Team Lead lacks authority. Escalating $" + requestedAmount + " request up the Chain...");
            nextProcessorHandler.validateExpenseRequest(requestedAmount); // Delegate forward
        }
    }
}

// Concrete Handler Level 2 logic
class ManagerProcessor extends ExpenseHandler {
    private static final int MANAGER_APPROVAL_LIMIT = 2000;

    @Override
    public void validateExpenseRequest(int requestedAmount) {
        if (requestedAmount <= MANAGER_APPROVAL_LIMIT) {
            System.out.println("Processing Level: Manager approved the expense request for $" + requestedAmount);
        } else if (nextProcessorHandler != null) {
            System.out.println("Manager lacks authority. Escalating $" + requestedAmount + " request up the Chain...");
            nextProcessorHandler.validateExpenseRequest(requestedAmount); // Forward mapping chain
        }
    }
}

// Concrete Handler Level 3 logic (Highest structure block processing mapping)
class HRProcessor extends ExpenseHandler {
    @Override
    public void validateExpenseRequest(int requestedAmount) {
        // Ultimate fallback resolving request resolution
        System.out.println("Processing Level: HR evaluated and formally processed the large expense request for $"
                + requestedAmount);
    }
}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        System.out.println("Testing Chain of Responsibility Pattern Architecture...\n");

        // Initialization constructing Pipeline objects logic mapping reference
        ExpenseHandler teamLeadApprover = new TeamLead();
        ExpenseHandler managerApprover = new ManagerProcessor();
        ExpenseHandler hrApprover = new HRProcessor();

        // Connect Structure defining forwarding delegation mapping paths
        teamLeadApprover.setNextLevelProcessor(managerApprover);
        managerApprover.setNextLevelProcessor(hrApprover);

        // Submitting Request to the Ground Level Processor
        System.out.println("--- Scenario 1: Submitting $300 Request ---");
        teamLeadApprover.validateExpenseRequest(300);

        System.out.println("\n--- Scenario 2: Submitting $1500 Request ---");
        teamLeadApprover.validateExpenseRequest(1500);

        System.out.println("\n--- Scenario 3: Submitting $5000 Request ---");
        teamLeadApprover.validateExpenseRequest(5000);
    }
}
