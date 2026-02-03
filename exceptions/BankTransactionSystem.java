package exceptions;

/**
 * Practice Problem 10: Bank Transaction System
 * 
 * Problem: withdraw method.
 * Expected:
 * - Valid -> "Withdrawal successful, new balance: X"
 * - Insufficient -> "Insufficient balance!"
 * - Negative -> "Invalid amount!"
 */

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankTransactionSystem {
    private double balance = 500.0;

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        BankTransactionSystem bank = new BankTransactionSystem();

        // Test 1: Valid
        try {
            bank.withdraw(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test 2: Insufficient
        try {
            bank.withdraw(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test 3: Negative
        try {
            bank.withdraw(-50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
