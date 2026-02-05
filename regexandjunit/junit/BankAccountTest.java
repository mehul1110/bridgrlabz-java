package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class BankAccount {
    private double balance;

    public BankAccount(double initial) {
        this.balance = initial;
    }

    public void deposit(double amt) {
        if (amt > 0)
            balance += amt;
    }

    public void withdraw(double amt) {
        if (amt > balance)
            throw new IllegalArgumentException("Insufficient funds");
        balance -= amt;
    }

    public double getBalance() {
        return balance;
    }
}

/**
 * JUnit Test Class
 */
public class BankAccountTest {
    @Test
    void testBalance() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }
}
