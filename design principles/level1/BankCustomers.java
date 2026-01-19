import java.util.ArrayList;

/*
 * Problem 2: Bank and Account Holders (Association)
 * Demonstrates association between bank and customers
 */

// Customer class
class Customer {
    private String name;
    private String accountNumber;
    private double balance;

    public Customer(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void viewBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public String getName() {
        return name;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount);
    }
}

// Bank class
public class BankCustomers {
    private String bankName;
    private ArrayList<Customer> customers;

    public BankCustomers(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // Open account for customer
    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println("Account opened for " + customer.getName() + " at " + bankName);
    }

    // Display all customers
    public void displayCustomers() {
        System.out.println("\n--- " + bankName + " Customers ---");
        for (Customer c : customers) {
            c.viewBalance();
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        // Create bank
        BankCustomers bank = new BankCustomers("National Bank");

        // Create customers
        Customer c1 = new Customer("Alice", "ACC001", 5000);
        Customer c2 = new Customer("Bob", "ACC002", 7500);

        // Open accounts (association)
        bank.openAccount(c1);
        bank.openAccount(c2);

        // Customer operations
        c1.deposit(1000);
        c1.viewBalance();

        // Display all customers
        bank.displayCustomers();
    }
}
