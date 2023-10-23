
 // This class represents a high-interest savings account.
 // It has a higher minimum balance and interest rate than a regular savings account.
public class HighInterestSavings extends SavingsAccount {
    private static final double DEFAULT_MINIMUM_BALANCE = 1000.0;  // Default minimum balance
    private static final double DEFAULT_HIGH_INTEREST_RATE = 0.05;  // Default high interest rate of 5%

    private double minimumBalance;

    public HighInterestSavings(String accountNumber, String ownerName, String ownerId, double balance) {
        this(accountNumber, ownerName, ownerId, balance, DEFAULT_HIGH_INTEREST_RATE, DEFAULT_MINIMUM_BALANCE);
    }

    public HighInterestSavings(String accountNumber, String ownerName, String ownerId, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, ownerName, ownerId, balance, interestRate);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) throws IllegalBalance {
        if (super.getBalance() - amount < minimumBalance) {
            throw new IllegalBalance("Cannot withdraw as it would breach the minimum balance requirement.");
        }
        super.withdraw(amount);
    }
}