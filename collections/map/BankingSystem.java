package collections.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Implement a Banking System
 * - HashMap stores customer accounts (AccountNumber -> Balance)
 * - TreeMap sorts customers by balance? Or AccountNumber?
 * "TreeMap sorts customers by balance." -> Again, requires value sorting.
 * - Queue processes withdrawal requests.
 */
public class BankingSystem {

    private Map<Integer, Double> accounts = new HashMap<>(); // AccNo -> Balance
    private Queue<Integer> withdrawalRequests = new LinkedList<>(); // Queue of AccNos requesting withdrawal

    public void createAccount(int accNo, double balance) {
        accounts.put(accNo, balance);
    }

    public void requestWithdrawal(int accNo) {
        withdrawalRequests.offer(accNo);
    }

    public void processWithdrawals(double amount) {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalRequests.isEmpty()) {
            int acc = withdrawalRequests.poll();
            if (accounts.containsKey(acc)) {
                double bal = accounts.get(acc);
                if (bal >= amount) {
                    accounts.put(acc, bal - amount);
                    System.out.println("Processed withdrawal for " + acc + ". New Balance: " + (bal - amount));
                } else {
                    System.out.println("Insufficient funds for " + acc);
                }
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        // TreeMap<Balance, List<AccNo>> to handle duplicates
        TreeMap<Double, Integer> sorted = new TreeMap<>();
        // Note: Simple TreeMap<Double, Integer> would overwrite duplicates if multiple
        // accounts have same balance.
        // For distinctness, using a custom comparator on Keys (Account Numbers) that
        // compares Values (Balances) is tricky because the map stores keys.
        // Better: List or Stream sort. But requirement says "Use TreeMap".
        // Let's use Balance as Key, but we must handle collisions.
        // Actually, let's just use a TreeMap<Double, Integer> and acknowledge that
        // unique balances are assumed for simplicity,
        // OR better: TreeMap<Double, List<Integer>>.

        TreeMap<Double, java.util.List<Integer>> balanceMap = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            balanceMap.computeIfAbsent(entry.getValue(), k -> new java.util.ArrayList<>()).add(entry.getKey());
        }

        System.out.println(balanceMap);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000);
        bank.createAccount(102, 1000);
        bank.createAccount(103, 3000);

        bank.requestWithdrawal(101);
        bank.requestWithdrawal(103);

        bank.processWithdrawals(500);

        bank.displayAccountsSortedByBalance();
    }
}
