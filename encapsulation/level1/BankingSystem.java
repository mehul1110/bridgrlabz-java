import java.util.ArrayList;

/*
 * Problem 4: Banking System
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

// Concrete class 1
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 4.5;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved");
        } else {
            System.out.println("Loan application rejected");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// Concrete class 2
class CurrentAccount extends BankAccount {
    private double interestRate = 2.0;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount savings = new SavingsAccount("SAV001", "Alice", 15000);
        CurrentAccount current = new CurrentAccount("CUR001", "Bob", 5000);

        accounts.add(savings);
        accounts.add(current);

        // Polymorphism
        System.out.println("=== Account Details ===");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println("Interest: $" + account.calculateInterest());
            
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(50000);
            }
            System.out.println("-------------------------");
        }

        // Test deposit and withdraw
        System.out.println("\n=== Transactions ===");
        savings.deposit(5000);
        savings.withdraw(2000);
        savings.displayAccountInfo();
    }
}
