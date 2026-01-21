package linkedlists;

/**
 * RoundRobinScheduler - Simulates Round Robin scheduling using a Circular
 * Linked List.
 * Attributes: Process ID, Burst Time, Priority.
 * Calculates: Average Waiting Time and Turn-around Time.
 */
public class RoundRobinScheduler {

    private static class Node {
        int pid, burstTime, remainingTime, priority;
        int waitTime, turnAroundTime;
        Node next;

        Node(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    private Node head;

    // Add new process at the end of the circular list
    public void addProcess(int pid, int burst, int prio) {
        Node newNode = new Node(pid, burst, prio);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head)
                last = last.next;
            last.next = newNode;
            newNode.next = head;
        }
    }

    // Simulate scheduling with a fixed time quantum
    public void simulate(int quantum) {
        if (head == null)
            return;

        int currentTime = 0;
        Node current = head;
        Node prev = null;

        // Find total count for statistics
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        Node[] allProcesses = new Node[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            allProcesses[i] = temp;
            temp = temp.next;
        }

        System.out.println("\n--- Round Robin Simulation ---");
        while (head != null) {
            int exec = Math.min(current.remainingTime, quantum);
            current.remainingTime -= exec;
            currentTime += exec;
            System.out.println("Processing P" + current.pid + " for " + exec + " ms. Current Time: " + currentTime);

            if (current.remainingTime == 0) {
                // If process finishes, remove it and calculate times
                current.turnAroundTime = currentTime;
                current.waitTime = current.turnAroundTime - current.burstTime;
                System.out.println(">> P" + current.pid + " Finished. Wait: " + current.waitTime + ", TAT: "
                        + current.turnAroundTime);

                if (current.next == current) {
                    head = null;
                } else {
                    Node last = head;
                    while (last.next != current)
                        last = last.next;
                    last.next = current.next;
                    if (current == head)
                        head = head.next;
                    current = last.next;
                    continue; // Skip the standard next move
                }
            }
            current = current.next;
        }

        // Final Statistics Calculation
        double totalWait = 0, totalTAT = 0;
        for (Node p : allProcesses) {
            totalWait += p.waitTime;
            totalTAT += p.turnAroundTime;
        }
        System.out.println("\nAvg Waiting Time: " + (totalWait / count));
        System.out.println("Avg Turn-around Time: " + (totalTAT / count));
    }

    public static void main(String[] args) {
        RoundRobinScheduler rrs = new RoundRobinScheduler();
        rrs.addProcess(1, 10, 1);
        rrs.addProcess(2, 5, 2);
        rrs.addProcess(3, 8, 3);
        rrs.simulate(4);
    }
}
