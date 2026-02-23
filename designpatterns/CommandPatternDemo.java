package designpatterns;

/**
 * Command Pattern implementation.
 * Encapsulates a request as an object, thereby letting you parameterize
 * operations.
 */

// Step 1: Interface encapsulating all actions defining execution
interface Command {
    void executeAction();
}

// Step 2: The Receiver Component (the object actually performing logic
// operations)
class LightSystem {
    public void activateLight() {
        System.out.println("Light System has been turned ON.");
    }

    public void deactivateLight() {
        System.out.println("Light System has been turned OFF.");
    }
}

// Step 3: Concrete Commands encapsulating mapping configuration specific system
// Actions
class LightOnCommand implements Command {
    private LightSystem receiverReference;

    public LightOnCommand(LightSystem lightRef) {
        this.receiverReference = lightRef; // Bind Context Object instance logically to Execute structure
    }

    @Override
    public void executeAction() {
        // Triggers the logical Receiver operation delegated via Interface mapping
        // encapsulation
        receiverReference.activateLight();
    }
}

class LightOffCommand implements Command {
    private LightSystem receiverReference;

    public LightOffCommand(LightSystem lightRef) {
        this.receiverReference = lightRef;
    }

    @Override
    public void executeAction() {
        // Triggering Deactivation
        receiverReference.deactivateLight();
    }
}

// Step 4: The Invoker Component (does not know HOW logic completes, only WHEN
// to orchestrate triggers)
class RemoteControlInvoker {
    private Command registeredCommandLogic;

    public void loadCommandConfiguration(Command cmdInput) {
        this.registeredCommandLogic = cmdInput;
        System.out.println("[Invoker] Command loaded to Remote Control System memory.");
    }

    public void triggerExecute() {
        // Request Orchestration execution dynamically without Receiver logic context
        // binding mapping
        if (registeredCommandLogic != null) {
            registeredCommandLogic.executeAction();
        } else {
            System.err.println("No Command Mapped to Execute Workflow");
        }
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Command Pattern Workflow Isolation Execution...\n");

        // Initialization Logic Mapping configuration
        LightSystem lightReceiverComponent = new LightSystem();

        Command powerOnAction = new LightOnCommand(lightReceiverComponent);
        Command powerOffAction = new LightOffCommand(lightReceiverComponent);

        RemoteControlInvoker homeRemote = new RemoteControlInvoker();

        // Operating System Request Processing Scenario
        System.out.println("--- Executing Logic Binding (Power On Action) ---");
        homeRemote.loadCommandConfiguration(powerOnAction);
        homeRemote.triggerExecute();

        System.out.println("\n--- Executing Logic Binding (Power Off Action) ---");
        homeRemote.loadCommandConfiguration(powerOffAction);
        homeRemote.triggerExecute();
    }
}
