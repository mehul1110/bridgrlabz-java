package linkedlists;

/**
 * StudentRecordManagement - Manages student records using a Singly Linked List.
 * Attributes: Roll Number, Name, Age, and Grade.
 * Operations: Add (beg/end/pos), Delete (Roll No), Search (Roll No), Update
 * (Grade), Display.
 */
public class StudentRecordManagement {

    // Node representing a student record
    private static class Node {
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;

        Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Node head;

    // Add a new student record at beginning, end, or specific position
    public void addRecord(int roll, String name, int age, String grade, int pos) {
        Node newNode = new Node(roll, name, age, grade);

        // Handle insertion at the beginning (position 1 or empty list)
        if (pos <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        // Traverse to find the position or the end of the list
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }

        // Link the new node into the list
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student record by Roll Number
    public void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Check if head node is the one to delete
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }

        Node current = head;
        // Search for the node before the target roll number
        while (current.next != null && current.next.rollNumber != roll) {
            current = current.next;
        }

        // Update pointer to bypass the deleted node
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Roll Number " + roll + " not found.");
        }
    }

    // Search for a student record by Roll Number
    public void searchByRoll(int roll) {
        Node current = head;
        // Traverse and compare roll numbers
        while (current != null) {
            if (current.rollNumber == roll) {
                System.out.println("Found: [Roll: " + current.rollNumber + ", Name: " + current.name + ", Age: "
                        + current.age + ", Grade: " + current.grade + "]");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll " + roll + " not found.");
    }

    // Update student's grade based on Roll Number
    public void updateGrade(int roll, String newGrade) {
        Node current = head;
        // Iterate through list to find student
        while (current != null) {
            if (current.rollNumber == roll) {
                current.grade = newGrade;
                System.out.println("Updated Grade for Roll " + roll + " to " + newGrade);
                return;
            }
            current = current.next;
        }
        System.out.println("Roll Number " + roll + " not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        Node current = head;
        // Loop through all nodes starting from head
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + " | Name: " + current.name + " | Age: " + current.age
                    + " | Grade: " + current.grade);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();
        list.addRecord(101, "Alice", 20, "A", 1);
        list.addRecord(103, "Charlie", 22, "B", 2);
        list.addRecord(102, "Bob", 21, "A-", 2); // Insertion at position 2
        list.displayAll();
        list.updateGrade(103, "A+");
        list.searchByRoll(102);
        list.deleteByRoll(101);
        list.displayAll();
    }
}
