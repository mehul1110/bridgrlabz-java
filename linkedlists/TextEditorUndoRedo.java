package linkedlists;

/**
 * TextEditorUndoRedo - Implements Undo/Redo using a Doubly Linked List.
 * Each node represents a state of the transcript.
 * Maintains current state pointer and limits history to a fixed size.
 */
public class TextEditorUndoRedo {

    private static class Node {
        String content;
        Node next, prev;

        Node(String content) {
            this.content = content;
        }
    }

    private Node currentState;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add a new text state at the end and clear potential redo history
    public void addState(String content) {
        Node newNode = new Node(content);

        if (currentState == null) {
            currentState = newNode;
        } else {
            // New action clears all "next" states (redo path)
            currentState.next = newNode;
            newNode.prev = currentState;
            currentState = newNode;
        }

        size++;
        // Limit history to fix size by removing from bottom
        if (size > MAX_HISTORY) {
            Node oldest = currentState;
            // Traverse all the way back
            while (oldest.prev != null)
                oldest = oldest.prev;
            // Detach oldest
            if (oldest.next != null) {
                oldest.next.prev = null;
                size--;
            }
        }
        System.out.println("New State added. History Size: " + size);
    }

    // Move to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undone: current state is now: " + currentState.content);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Move back to the next state after an undo
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redone: current state is now: " + currentState.content);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // Display the current content of the text
    public void displayCurrent() {
        if (currentState != null) {
            System.out.println(">> Current Text: " + currentState.content);
        } else {
            System.out.println(">> Editor is empty.");
        }
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        editor.addState("Initial Line");
        editor.addState("Initial Line + Hello");
        editor.addState("Initial Line + Hello World");

        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.redo();
        editor.displayCurrent();

        // Add new state after undo to test Redo clearing
        editor.undo();
        editor.addState("Modified branch after undo");
        editor.redo(); // Should fail
        editor.displayCurrent();
    }
}
