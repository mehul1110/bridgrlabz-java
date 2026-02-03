package exceptions;

/**
 * Problem Statement 5: Rethrowing Exceptions with Custom Context
 * 
 * Problem: Process transactions. Catch exception, rethrow custom exception with context.
 */

class TransactionException extends Exception {
    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class TransactionProcessor {

    public static void main(String[] args) {
        try {
            processTransaction(-100);
        } catch (TransactionException e) {
            System.out.println("Context: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

    public static void processTransaction(double amount) throws TransactionException {
        try {
            if (amount < 0) throw new IllegalArgumentException("Negative amount");
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction ID 123 failed", e);
        }
    }
}
