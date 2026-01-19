/*
 * Program for Bank Account System
 * Demonstrates static, this, final, and instanceof keywords
 */
public class BankAccountSystem {
    
    // Static variable shared across all accounts
    private static String bankName = "National Bank";
    private static int totalAccounts = 0;
    
    // Instance variables
    private String accountHolderName;
    private final String accountNumber; // Final - cannot be changed
    private double balance;

    /*
     * Constructor
     * Uses 'this' to resolve parameter name ambiguity
     */
    public BankAccountSystem(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName; // 'this' resolves ambiguity
        this.accountNumber = accountNumber; // Final variable initialization
        this.balance = balance;
        totalAccounts++; // Increment static counter
    }

    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("-------------------------");
    }

    // Safe display using instanceof check
    public static void safeDisplay(Object obj) {
        // Check if object is instance of BankAccountSystem
        if (obj instanceof BankAccountSystem) {
            BankAccountSystem account = (BankAccountSystem) obj;
            account.displayDetails();
        } else {
            System.out.println("Error: Object is not a BankAccountSystem instance");
        }
    }

    public static void main(String[] args) {
        // Create accounts
        BankAccountSystem acc1 = new BankAccountSystem("Alice", "ACC001", 5000);
        BankAccountSystem acc2 = new BankAccountSystem("Bob", "ACC002", 7500);
        
        // Display using instanceof check
        System.out.println("--- Account 1 ---");
        safeDisplay(acc1);
        
        System.out.println("--- Account 2 ---");
        safeDisplay(acc2);
        
        // Display total accounts
        System.out.println("Total Accounts: " + BankAccountSystem.getTotalAccounts());
        
        // Test instanceof with invalid object
        System.out.println("\n--- Testing with String object ---");
        safeDisplay("Not an account");
    }
}
