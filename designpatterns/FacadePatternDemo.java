package designpatterns;

/**
 * Facade Pattern implementation.
 * Provides a simplified interface to a complex subsystem.
 */

// Subsystem 1
class AccountService {
    public void getAccountDetails(String accountId) {
        System.out.println("Fetching details for Account ID: " + accountId);
    }
}

// Subsystem 2
class BalanceService {
    public boolean checkBalance(String accountId, double amount) {
        System.out.println("Checking if Account ID " + accountId + " has sufficient balance (Req: $" + amount + ")...");
        return true; // Simplified for demo
    }
}

// Subsystem 3
class TransactionService {
    public void performTransfer(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferring $" + amount + " from " + fromAccount + " to " + toAccount);
    }
}

// Facade Class coordinating systems execution
class BankFacade {
    private AccountService accountService;
    private BalanceService balanceService;
    private TransactionService transactionService;

    public BankFacade() {
        this.accountService = new AccountService();
        this.balanceService = new BalanceService();
        this.transactionService = new TransactionService();
    }

    public void transferFunds(String fromAccount, String toAccount, double amount) {
        System.out.println("\n[Facade] Initiating a Funds Transfer process!");
        accountService.getAccountDetails(fromAccount);
        accountService.getAccountDetails(toAccount);

        if (balanceService.checkBalance(fromAccount, amount)) {
            transactionService.performTransfer(fromAccount, toAccount, amount);
            System.out.println("[Facade] Transfer successful.");
        } else {
            System.out.println("[Facade] Transfer Failed!");
        }
    }
}

public class FacadePatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Facade Pattern...\n");
        System.out.println("Client interacting with only high-level simplified interface logic:");

        // Facade masks the underlying complexities of individual subsystem checks
        BankFacade adminPortal = new BankFacade();
        adminPortal.transferFunds("ACC-1001", "ACC-2002", 500.00);
    }
}
