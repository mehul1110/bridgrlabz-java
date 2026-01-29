package collections.map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Insurance Policy Management System (Map Implementation)
 * 
 * Requirements:
 * 1. Store Policies in:
 * - HashMap (Policy No -> Policy Details)
 * - LinkedHashMap (Insertion Order) - Note: redundant if just storing same
 * data, but requested.
 * - TreeMap (Sorted by Expiry Date)
 * 
 * 2. Retrieve/Manipulate:
 * - Retrieve by number
 * - List expiring within 30 days
 * - List by policyholder
 * - Remove expired policies
 */
public class InsurancePolicyMapSystem {

    static class Policy {
        String policyNumber;
        String policyHolderName;
        LocalDate expiryDate;

        public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return "Policy{" + policyNumber + ", " + policyHolderName + ", " + expiryDate + "}";
        }
    }

    private Map<String, Policy> policyMap = new HashMap<>(); // For main storage and retrieval by ID

    // TreeMap for sorted view: Key needs to be ExpiryDate?
    // But duplicate keys (dates) aren't allowed in standard Map.
    // The requirement says "Use TreeMap to store policies sorted by expiry date".
    // We can use ExpiryDate as key, but must handle collisions or use a composite
    // key / list of policies.
    // Or simpler: Use a Map<LocalDate, List<Policy>> or just use the Policy as Key
    // if it implements Comparable?
    // Let's assume Map<LocalDate, List<Policy>> for the TreeMap to handle multiple
    // policies expiring same day.
    private TreeMap<LocalDate, List<Policy>> policiesByExpiry = new TreeMap<>();

    // LinkedHashMap for insertion order? Maybe we just keep a separate list or
    // another map.
    // Let's just demonstrate usage.
    private Map<String, Policy> linkedPolicyMap = new LinkedHashMap<>();

    public void addPolicy(Policy p) {
        policyMap.put(p.policyNumber, p);
        linkedPolicyMap.put(p.policyNumber, p);

        policiesByExpiry.computeIfAbsent(p.expiryDate, k -> new ArrayList<>()).add(p);
    }

    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public void listExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(days);

        System.out.println("Policies Expiring within " + days + " days:");
        // TreeMap subMap is perfect here
        SortedMap<LocalDate, List<Policy>> soon = policiesByExpiry.subMap(today, true, threshold, true);

        for (List<Policy> list : soon.values()) {
            for (Policy p : list) {
                System.out.println(p);
            }
        }
    }

    public void listByPolicyHolder(String name) {
        System.out.println("Policies for " + name + ":");
        for (Policy p : policyMap.values()) {
            if (p.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        // Identify expired
        List<String> toRemove = new ArrayList<>();

        for (Policy p : policyMap.values()) {
            if (p.expiryDate.isBefore(today)) {
                toRemove.add(p.policyNumber);
                System.out.println("Removing expired policy: " + p);
            }
        }

        for (String id : toRemove) {
            Policy p = policyMap.remove(id);
            linkedPolicyMap.remove(id);
            // Remove from tree map
            List<Policy> dayPolicies = policiesByExpiry.get(p.expiryDate);
            if (dayPolicies != null) {
                dayPolicies.remove(p);
                if (dayPolicies.isEmpty()) {
                    policiesByExpiry.remove(p.expiryDate);
                }
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyMapSystem system = new InsurancePolicyMapSystem();
        system.addPolicy(new Policy("P1", "Aditi", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P2", "Rahul", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P3", "Aditi", LocalDate.now().plusDays(5))); // Same holder
        system.addPolicy(new Policy("P4", "Old", LocalDate.now().minusDays(1))); // Expired

        System.out.println("Get P2: " + system.getPolicy("P2"));

        system.listExpiringSoon(30);

        system.listByPolicyHolder("Aditi");

        system.removeExpiredPolicies();
    }
}
