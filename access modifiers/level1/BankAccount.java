/*
 * Program for Bank Account Management
 * Demonstrates access modifiers
 */
public class BankAccount {
    
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    /*
     * Constructor
     */
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter for private balance
    public double getBalance() {
        return balance;
    }

    public void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount("AC1", "Emma", 5000);
        a.displayInfo();

        System.out.println("--- Savings ---");
        SavingsAccount s = new SavingsAccount("AC2", "Dan", 7000);
        s.displaySavings();
    }
}

/*
 * Subclass SavingsAccount
 */
class SavingsAccount extends BankAccount {
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displaySavings() {
        System.out.println("Savings Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder); // Protected
        System.out.println("Balance: " + getBalance()); // Public getter
    }
}
