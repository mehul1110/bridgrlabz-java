package linkedlists;

/**
 * TaskScheduler - Implements a task scheduler using a Circular Linked List.
 * Attributes: Task ID, Name, Priority, Due Date.
 * Operations: Add (beg/end/pos), Remove (ID), View Next, Search (Priority),
 * Display.
 */
public class TaskScheduler {

    private static class Node {
        int id, priority;
        String name, dueDate;
        Node next;

        Node(int id, String name, int priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    private Node head;
    private Node currentTask; // For "view current and move next"

    // Add task at beginning, end, or position in circular list
    public void addTask(int id, String name, int priority, String date, int pos) {
        Node newNode = new Node(id, name, priority, date);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to self
            currentTask = head;
            return;
        }

        // Add at beginning (position 1)
        if (pos <= 1) {
            Node last = head;
            // Traverse to find the last node
            while (last.next != head)
                last = last.next;
            newNode.next = head;
            last.next = newNode;
            head = newNode;
        } else {
            Node current = head;
            // Move to position in circular list
            for (int i = 1; i < pos - 1 && current.next != head; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove task by ID and maintain circularity
    public void removeTask(int id) {
        if (head == null)
            return;

        Node current = head, prev = null;
        // Search for node containing ID
        do {
            if (current.id == id) {
                // If only one node exists
                if (current == head && current.next == head) {
                    head = null;
                    currentTask = null;
                } else {
                    // Updating neighbors
                    if (current == head) {
                        Node last = head;
                        while (last.next != head)
                            last = last.next;
                        head = head.next;
                        last.next = head;
                        if (currentTask == current)
                            currentTask = head;
                    } else {
                        prev.next = current.next;
                        if (currentTask == current)
                            currentTask = current.next;
                    }
                }
                System.out.println("Removed Task ID: " + id);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task ID " + id + " not found.");
    }

    // View current task and move to the next task
    public void viewNext() {
        if (currentTask == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + currentTask.name + " (ID: " + currentTask.id + ")");
        // Shift currentTask to the next node in the cycle
        currentTask = currentTask.next;
    }

    // Search for a task by its Priority
    public void searchByPriority(int prio) {
        if (head == null)
            return;
        Node current = head;
        boolean found = false;
        // Iterate through circular structure once
        do {
            if (current.priority == prio) {
                System.out.println("Found Priority " + prio + ": " + current.name);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found)
            System.out.println("No task found with priority " + prio);
    }

    // Display all tasks starting from the head node
    public void displayAll() {
        if (head == null)
            return;
        System.out.println("\n--- All Tasks ---");
        Node current = head;
        // Loop through starting from head back to head
        do {
            System.out.println("ID: " + current.id + " | Task: " + current.name + " | Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addTask(1, "Coding", 1, "2024-01-01", 1);
        ts.addTask(2, "Review", 2, "2024-01-02", 2);
        ts.addTask(3, "Documentation", 3, "2024-01-03", 2);
        ts.displayAll();
        ts.viewNext();
        ts.viewNext();
        ts.searchByPriority(2);
        ts.removeTask(2);
        ts.displayAll();
    }
}
