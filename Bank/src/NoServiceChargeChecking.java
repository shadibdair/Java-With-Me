
// This class represents a checking account without a monthly service charge.
// However, there is a minimum balance requirement below which withdrawals are not allowed.
public class NoServiceChargeChecking extends CheckingAccount {
    private static final double DEFAULT_MINIMUM_BALANCE = 50.0;  // Default minimum balance
    private double minimumBalance;

    public NoServiceChargeChecking(String accountNumber, String ownerName, String ownerId, double balance) {
        this(accountNumber, ownerName, ownerId, balance, DEFAULT_MINIMUM_BALANCE);
    }

    public NoServiceChargeChecking(String accountNumber, String ownerName, String ownerId, double balance, double minimumBalance) {
        super(accountNumber, ownerName, ownerId, balance);
        this.minimumBalance = minimumBalance;
    }


    @Override
    public void monthlyManagement() {
        // No monthly charges for this account type
    }

    @Override
    public void withdraw(double amount) throws IllegalBalance {
        if (super.getBalance() - amount < minimumBalance) {
            throw new IllegalBalance("Cannot withdraw as it would breach the minimum balance requirement.");
        }
        super.withdraw(amount);
    }
}
