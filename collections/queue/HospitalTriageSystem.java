package collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: Hospital Triage System
 * Simulate a hospital triage system using a PriorityQueue where patients with
 * higher severity are treated first.
 * Example: Patients: [("John", 3), ("Alice", 5), ("Bob", 2)] -> Order: Alice,
 * John, Bob. (Assuming higher number = higher severity)
 */
public class HospitalTriageSystem {

    static class Patient implements Comparable<Patient> {
        String name;
        int severity; // Higher value means higher priority

        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public int compareTo(Patient other) {
            // Descending order of severity
            return Integer.compare(other.severity, this.severity);
        }

        @Override
        public String toString() {
            return name + " (" + severity + ")";
        }
    }

    public static void main(String[] args) {
        Queue<Patient> triageQueue = new PriorityQueue<>();

        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));

        System.out.println("Processing patients in order of severity:");
        while (!triageQueue.isEmpty()) {
            System.out.println("Treating: " + triageQueue.poll());
        }
    }
}
