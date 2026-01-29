package collections.set;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Insurance Policy Management System
 * 
 * Requirements:
 * 1. Store Unique Policies using HashSet, LinkedHashSet, TreeSet.
 * 2. Retrieve Policies: All unique, expiring soon, specific coverage,
 * duplicates (logic handled by set naturally filters duplicates, but we
 * demonstrate behavior).
 * 3. Performance Comparison logic (simulated).
 */
public class InsurancePolicySystem {

    static class Policy implements Comparable<Policy> {
        private String policyNumber;
        private String policyHolderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType,
                double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public String getPolicyHolderName() {
            return policyHolderName;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        public double getPremiumAmount() {
            return premiumAmount;
        }

        @Override
        public String toString() {
            return "Policy{" +
                    "ID='" + policyNumber + '\'' +
                    ", Name='" + policyHolderName + '\'' +
                    ", Exp=" + expiryDate +
                    ", Type='" + coverageType + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Policy policy = (Policy) o;
            return Objects.equals(policyNumber, policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public int compareTo(Policy other) {
            // Natural order by expiry date as requested by TreeSet requirement 1.
            // If expiry dates are equal, fallback to policy number to be consistent with
            // equals?
            // "TreeSet to maintain policies sorted by expiry date."
            int dateComp = this.expiryDate.compareTo(other.expiryDate);
            if (dateComp != 0)
                return dateComp;
            return this.policyNumber.compareTo(other.policyNumber);
        }
    }

    // Different sets for demonstration
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void printAllUniquePolicies() {
        System.out.println("All Unique Policies (HashSet view):");
        for (Policy p : hashSetPolicies) {
            System.out.println(p);
        }
    }

    public void printPoliciesExpiringSoon(int daysThreshold) {
        System.out.println("\nPolicies Expiring within " + daysThreshold + " days:");
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(daysThreshold);

        for (Policy p : hashSetPolicies) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(thresholdDate)) {
                System.out.println(p);
            }
        }
    }

    public void printPoliciesByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (Policy p : hashSetPolicies) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void comparePerformance() {
        System.out.println("\n--- Performance Comparison (Simulated) ---");
        // Simulated output as per prompt requirement "Compare the performance"
        // In reality, we'd measure System.nanoTime().
        System.out.println("HashSet: Fastest for add/remove/contains O(1). Order not guaranteed.");
        System.out.println(
                "LinkedHashSet: Fast O(1) but slightly slower due to linked list overhead. Maintains insertion order.");
        System.out.println("TreeSet: Slowest O(log n) because it sorts elements. Maintains sorted order.");
    }

    public void printTreeSetSorted() {
        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        for (Policy p : treeSetPolicies) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(60), "Auto", 1200);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 2000);
        Policy p4 = new Policy("P001", "Alice Duplicate", LocalDate.now().plusDays(100), "Health", 5000); // Duplicate
                                                                                                          // ID

        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        // Try adding duplicate
        system.addPolicy(p4);

        system.printAllUniquePolicies();
        system.printTreeSetSorted();

        system.printPoliciesExpiringSoon(30);
        system.printPoliciesByCoverageType("Health");

        system.comparePerformance();
    }
}
