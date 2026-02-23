package designpatterns;

/**
 * State Pattern implementation.
 * Allows an object to alter its behavior when its internal state changes.
 */

// Step 1: Define generic State interface logic execution
interface ATMStateLogic {
    void executeAction(ATMContext executionContextRef);
}

// Step 2: Concrete State behavior logic variations
class NoCardState implements ATMStateLogic {
    @Override
    public void executeAction(ATMContext contextConfigurationObj) {
        System.out.println("SYSTEM STATE: [No Card Displayed] - Please insert a Card to begin.");
        // Process transition mapping logic to next State internally
        contextConfigurationObj.setStateExecutionReference(new HasCardState());
    }
}

class HasCardState implements ATMStateLogic {
    @Override
    public void executeAction(ATMContext contextConfigurationObj) {
        System.out.println("SYSTEM STATE: [Card Inserted] - Please authenticate by entering your PIN.");
        // Process transition logic mapped properties
        contextConfigurationObj.setStateExecutionReference(new AuthorizedState());
    }
}

class AuthorizedState implements ATMStateLogic {
    @Override
    public void executeAction(ATMContext contextConfigurationObj) {
        System.out.println("SYSTEM STATE: [Auth Successful] - Transaction processing options unlocked.");
        // Process cycle reset mapping properties configuration
        System.out.println("\nEjecting Card. Returning System to baseline.");
        contextConfigurationObj.setStateExecutionReference(new NoCardState());
    }
}

// Step 3: The Context Object controlling the execution memory wrapper
// dynamically mapped
class ATMContext {
    private ATMStateLogic currentSystemStatePointer;

    public ATMContext() {
        // Initialize logic pointing towards default base mapping
        this.currentSystemStatePointer = new NoCardState();
    }

    // Mapping Setter updating structural dependency dynamically
    public void setStateExecutionReference(ATMStateLogic nextExecutionLogicStateObj) {
        this.currentSystemStatePointer = nextExecutionLogicStateObj;
    }

    public ATMStateLogic fetchCurrentStateStructure() {
        return this.currentSystemStatePointer;
    }

    // Delegation configuration triggering context-dependent properties logic
    public void requestStateLogicExecutionProcess() {
        currentSystemStatePointer.executeAction(this);
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing State Pattern Dynamic Behavior Modification Mapping...\n");

        ATMContext atmSystemMachineObj = new ATMContext();

        // 1. Initial State behavior call execution
        System.out.println("--- Action 1 ---");
        System.out.println("User Input Action Received => Logic execution triggers based on NoCardState");
        atmSystemMachineObj.requestStateLogicExecutionProcess();

        // 2. Transformed logic processing output
        System.out.println("\n--- Action 2 ---");
        System.out.println("User Input Action Received => System now processes based on HasCardState logic");
        atmSystemMachineObj.requestStateLogicExecutionProcess();

        // 3. Third Logic State
        System.out.println("\n--- Action 3 ---");
        System.out.println("User Input Action Received => System acts on Authorized logic requirements.");
        atmSystemMachineObj.requestStateLogicExecutionProcess();

        // 4. Reset Logic State Mapping configuration executed successfully
        System.out.println("\n--- Final Integrity Check ---");
        System.out.println("Current Context Logic Pointer Class Type: "
                + atmSystemMachineObj.fetchCurrentStateStructure().getClass().getSimpleName());
    }
}
