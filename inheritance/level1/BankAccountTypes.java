/*
 * Hierarchical Inheritance - Sample Problem 1
 * Bank Account Types
 * Demonstrates hierarchical inheritance: BankAccount -> SavingsAccount, CheckingAccount, FixedDepositAccount
 */

// Base class
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass 1
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("--- Savings Account ---");
        displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("-------------------------");
    }
}

// Subclass 2
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("--- Checking Account ---");
        displayAccountInfo();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
        System.out.println("-------------------------");
    }
}

// Subclass 3
class FixedDepositAccount extends BankAccount {
    private int tenure; // in months
    private double maturityAmount;

    public FixedDepositAccount(String accountNumber, double balance, int tenure, double maturityAmount) {
        super(accountNumber, balance);
        this.tenure = tenure;
        this.maturityAmount = maturityAmount;
    }

    public void displayAccountType() {
        System.out.println("--- Fixed Deposit Account ---");
        displayAccountInfo();
        System.out.println("Tenure: " + tenure + " months");
        System.out.println("Maturity Amount: $" + maturityAmount);
        System.out.println("-------------------------");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        // Create different account types
        SavingsAccount savings = new SavingsAccount("SAV001", 10000, 4.5);
        CheckingAccount checking = new CheckingAccount("CHK001", 5000, 2000);
        FixedDepositAccount fd = new FixedDepositAccount("FD001", 50000, 12, 52500);

        // Display all account types
        savings.displayAccountType();
        checking.displayAccountType();
        fd.displayAccountType();
    }
}
