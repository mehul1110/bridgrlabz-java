package designpatterns;

/**
 * Memento Pattern implementation.
 * Captures and restores an object's internal state without violating
 * encapsulation.
 */

// Step 1: Memento - The object that stores the state of the Originator
class ConfigurationMemento {
    private final String internalStateMemoryTracker;

    public ConfigurationMemento(String currentProcessStateToSave) {
        this.internalStateMemoryTracker = currentProcessStateToSave;
    }

    public String fetchSavedMemoryState() {
        return internalStateMemoryTracker; // Resolves historical config mapping
    }
}

// Step 2: Originator - The object whose state is being tracked and restored
class DocumentEditor {
    private String currentContentData;

    public void updateContent(String newContentDataStr) {
        this.currentContentData = newContentDataStr;
        System.out.println("Document Editor Object modified text context to: '" + this.currentContentData + "'");
    }

    public String getCurrentContent() {
        return currentContentData;
    }

    // Capture point logic mapping
    public ConfigurationMemento createMemorySnapshot() {
        System.out
                .println("SYSTEM: Creating backup snapshot memory of the Editor state -> '" + currentContentData + "'");
        return new ConfigurationMemento(currentContentData); // Maps properties to Memento Object memory execution
    }

    // Restoration pointer
    public void restoreFromMemorySnapshot(ConfigurationMemento backupLogicMemObj) {
        currentContentData = backupLogicMemObj.fetchSavedMemoryState();
        System.out
                .println("SYSTEM: Editor state rollback executed -> Restored context to: '" + currentContentData + "'");
    }
}

// Step 3: Caretaker - The object responsible for holding and managing Mementos
class SnapshotCaretaker {
    // Basic implementation storing a single backup state
    private ConfigurationMemento backupHistoryTrackerStorage;

    public void saveConfigurationSnapshot(ConfigurationMemento mappedLogicObjInstance) {
        this.backupHistoryTrackerStorage = mappedLogicObjInstance;
        System.out.println("[Caretaker Manager] Snapshot Data successfully registered.");
    }

    public ConfigurationMemento retrieveConfigurationSnapshot() {
        System.out.println("[Caretaker Manager] Retrieving previously backed-up Configuration memory.");
        return backupHistoryTrackerStorage;
    }
}

public class MementoPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Memento Pattern Logic Rollback Mapping...\n");

        DocumentEditor editorSystemOrigin = new DocumentEditor();
        SnapshotCaretaker backupLogicManager = new SnapshotCaretaker();

        // Start context mutation
        System.out.println("--- Action Series 1 ---");
        editorSystemOrigin.updateContent("Chapter 1: The Beginning");
        editorSystemOrigin.updateContent("Chapter 1: The Beginning. It was a dark and stormy night.");

        System.out.println("\n--- Taking Snapshot Backup Action ---");
        // Delegating Memory snapshot capturing procedure via Originator logic
        ConfigurationMemento executionBackupPointDataObj = editorSystemOrigin.createMemorySnapshot();
        backupLogicManager.saveConfigurationSnapshot(executionBackupPointDataObj);

        System.out.println("\n--- Action Series 2 ---");
        editorSystemOrigin.updateContent("Chapter 2: The Action Continues... This edit was a mistake!");

        System.out.println("\n--- Trigger Rollback Recovery Procedure ---");
        ConfigurationMemento storedBackupMemObj = backupLogicManager.retrieveConfigurationSnapshot();
        // Restore mapping logically
        editorSystemOrigin.restoreFromMemorySnapshot(storedBackupMemObj);

        System.out.println("Current Document Status Resolved To -> " + editorSystemOrigin.getCurrentContent());
    }
}
