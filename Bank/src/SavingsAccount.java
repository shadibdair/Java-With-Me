// This class represents a savings account that earns monthly interest based on the current balance.
public class SavingsAccount extends BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.03;  // Default interest rate of 3%
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, String ownerId, double balance) {
        this(accountNumber, ownerName, ownerId, balance, DEFAULT_INTEREST_RATE);
    }

    public SavingsAccount(String accountNumber, String ownerName, String ownerId, double balance, double interestRate) {
        super(accountNumber, ownerName, ownerId, balance);
        this.interestRate = interestRate;
    }

    // Getter and setter for interestRate
    // ... (for brevity)

    @Override
    public void monthlyManagement() {
        double interest = super.getBalance() * interestRate;
        super.deposit(interest);
    }
}